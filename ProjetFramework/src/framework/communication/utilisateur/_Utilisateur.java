package framework.communication.utilisateur;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface _Utilisateur extends Remote {

	/**
	 * Retourne une chaine unique permettant de référencer un _Utilisateur dans le server
	 * @return String chaine de connexion
	 * @throws RemoteException lève une exception en cas d'eched de communication
	 */
	String identify() throws RemoteException;
	
	/**
	 * Retourne le nom de l'utilisateur courant
	 * @return String nom de l'utilisateur
	 * @throws RemoteException
	 */
	String getNom() throws RemoteException;
	
	/**
	 * Retourne le prenom de l'utilisateur courant
	 * @return String prenom de l'utilisateur
	 * @throws RemoteException
	 */
	String getPrenom() throws RemoteException;
	
	/**
	 * Change l'identifiant de l'utilisateur
	 * @param id int nouvel identifiant
	 * @throws RemoteException
	 */
	void setId(int id) throws RemoteException;
}
