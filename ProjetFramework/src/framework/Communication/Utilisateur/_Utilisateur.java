package framework.Communication.Utilisateur;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface _Utilisateur extends Remote {

	/**
	 * Retourne une chaine unique permettant de r�f�rencer un _Utilisateur dans le server
	 * @return String chaine de connexion
	 * @throws RemoteException l�ve une exception en cas d'eched de communication
	 */
	String identify() throws RemoteException;
	
	String getNom() throws RemoteException;
	String getPrenom() throws RemoteException;
	
	void setId(int id) throws RemoteException;
}
