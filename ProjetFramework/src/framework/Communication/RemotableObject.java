package framework.Communication;

import java.io.File;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

import framework.Communication.Exception.CommunicationException;
import framework.Communication.Utilisateur._Utilisateur;

public abstract class RemotableObject extends UnicastRemoteObject implements _RemotableObject {

	private static final long serialVersionUID = 655492702812581170L;

	private Date date;
	private _Utilisateur sender;
	boolean wait;
	
	protected RemotableObject(_Utilisateur u, Date date) throws RemoteException {
		super();
		this.setDate(date);
		this.setWait(false);
		this.setSender(u);
	}
	
	@Override
	public Date getDate() {
		return this.date;
	}
	
	private void setDate(Date date) {
		this.date = date;
	}

	@Override
	public void save(File fichier) {
		//TODO
	}

	@Override
	public void send(_Shared shared) throws RemoteException, CommunicationException {
		shared.send(this);
	}
	
	public boolean isWait() {
		return this.wait;
	}

	public void setWait(boolean wait) {
		this.wait = wait;
	}

	public _Utilisateur getSender() {
		return this.sender;
	}

	private void setSender(_Utilisateur sender) {
		this.sender = sender;
	}

}
