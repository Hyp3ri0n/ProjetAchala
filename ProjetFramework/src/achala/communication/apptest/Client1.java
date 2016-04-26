package achala.communication.apptest;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.util.Scanner;

import achala.communication.server._Server;
import achala.communication.utilisateur.Utilisateur;
import achala.communication.utilisateur._Utilisateur;
import achala.modules.chat.Chat;

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
			
			_Server srv = (_Server)Naming.lookup("rmi://130.190.29.31/srv");
			alexis.connect(srv);
			/*srv.connect(alexis);
			
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
			
			System.out.println(url);*/
			
			/*alexis.connect(srv);
			
			System.out.println("Start ?");
			read.next();
			
			String urlLuc = srv.getSharedZone(alexis, srv.getUtilisateur("Ortiz", "Luc"));
			_Shared luc = (_Shared) Naming.lookup(urlLuc);
			System.out.println("url " + urlLuc);
			read.nextLine();
			System.out.println("Votre message : ");
			String message = read.nextLine();
			
			alexis.send(luc, new Message(alexis, message));

			System.out.println("Deconnexion ");
			alexis.disconnect();*/
			
			System.out.println("Start ?");
			read.next();
			
			_Utilisateur luc = srv.getUtilisateur("Ortiz", "Luc");
			
			Chat c = new Chat(srv, alexis, luc);
			
			c.listener(alexis);
			c.sender(alexis, "/exit");
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		//read.close();

	}

}
