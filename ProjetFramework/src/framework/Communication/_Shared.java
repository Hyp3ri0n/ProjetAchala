package framework.Communication;

import java.io.File;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import framework.Communication.Exception.CommunicationException;
import framework.Communication.Utilisateur._Utilisateur;

public interface _Shared extends Remote {
	/**
	 * Récupère l'ensemble des objets présents dans l'objet partagé
	 * @ensure ... : old(this.getObjects().size()) == this.getObjects().size()
	 * @return List<_RemotableObject> liste des objets présent dans le partage
	 * @throws RemoteException lève une exception en cas d'echec de communication
	 */
	List<_RemotableObject> getObjects() throws RemoteException;
	
	/**
	 * Envoi un objet dans l'objet partagé
	 * @ensure ... : odl(this.getObjects().size()) < this.getObjects().size()
	 * @param object _RemotableObject objet à envoyer dans le partage 
	 * @throws RemoteException lève une exception en cas d'echec de communication
	 * @throws CommunicationException lève une exception en cas d'acces refusé
	 */
	void send(_RemotableObject object) throws RemoteException, CommunicationException;
	
	/**
	 * Récupère l'ensemble des objets en attentes dans l'objet partagé
	 * @require Participe : isAllowed(u) == true
	 * @ensure ... : old(this.getObjects().size()) == this.getObjects().size()
	 * @param u _Utilisateur représente la personne souhaitant accéder  à la conversation
	 * @return List<_RemotableObject> liste des objets en attente de lecture dans le partage
	 * @throws RemoteException lève une exception en cas d'echec de communication
	 * @throws CommunicationException lève une exception en cas d'acces refusé
	 */
	List<_RemotableObject> receive(_Utilisateur u) throws RemoteException, CommunicationException;
	
	/**
	 * Sauvegarde le partage
	 * @param fichier File fichier de sauvegarde
	 * @throws RemoteException lève une exception en cas d'echec de communication
	 */
	void save(File fichier) throws RemoteException;
	
	/**
	 * Indique si l'objet de partage est en attente de lecture
	 * @return boolean true si l'objet est en attente, false sinon
	 * @throws RemoteException lève une exception en cas d'echec de communication
	 */
	public boolean isWait() throws RemoteException;
	
	/**
	 * Change l'état d'attente de l'objet
	 * @param wait boolean valeur de l'attente (true|false)
	 * @throws RemoteException lève une exception en cas d'echec de communication
	 */
	public void setWait(boolean wait) throws RemoteException;
}
