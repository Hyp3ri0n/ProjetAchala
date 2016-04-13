package framework.Communication;

import java.rmi.RemoteException;
import java.util.LinkedList;
import java.util.List;

import framework.Communication.Exception.CommunicationException;

public class Correspondance extends Shared {

	private static final long serialVersionUID = -6280164128188470470L;

	private Utilisateur userA;
	private Utilisateur userB;
	
	protected Correspondance() throws RemoteException {
		super();
		setWait(false);
	}
	
	public Correspondance(Utilisateur user1, Utilisateur user2)throws RemoteException {
		this();
		this.setUserA(user1);
		this.setUserB(user2);
	}

	public Utilisateur getUserA() {
		return userA;
	}

	public void setUserA(Utilisateur userA) {
		this.userA = userA;
	}
	
	public Utilisateur getUserB() {
		return userB;
	}

	public void setUserB(Utilisateur userB) {
		this.userB = userB;
	}
	
	public void send( _RemotableObject object) throws CommunicationException, RemoteException {
		if(!this.isAllowed(object.getSender())) throw new CommunicationException("Acces denied");
		
		this.getObjects().add(object);
		this.setWait(true);
	}
	
	public List<_RemotableObject> receive(Utilisateur u) throws CommunicationException, RemoteException {
		if(!this.isAllowed(u)) throw new CommunicationException("Acces denied");
		
		List<_RemotableObject> newObjs = new LinkedList<>();
		
		if(this.isWait()){
			for(_RemotableObject o : this.getObjects()){
				if(o.isWait()){
					newObjs.add(o);
				}
			}
		}
		
		this.setWait(false);
		return newObjs;
	}
	
	public boolean isAllowed(Utilisateur u) {
		return this.getUserA().equals(u) || this.getUserB().equals(u);
	}

}
