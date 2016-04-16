package achala.communication.utilisateur;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import achala.communication._RemotableObject;
import achala.communication._Shared;
import achala.communication.exception.CommunicationException;
import achala.communication.server._Server;

public interface _Utilisateur extends Remote {

	/**
	 * Retourne une chaine unique permettant de referencer un utilisateur dans le serveur
	 * @return String : chaine de connexion
	 * @throws RemoteException leve une exception en cas d'echec de communication
	 */
	public String identify() throws RemoteException;
	
	/**
	 * Retourne le nom de l'utilisateur courant
	 * @return String : nom de l'utilisateur
	 * @throws RemoteException leve une exception en cas d'echec de communication
	 */
	String getNom() throws RemoteException;
	
	/**
	 * Retourne le prenom de l'utilisateur courant
	 * @return String : prenom de l'utilisateur
	 * @throws RemoteException leve une exception en cas d'echec de communication
	 */
	public String getPrenom() throws RemoteException;
	
	/**
	 * Change l'identifiant de l'utilisateur
	 * @param id int : nouvel identifiant
	 * @throws RemoteException leve une exception en cas d'echec de communication
	 */
	public void setId(int id) throws RemoteException;
	
	/**
	 * Connecte l'utilisateur courant au serveur
	 * @param server _Server : serveur ou l'utilisateur souhaite se connecter
	 * @throws RemoteException leve une exception en cas d'echec de communication
	 */
	public void connect(_Server server) throws RemoteException;
	
	public void disconnect() throws RemoteException;
	
	/**
	 * Envoi l'objet rObject dans le zone d'echange share
	 * @param share _Shared : zone d'echange
	 * @param rObject _RemotableObject : objet a envoyer
	 * @throws RemoteException leve une exception en cas d'echec de communication
	 * @throws CommunicationException leve une exception en cas d'acces refuse
	 */
	public void send(_Shared share, _RemotableObject rObject) throws RemoteException, CommunicationException;
	
	/**
	 * Recupere les objets en attente dans la zone de partage share
	 * @param share _Shared : zone de partage
	 * @return List<_RemotableObject> : liste des objets en attente de lecture
	 * @throws RemoteException leve une exception en cas d'echec de communication
	 * @throws CommunicationException leve une exception en cas d'acces refuse
	 */
	public List<_RemotableObject> receive(_Shared share) throws RemoteException, CommunicationException;
}
