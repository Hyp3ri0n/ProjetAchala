package achala.communication.server;

import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Set;

import achala.communication._Shared;
import achala.communication.server.exception.ServerException;
import achala.communication.utilisateur._Utilisateur;

public interface _Server extends Remote {

	public Set<_Shared> getShares() throws RemoteException;
	
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
	 * Renvoie zone de correspondance entre u1 et u2
	 * @require logged : this.getUtilisateurs().contains(u1) && this.getUtilisateurs().contains(u2)
	 * @param u1 _Utilisateur : utilisateur demandant la connexion
	 * @param u2 _Utilisateur : utilisateur avec qui u1 souhaite correspondre
	 * @return _Shared : zone de partage entre u1 et u2
	 * @throws RemoteException leve une exception en cas d'echec de communication
	 * @throws UnknownHostException leve une exception en cas d'hote inconnu
	 * @throws ServerException leve une exception dans le cas ou u1 ou u2 ne sont pas connus
	 * @throws MalformedURLException leve une exception en cas d'URL incorrect
	 * @throws NotBoundException leve une exception en cas d'eched de bind
	 */
	public _Shared getSharedZone(_Utilisateur u1, _Utilisateur u2) throws RemoteException, UnknownHostException, ServerException, MalformedURLException, NotBoundException;
	
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
	 * @require ... : this.getUtilisateur().contains(u) == false 
	 * @param u _Utilisateur : utilisateur à ajouter
	 * @throws RemoteException leve une exception en cas d'echec de communication
	 */
	public void connect(_Utilisateur u) throws RemoteException;
	
	/**
	 * Deconnecte l'utilisateur du serveur
	 * @require ... : this.getUtilisateurs().contains(u) == true
	 * @param u _Utilisateur : utilisateur a deconnecter
	 * @throws RemoteException leve une exception en cas d'echec de communication
	 */
	public void disconnect(_Utilisateur u) throws RemoteException;
	
}
