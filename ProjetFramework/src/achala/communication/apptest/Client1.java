package achala.communication.apptest;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.util.Scanner;

import achala.communication.Message;
import achala.communication._Shared;
import achala.communication.server._Server;
import achala.communication.utilisateur.Utilisateur;
import achala.communication.utilisateur._Utilisateur;

public class Client1 {

	public static void main(String[] args) {

		Scanner read = new Scanner(System.in);
		try
		{
			System.setProperty("java.security.policy", "src/achala/communication/policy");
			System.setProperty("java.net.SocketPermission", "src/achala/communication/policy");
			if (System.getSecurityManager() == null) {
				System.setSecurityManager(new RMISecurityManager());
			}

			_Utilisateur alexis = new Utilisateur("Martinier", "Alexis");
			
			_Server srv = (_Server)Naming.lookup("rmi://127.0.0.1/srv");
			srv.connect(alexis);
			
			System.out.println("Start ?");
			read.next();
			
			for(_Utilisateur u : srv.getUtilisateurs())
			{
				System.out.println(u.toString());
			}
			
			
			String url = srv.getSharedZone(alexis, srv.getUtilisateur("Ortiz", "Luc"));
			_Shared corres = (_Shared)Naming.lookup(url);
			
			System.out.println("Votre message : ");
			String message = read.next();
			
			corres.send(new Message(alexis, message));
			
			System.out.println(url);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		read.close();

	}

}
