package framework.Communication;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

public interface _RemotableObject extends Remote {

	/**
	 * Retourne la date de création de l'objet
	 * @return Date la date de création
	 */
	Date getDate();
	
	/**
	 * Sauvegarde l'objet
	 */
	void save();
	
	/**
	 * Envoie l'objet dans l'objet partage
	 * @param shared _Shared objet de partage
	 * @throws RemoteException lève une exception en cas d'echec de communication
	 */
	void send(_Shared shared) throws RemoteException;
	
	/**
	 * Récupère les objet en attente dans l'objet partagé
	 * @param shared _Shared l'objet de patage
	 * @return List<_RemotableObject> liste des objets en attente dans l'objet de partage
	 * @throws RemoteException lève une exception en cas d'echec de communication
	 */
	List<_RemotableObject> receive(_Shared shared) throws RemoteException;
	
	/**
	 * 
	 * @return
	 * @throws
	 */
	boolean isWait() throws RemoteException;
	
	void setWait(boolean wait);
	
	Utilisateur getSender();
}
