package framework.Communication;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import framework.Communication.Exception.CommunicationException;

public interface _Shared extends Remote {
	/**
	 * R�cup�re l'ensemble des objets pr�sents dans l'objet partag�
	 * @return List<_RemotableObject> liste des objets pr�sent dans le partage
	 * @throws RemoteException l�ve une exception en cas d'echec de communication
	 */
	List<_RemotableObject> getObjects() throws RemoteException;
	
	/**
	 * Envoi un objet dans l'objet partag�
	 * @param object _RemotableObject objet � envoyer dans le partage 
	 * @throws RemoteException l�ve une exception en cas d'echec de communication
	 * @throws CommunicationException l�ve une exception en cas d'acces refus�
	 */
	void send(_RemotableObject object) throws RemoteException, CommunicationException;
	
	/**
	 * R�cup�re l'ensemble des objets en attentes dans l'objet partag�
	 * @param u Utilisateur repr�sente la personne souhaitant acc�der  � la conversation
	 * @return List<_RemotableObject> liste des objets en attente de lecture dans le partage
	 * @throws RemoteException l�ve une exception en cas d'echec de communication
	 * @throws CommunicationException l�ve une exception en cas d'acces refus�
	 */
	List<_RemotableObject> receive(Utilisateur u) throws RemoteException, CommunicationException;
	
	/**
	 * Sauvegarde le partage
	 * @throws RemoteException l�ve une exception en cas d'echec de communication
	 */
	void save() throws RemoteException;
	
	/**
	 * Indique si l'objet de partage est en attente de lecture
	 * @return boolean true si l'objet est en attente, false sinon
	 * @throws RemoteException l�ve une exception en cas d'echec de communication
	 */
	public boolean isWait() throws RemoteException;
}
