package achala.communication;

import java.rmi.RemoteException;
import java.util.List;

import achala.communication.utilisateur._Utilisateur;

public interface _Correspondance {

	/**
	 * Retourne la liste des utilisateurs de la correspondance
	 * 
	 * @return List<_Utilisateur> : liste des utilisateurs de la correspondance
	 * @throws RemoteException
	 *             leve une exception en cas d'echec de communication
	 */
	public List<_Utilisateur> getUtilisateurs() throws RemoteException;

}
