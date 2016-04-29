package achala.communication;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import achala.communication.utilisateur._Utilisateur;
import achala.datamanager.Fichier;
import achala.datamanager.exception.DMException;

public abstract class Shared extends UnicastRemoteObject implements _Shared {

	private static final long serialVersionUID = 5253539907891735969L;

	protected String rmiAdresse;
	protected String zoneName;
	// protected List<_RemotableObject> RObjectList;
	private Map<_RemotableObject, ArrayList<_Utilisateur>> RObjectList;
	protected boolean wait;

	/**
	 * Construit une zone de partage
	 * 
	 * @param rmiAdresse
	 *            String : url donnant acces au partage
	 * @throws RemoteException
	 *             leve une exception en cas d'echec de communication
	 */
	protected Shared(String rmiAdresse, String zoneName) throws RemoteException {
		super();
		this.RObjectList = Collections.synchronizedMap(new HashMap<_RemotableObject, ArrayList<_Utilisateur>>());
		this.setRmiAdresse(rmiAdresse);
		this.setZoneName(zoneName);
	}

	@Override
	public List<_RemotableObject> getObjects() throws RemoteException {
		List<_RemotableObject> objs = new ArrayList<_RemotableObject>();
		for (_RemotableObject r : this.RObjectList.keySet()) {
			objs.add(r);
		}
		return objs;
	}

	@Override
	public String getRmiAdresse() {
		return this.rmiAdresse;
	}

	public void setRmiAdresse(String rmiAdresse) {
		this.rmiAdresse = rmiAdresse;
	}

	@Override
	public void save(Fichier fichier) {
		try {
			fichier.save();
		} catch (DMException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setWait(boolean wait) throws RemoteException {
		this.wait = wait;
	}

	// need to be synchrnoized for ThreadSafe
	@Override
	public synchronized boolean isWait() throws RemoteException {
		for (_RemotableObject o : this.getObjects()) {
			if (o.isWait()) {
				this.setWait(true);
				break;
			}
		}
		return this.wait;
	}

	/**
	 * recupere l'objet _Shared partage par l'url
	 * 
	 * @param url
	 *            String : url du partage
	 * @return _Shared : objet partage
	 * @throws MalformedURLException
	 *             leve une exception en cas d'url incorrect
	 * @throws RemoteException
	 *             leve une exception en cas d'echec de communication
	 * @throws NotBoundException
	 *             leve une erreur en cas d'erreur de bind
	 */
	public static _Shared getShared(String url) throws MalformedURLException, RemoteException, NotBoundException {
		return (_Shared) Naming.lookup(url);
	}

	protected Map<_RemotableObject, ArrayList<_Utilisateur>> getRObjectList() {
		return RObjectList;
	}

	protected void setRObjectList(Map<_RemotableObject, ArrayList<_Utilisateur>> rObjectList) {
		RObjectList = rObjectList;
	}

	@Override
	public String getZoneName() {
		return zoneName;
	}

	protected void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}
}
