package achala.communication;

import java.rmi.RemoteException;
import java.util.List;

import achala.communication.exception.CommunicationException;
import achala.communication.utilisateur._Utilisateur;

public interface _Correspondance {

	public List<_Utilisateur> getUtilisateurs() throws RemoteException;
	
	public void addUser(_Utilisateur user) throws RemoteException, CommunicationException;
	
	public void addUsers(List<_Utilisateur> users) throws RemoteException, CommunicationException;
}
