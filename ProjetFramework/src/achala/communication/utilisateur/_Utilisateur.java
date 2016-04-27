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
	 * Recupere l'identifiant (sur le serveur) de l'utilisateur
	 * @return int : identifiant de l'utilisateur
	 * @throws RemoteException leve une exception en cas d'echec de communication
	 */
	public int getId() throws RemoteException;
	
	/**
	 * Change l'identifiant de l'utilisateur
	 * @param id int : nouvel identifiant
	 * @throws RemoteException leve une exception en cas d'echec de communication
	 */
	public void setId(int id) throws RemoteException;
	
	/**
	 * Recupere l'adresse IP local de l'utilisateur
	 * @return String : ip locale
	 * @throws RemoteException leve une exception en cas d'echec de communication
	 */
	public String getIp() throws RemoteException;
	
	/**
	 * Connecte l'utilisateur courant au serveur
	 * @param server _Server : serveur ou l'utilisateur souhaite se connecter
	 * @throws RemoteException leve une exception en cas d'echec de communication
	 */
	public void connect(_Server server) throws RemoteException;
	
	/**
	 * Deconnecte l'utilisateur courant du serveur
	 * @throws RemoteException leve une exception en cas d'echec de communication
	 */
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
	
	/**
	 * Verifie l'egalite de l'utilisateur avec l'utilisateur passe en parametre
	 * @param u _Utilisateur : utilisateur a comparer
	 * @return boolean : true si les utilisateurs sont identique, false dans le cas contraire
	 * @throws RemoteException leve une exception en cas d'echec de communication
	 */
	public boolean equals(_Utilisateur u) throws RemoteException;
	
	/**
	 * Overide de la methode toString()
	 * impossible d'overide la mtehode toString() pour RMI
	 * @return String : representation de l'utilisateur (nom prenom)
	 * @throws RemoteException leve une exception en cas d'echec de communication
	 */
	public String toStringRemote() throws RemoteException;
}
