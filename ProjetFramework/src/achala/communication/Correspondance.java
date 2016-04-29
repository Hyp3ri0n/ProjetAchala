package achala.communication;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import achala.communication.exception.CommunicationException;
import achala.communication.utilisateur._Utilisateur;

public class Correspondance extends Shared implements _Correspondance {

	private static final long serialVersionUID = -6280164128188470470L;

	protected List<_Utilisateur> users;

	/**
	 * Construit une correspondance
	 * 
	 * @param rmiAdresse
	 *            String : url permattant l'acces a la correspondance
	 * @throws RemoteException
	 *             leve une excpetion en cas d'echec de communication
	 */
	protected Correspondance(String rmiAdresse, String zoneName) throws RemoteException {
		super(rmiAdresse, zoneName);
		setWait(false);
	}

	/**
	 * Construit une correspondance entre les utilisateurs u1 et u2
	 * 
	 * @param users
	 *            List<_Utilisateur> : utilisateurs de la correspondance
	 * @param rmiAdresse
	 *            String : url permattant l'acces a la correspondance
	 * @param zoneName
	 *            String : nom de la zone de partage
	 * @throws RemoteException
	 *             leve une excpetion en cas d'echec de communication
	 */
	public Correspondance(List<_Utilisateur> users, String rmiAdresse, String zoneName) throws RemoteException {
		this(rmiAdresse, zoneName);
		this.setUtilisateurs(users);
	}

	@Override
	public List<_Utilisateur> getUtilisateurs() {
		return users;
	}

	protected void setUtilisateurs(List<_Utilisateur> users) {
		this.users = users;
	}

	@Override
	public void addUsers(List<_Utilisateur> users) throws RemoteException {
		for (_Utilisateur u : users) {
			if (!this.getUtilisateurs().contains(u)) {
				this.getUtilisateurs().add(u);
			}
		}
	}

	@Override
	public void addUser(_Utilisateur user) throws RemoteException, CommunicationException {
		if (this.getUtilisateurs().contains(user))
			throw new CommunicationException("Correspondance : " + user.toStringRemote() + " already recorded");
		this.getUtilisateurs().add(user);
	}

	@Override
	public void removeUser(_Utilisateur user) throws RemoteException, CommunicationException {
		if (!this.getUtilisateurs().contains(user))
			throw new CommunicationException("Correspondance : " + user.toStringRemote() + " isn't recorded");

		for (_RemotableObject o : this.getRObjectList().keySet()) {
			if (this.getRObjectList().get(o).contains(user)) {
				this.getRObjectList().get(o).remove(user);
			}
		}

		this.getUtilisateurs().remove(user);
	}

	// need to be synchronized for ThreadSafe
	@Override
	public synchronized void send(_RemotableObject object) throws CommunicationException, RemoteException {
		if (!this.isAllowed(object.getSender()))
			throw new CommunicationException("Acces denied");

		if (!this.getObjects().contains(object)) {
			ArrayList<_Utilisateur> _users = new ArrayList<>(this.getUtilisateurs());
			_users.remove(object.getSender());
			this.getRObjectList().put(object, _users);
			// this.getObjects().add(object);
			this.setWait(true);
		}
	}

	@Override
	public List<_RemotableObject> receive(_Utilisateur u) throws CommunicationException, RemoteException {
		if (!this.isAllowed(u))
			throw new CommunicationException("Acces denied");

		List<_RemotableObject> newObjs = new LinkedList<>();

		for (_RemotableObject o : this.getRObjectList().keySet()) {
			if (this.getRObjectList().get(o).contains(u)) {
				newObjs.add(o);
				this.getRObjectList().get(o).remove(u);
			}
		}

		// if(this.isWait()){
		// for(_RemotableObject o : this.getRObjectList().keySet()){
		// if(o.isWait() && (!o.getSender().equals(u))){
		// newObjs.add(o);
		// o.setWait(false);
		// }
		// if(this.getRObjectList().get(o).contains(u)){
		// newObjs.add(o);
		// this.getRObjectList().get(o).remove(u);
		// o.setWait(false);
		// }
		// }
		// }

		// this.setWait(false);
		return newObjs;
	}

	@Override
	public boolean isAllowed(_Utilisateur u) throws RemoteException {
		return this.getUtilisateurs().contains(u);
	}

}
