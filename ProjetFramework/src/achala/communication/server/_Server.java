package achala.communication.server;

import java.net.UnknownHostException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Set;

import achala.communication.utilisateur._Utilisateur;

public interface _Server extends Remote {

	
	/**
	 * Renvoi la liste de tous les _Utilisateurs pr�sent sur le serveur
	 * @return Set<_Utilisateur> liste des utilisateurs connect� au serveur
	 * @throws RemoteException l�ve une exception en cas d'echec de communication
	 */
	Set<_Utilisateur> getUtilisateurs() throws RemoteException;
	
	/**
	 * Retourne la liste des _Utilisateurs du serveur portant le nom pass� en param�tre
	 * @param name String nom d'utilisateur
	 * @return Set<_Utilisateur> liste des utilisateurs portant le nom pass� en param�tre connect� au serveur
	 * @throws RemoteException l�ve une exception en cas d'echec de communication
	 */
	Set<_Utilisateur> getUtilisateurs(String name) throws RemoteException;
	
	/**
	 * Retourne le premier _Utilisateur correspondant au nom et prenom
	 * @param nom String nom de l'utilisateur
	 * @param prenom String prenom de l'utilisateur
	 * @return _Utilisateur utilisateur correspondant
	 * @throws RemoteException
	 */
	_Utilisateur getUtilisateur(String nom, String prenom) throws RemoteException;
	
	/**
	 * Cr�e le bind d'une correspondance (espace partag� entre 2 _Utilisateur)
	 * Renvoie la chaine de connexion permettant la correspondance entre 2 personnes
	 * @param u1 _Utilisateur personne demandant la connexion
	 * @param u2 _Utilisateur personne avec qui u1 souhaite correspondre
	 * @return String chaine permettant le lookup sur le server
	 * @throws RemoteException l�ve une exception en cas d'echec de communication
	 */
	String getSharedZone(_Utilisateur u1, _Utilisateur u2) throws RemoteException, UnknownHostException;
	
	/**
	 * Cr�e le bind d'un espace partag� (espace d'un _Utilisateur)
	 * @param u1 _Utilisateur ?
	 * @return String chaine permettant le lookup sur le server
	 * @throws RemoteException l�ve une exception en cas d'echec de communication
	 */
	String getSharedZone(_Utilisateur u1) throws RemoteException, UnknownHostException;
	
	/**
	 * Ajoute un utilisateur au serveur
	 * @param u _Utilisateur utilisateur � ajouter
	 * @throws RemoteException l�ve une exception en cas d'echec de communication
	 */
	void connect(_Utilisateur u) throws RemoteException;
	
}
