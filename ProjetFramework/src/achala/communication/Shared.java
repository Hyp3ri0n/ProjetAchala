package achala.communication;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import achala.datamanager.Fichier;
import achala.datamanager.exception.DMException;

public abstract class Shared extends UnicastRemoteObject implements _Shared {

	private static final long serialVersionUID = 5253539907891735969L;

	private String rmiAdresse;
	protected List<_RemotableObject> RObjectList;
	protected boolean wait;
	
	/**
	 * Construit une zone de partage
	 * @param rmiAdresse String : url donnant acces au partage
	 * @throws RemoteException leve une exception en cas d'echec de communication
	 */
	protected Shared(String rmiAdresse) throws RemoteException {
		super();
		this.RObjectList = Collections.synchronizedList(new LinkedList<_RemotableObject>());
		this.setRmiAdresse(rmiAdresse);
	}
	
	public List<_RemotableObject> getObjects() throws RemoteException{
		return this.RObjectList;
	}
	
	public String getRmiAdresse() {
		return this.rmiAdresse;
	}

	public void setRmiAdresse(String rmiAdresse) {
		this.rmiAdresse = rmiAdresse;
	}

	public void save(Fichier fichier) {
		try {
			fichier.save();
		} catch (DMException e) {
			e.printStackTrace();
		}
	}
	
	public void setWait(boolean wait) throws RemoteException {
		this.wait = wait;
	}
	
	// need to be synchrnoized for ThreadSafe
	public synchronized boolean isWait() throws RemoteException {
		for(_RemotableObject o : this.getObjects()){
			if(o.isWait()) {
				this.setWait(true);
				break;
			}
		}
		return this.wait;
	}
	
	/**
	 * recupere l'objet _Shared partage par l'url
	 * @param url String : url du partage
	 * @return _Shared : objet partage
	 * @throws MalformedURLException leve une exception en cas d'url incorrect
	 * @throws RemoteException leve une exception en cas d'echec de communication
	 * @throws NotBoundException leve une erreur en cas d'erreur de bind
	 */
	public static _Shared getShared(String url) throws MalformedURLException, RemoteException, NotBoundException {
		return (_Shared) Naming.lookup(url);
	}

}
