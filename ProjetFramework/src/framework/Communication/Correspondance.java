package framework.Communication;

import java.rmi.RemoteException;

public class Correspondance extends Shared {

	private static final long serialVersionUID = -6280164128188470470L;

	private Utilisateur userA;
	private Utilisateur userB;
	private boolean wait;
	
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
	
	public boolean isWait() {
		return wait;
	}

	public void setWait(boolean wait) {
		this.wait = wait;
	}

	public void send(_RemotableObject object) {
		this.RObjectList.add(object);
		this.setWait(true);
	}
	
	public RemotableObject receive() {
		this.setWait(false);
		return null;
	}

}
