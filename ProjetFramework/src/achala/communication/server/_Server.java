package achala.communication.server;

import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import achala.communication._Shared;
import achala.communication.exception.CommunicationException;
import achala.communication.server.exception.ServerException;
import achala.communication.utilisateur._Utilisateur;

public interface _Server extends Remote {

	/**
	 * Renvoi la liste des zones partagees sur le serveur
	 * 
	 * @return List<_Shared> : liste des zones partagees sur le serveur
	 * @throws RemoteException
	 *             leve une exception en cas d'echec de communication
	 */
	public List<_Shared> getShares() throws RemoteException;

	/**
	 * Renvoi la liste de tous les utilisateurs present sur le serveur
	 * 
	 * @return Set<_Utilisateur> : liste des utilisateurs connecte au serveur
	 * @throws RemoteException
	 *             leve une exception en cas d'echec de communication
	 */
	public List<_Utilisateur> getUtilisateurs() throws RemoteException;

	/**
	 * Retourne la liste des utilisateurs du serveur portant le nom passe en
	 * parametre
	 * 
	 * @param name
	 *            String : nom d'utilisateur
	 * @return Set<_Utilisateur> : liste des utilisateurs portant le nom passe
	 *         en parametre connecte au serveur
	 * @throws RemoteException
	 *             leve une exception en cas d'echec de communication
	 */
	public List<_Utilisateur> getUtilisateurs(String name) throws RemoteException;

	/**
	 * Retourne le premier utilisateur correspondant au nom et prenom
	 * 
	 * @param nom
	 *            String : nom de l'utilisateur
	 * @param prenom
	 *            String : prenom de l'utilisateur
	 * @return _Utilisateur : utilisateur correspondant
	 * @throws RemoteException
	 *             leve une excpetion en cas d'echec de communication
	 */
	public _Utilisateur getUtilisateur(String nom, String prenom) throws RemoteException;

	/**
	 * Cree le bind d'une correspondance Renvoie zone de correspondance entre
	 * les utilisateurs
	 * 
	 * @require logged : this.getUtilisateurs().contains(user)
	 * @param user
	 *            _Utilisateur : utilisateur souhaitant acceder a la zone de
	 *            partage
	 * @param zoneName
	 *            String : nom de la zone de partage souhaite
	 * @return _Shared : zone de partage correspondant au nom
	 * @throws RemoteException
	 *             leve une exception en cas d'echec de communication
	 * @throws UnknownHostException
	 *             leve une exception en cas d'hote inconnu
	 * @throws ServerException
	 *             leve une exception dans le cas ou u1 ou u2 ne sont pas connus
	 * @throws MalformedURLException
	 *             leve une exception en cas d'URL incorrect
	 * @throws NotBoundException
	 *             leve une exception en cas d'eched de bind
	 */
	public _Shared getSharedZone(_Utilisateur user, String zoneName)
			throws RemoteException, ServerException, MalformedURLException, NotBoundException, CommunicationException;

	/**
	 * Ajoute l'utilisateur u au serveur
	 * 
	 * @require ... : this.getUtilisateur().contains(u) == false
	 * @param u
	 *            _Utilisateur : utilisateur à ajouter
	 * @throws RemoteException
	 *             leve une exception en cas d'echec de communication
	 * @throws CommunicationException
	 *             leve une exception en cas d'echec de connexion
	 */
	public void connect(_Utilisateur u) throws RemoteException, CommunicationException;

	/**
	 * Deconnecte l'utilisateur du serveur
	 * 
	 * @require ... : this.getUtilisateurs().contains(u) == true
	 * @param u
	 *            _Utilisateur : utilisateur a deconnecter
	 * @throws RemoteException
	 *             leve une exception en cas d'echec de communication
	 */
	public void disconnect(_Utilisateur u) throws RemoteException;

	/**
	 * Verifie l'existance d'une zone partage sur le serveur
	 * 
	 * @param zoneName
	 *            String : nom de la zone de partage
	 * @return boolean : true si la zone existe deja, false dans le cas
	 *         contraire
	 * @throws RemoteException
	 *             leve une exception en cas d'echec de communication
	 */
	public boolean alreadyExist(String zoneName) throws RemoteException;

}
