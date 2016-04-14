package framework.Communication;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import framework.Communication.Exception.CommunicationException;

public interface _Shared extends Remote {
	/**
	 * Récupère l'ensemble des objets présents dans l'objet partagé
	 * @return List<_RemotableObject> liste des objets présent dans le partage
	 * @throws RemoteException lève une exception en cas d'echec de communication
	 */
	List<_RemotableObject> getObjects() throws RemoteException;
	
	/**
	 * Envoi un objet dans l'objet partagé
	 * @param object _RemotableObject objet à envoyer dans le partage 
	 * @throws RemoteException lève une exception en cas d'echec de communication
	 * @throws CommunicationException lève une exception en cas d'acces refusé
	 */
	void send(_RemotableObject object) throws RemoteException, CommunicationException;
	
	/**
	 * Récupère l'ensemble des objets en attentes dans l'objet partagé
	 * @param u Utilisateur représente la personne souhaitant accéder  à la conversation
	 * @return List<_RemotableObject> liste des objets en attente de lecture dans le partage
	 * @throws RemoteException lève une exception en cas d'echec de communication
	 * @throws CommunicationException lève une exception en cas d'acces refusé
	 */
	List<_RemotableObject> receive(Utilisateur u) throws RemoteException, CommunicationException;
	
	/**
	 * Sauvegarde le partage
	 * @throws RemoteException lève une exception en cas d'echec de communication
	 */
	void save() throws RemoteException;
	
	/**
	 * Indique si l'objet de partage est en attente de lecture
	 * @return boolean true si l'objet est en attente, false sinon
	 * @throws RemoteException lève une exception en cas d'echec de communication
	 */
	public boolean isWait() throws RemoteException;
}
