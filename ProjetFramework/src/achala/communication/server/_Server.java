package achala.communication.server;

import java.net.UnknownHostException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Set;

import achala.communication.utilisateur._Utilisateur;

public interface _Server extends Remote {

	
	/**
	 * Renvoi la liste de tous les utilisateurs present sur le serveur
	 * @return Set<_Utilisateur> : liste des utilisateurs connecte au serveur
	 * @throws RemoteException leve une exception en cas d'echec de communication
	 */
	public Set<_Utilisateur> getUtilisateurs() throws RemoteException;
	
	/**
	 * Retourne la liste des utilisateurs du serveur portant le nom passe en parametre
	 * @param name String : nom d'utilisateur
	 * @return Set<_Utilisateur> : liste des utilisateurs portant le nom passe en parametre connecte au serveur
	 * @throws RemoteException leve une exception en cas d'echec de communication
	 */
	public Set<_Utilisateur> getUtilisateurs(String name) throws RemoteException;
	
	/**
	 * Retourne le premier utilisateur correspondant au nom et prenom
	 * @param nom String : nom de l'utilisateur
	 * @param prenom String : prenom de l'utilisateur
	 * @return _Utilisateur : utilisateur correspondant
	 * @throws RemoteException leve une excpetion en cas d'echec de communication
	 */
	public _Utilisateur getUtilisateur(String nom, String prenom) throws RemoteException;
	
	/**
	 * Cree le bind d'une correspondance (espace partage entre u1 et u2)
	 * Renvoie la chaine de connexion permettant la correspondance entre u1 et u2
	 * @param u1 _Utilisateur : utilisateur demandant la connexion
	 * @param u2 _Utilisateur : utilisateur avec qui u1 souhaite correspondre
	 * @return String : chaine permettant le lookup sur le server
	 * @throws RemoteException leve une exception en cas d'echec de communication
	 */
	public String getSharedZone(_Utilisateur u1, _Utilisateur u2) throws RemoteException, UnknownHostException;
	
	/**
	 * Cree le bind d'un espace partage par l'utilisateur u
	 * Renvoie la chaine de connexion permettant d'acceder a cette zone
	 * @param u _Utilisateur : ?
	 * @return String chaine permettant le lookup sur le server
	 * @throws RemoteException leve une exception en cas d'echec de communication
	 */
	public String getSharedZone(_Utilisateur u) throws RemoteException, UnknownHostException;
	
	/**
	 * Ajoute l'utilisateur u au serveur
	 * @param u _Utilisateur : utilisateur à ajouter
	 * @throws RemoteException leve une exception en cas d'echec de communication
	 */
	public void connect(_Utilisateur u) throws RemoteException;
	
	public void disconnect(_Utilisateur u) throws RemoteException;
	
}
