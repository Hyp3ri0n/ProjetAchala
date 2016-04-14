package framework.communication;

import java.io.File;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

import framework.communication.exception.CommunicationException;
import framework.communication.utilisateur._Utilisateur;

public interface _RemotableObject extends Remote {

	/**
	 * Retourne la date de cr�ation de l'objet courant
	 * @return Date la date de cr�ation
	 * @throws RemoteException l�ve une excpetion en cas d'echec de communication
	 */
	Date getDate() throws RemoteException;
	
	/**
	 * Sauvegarde l'objet courant
	 * @throws RemoteException l�ve une excpetion en cas d'echec de communication
	 */
	void save(File fichier) throws RemoteException;
	
	/**
	 * Envoie l'objet courant dans l'objet de partage
	 * @param shared _Shared objet de partage
	 * @throws RemoteException l�ve une exception en cas d'echec de communication
	 * @throws CommunicationException l�ve une exception en cas d'acces refus�
	 */
	void send(_Shared shared) throws RemoteException, CommunicationException;
	
	/**
	 * R�cup�re les objet en attente dans l'objet partag�
	 * @param shared _Shared l'objet de patage
	 * @return List<_RemotableObject> liste des objets en attente dans l'objet de partage
	 * @throws RemoteException l�ve une exception en cas d'echec de communication
	 */
	//List<_RemotableObject> receive(_Shared shared) throws RemoteException, CommunicationException;
	
	Object getObject() throws RemoteException;
	
	/**
	 * Indique si l'objet courant est en attente de lecture
	 * @return boolean true si l'objet est en attente, false sinon
	 * @throws RemoteException l�ve une exception en cas d'echec de communication
	 */
	boolean isWait() throws RemoteException;
	
	/**
	 * Modifie le boolean indiquant si l'objet courant est en attente de lecture
	 * @param wait boolean valeur de l'attente (true|false)
	 * @throws RemoteException l�ve une exception en cas d'echec de communication
	 */
	void setWait(boolean wait) throws RemoteException;
	
	/**
	 * R�cup�re l'emetteur de l'objet courant
	 * @return _Utilisateur emetteur de l'objet
	 * @throws RemoteException l�ve une exception en cas d'echec de communication
	 */
	_Utilisateur getSender() throws RemoteException;
}
