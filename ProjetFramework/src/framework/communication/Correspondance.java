package framework.communication;

import java.rmi.RemoteException;
import java.util.LinkedList;
import java.util.List;

import framework.communication.exception.CommunicationException;
import framework.communication.utilisateur._Utilisateur;

public class Correspondance extends Shared {

	private static final long serialVersionUID = -6280164128188470470L;

	private _Utilisateur userA;
	private _Utilisateur userB;
	
	protected Correspondance(String rmiAdresse) throws RemoteException {
		super(rmiAdresse);
		setWait(false);
	}
	
	public Correspondance(_Utilisateur user1, _Utilisateur user2, String rmiAdresse)throws RemoteException {
		this(rmiAdresse);
		this.setUserA(user1);
		this.setUserB(user2);
	}

	public _Utilisateur getUserA() {
		return userA;
	}

	private void setUserA(_Utilisateur userA) {
		this.userA = userA;
	}
	
	public _Utilisateur getUserB() {
		return userB;
	}

	private void setUserB(_Utilisateur userB) {
		this.userB = userB;
	}
	
	public void send( _RemotableObject object) throws CommunicationException, RemoteException {
		if(!this.isAllowed(object.getSender())) throw new CommunicationException("Acces denied");
		
		if(!this.getObjects().contains(object)) {
			this.getObjects().add(object);
			this.setWait(true);
		}
	}
	
	public List<_RemotableObject> receive(_Utilisateur u) throws CommunicationException, RemoteException {
		if(!this.isAllowed(u)) throw new CommunicationException("Acces denied");
		
		List<_RemotableObject> newObjs = new LinkedList<>();
		
		if(this.isWait()){
			for(_RemotableObject o : this.getObjects()){
				if(o.isWait()){
					newObjs.add(o);
					o.setWait(false);
				}
			}
		}
		
		this.setWait(false);
		return newObjs;
	}
	
	public boolean isAllowed(_Utilisateur u) throws RemoteException {
		return this.getUserA().equals(u) || this.getUserB().equals(u);
	}

}
