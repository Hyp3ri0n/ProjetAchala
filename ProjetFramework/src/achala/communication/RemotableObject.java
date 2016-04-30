package achala.communication;

import java.io.File;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

import achala.communication.exception.CommunicationException;
import achala.communication.utilisateur._Utilisateur;

public abstract class RemotableObject extends UnicastRemoteObject implements _RemotableObject {

	private static final long serialVersionUID = 655492702812581170L;

	private Date date;
	private _Utilisateur sender;
	boolean wait;

	/**
	 * Construit un nouvel objet a partager
	 * 
	 * @param u
	 *            _Utilisateur : createur de l'objet
	 * @param date
	 *            Date : date de creation de l'objet
	 * @throws RemoteException
	 *             leve une exception en cas d'echec de communication
	 */
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

	/**
	 * Definie la date de creation de l'objet
	 * 
	 * @param date
	 *            Date : date de creation
	 */
	private void setDate(Date date) {
		this.date = date;
	}

	@Override
	public void save(File fichier) {
		// TODO
	}

	@Override
	public void send(_Shared shared) throws RemoteException, CommunicationException {
		shared.send(this);
	}

	@Override
	public boolean isWait() {
		return this.wait;
	}

	@Override
	public void setWait(boolean wait) {
		this.wait = wait;
	}

	@Override
	public _Utilisateur getSender() {
		return this.sender;
	}

	/**
	 * Definie le createur de l'objet
	 * 
	 * @param sender
	 *            _Utilisateur : createur de l'objet
	 */
	private void setSender(_Utilisateur sender) {
		this.sender = sender;
	}

}
