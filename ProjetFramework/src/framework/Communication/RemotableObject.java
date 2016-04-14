package framework.Communication;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.List;

public abstract class RemotableObject extends UnicastRemoteObject implements _RemotableObject {

	private static final long serialVersionUID = 655492702812581170L;

	private Date date;
	private Utilisateur sender;
	boolean wait;
	
	protected RemotableObject(Utilisateur u, Date date) throws RemoteException {
		super();
		this.setDate(date);
		this.setWait(false);
		this.setSender(u);
	}
	
	@Override
	public Date getDate() {
		return this.date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public void save() {
	}

	@Override
	public void send(_Shared shared) {
	}
	
	@Override
	public List<_RemotableObject> receive(_Shared shared) {
		return null;
	}
	
	public boolean isWait() {
		return this.wait;
	}

	public void setWait(boolean wait) {
		this.wait = wait;
	}

	public Utilisateur getSender() {
		return this.sender;
	}

	public void setSender(Utilisateur sender) {
		this.sender = sender;
	}

}
