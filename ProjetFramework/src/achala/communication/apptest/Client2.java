package achala.communication.apptest;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.util.Scanner;

import achala.communication.server._Server;
import achala.communication.utilisateur.Utilisateur;
import achala.communication.utilisateur._Utilisateur;
import achala.modules.chat.Chat;

@SuppressWarnings("deprecation")
public class Client2 {

	public static void main(String[] args) {

		Scanner read = new Scanner(System.in);
		try
		{
			System.setProperty("java.security.policy", "src/achala/communication/policy");
			System.setProperty("java.net.SocketPermission", "src/achala/communication/policy");
			if (System.getSecurityManager() == null) {
				System.setSecurityManager(new RMISecurityManager());
			}
			
			_Utilisateur luc = new Utilisateur("Ortiz", "Luc");
			
			_Server srv = (_Server)Naming.lookup("rmi://192.168.43.84/srv");
			luc.connect(srv);
			/*srv.connect(luc);
			
			System.out.println("Start ?");
			read.next();
			
			String url = srv.getSharedZone(luc, srv.getUtilisateur("Martinier", "Alexis"));
			_Shared corres = (_Shared)Naming.lookup(url);
			
			
			System.out.println("Votre correspondant a envoyé : ");
			for(_RemotableObject o : corres.receive(luc))
			{
				System.out.println(o.getObject().toString());
			}
			
			String message = read.next();
			
			corres.send(new Message(luc, message));*/
			
			/*luc.connect(srv);
			
			System.out.println("Start ?");
			read.next();
			
			String urlAlexis = srv.getSharedZone(luc, srv.getUtilisateur("Martinier", "Alexis"));
			_Shared alexis = (_Shared)Naming.lookup(urlAlexis);
			System.out.println("url " + urlAlexis);
			
			System.out.println("Votre correspondant a envoyé : ");
			for(_RemotableObject o : luc.receive(alexis))
			{
				System.out.println(o.getObject().toString());
			}
			System.out.println("Deconnexion ");
			//luc.disconnect();*/
			
			System.out.println("Start ?");
			read.next();
			
			_Utilisateur alexis = srv.getUtilisateur("Martinier", "Alexis");
			
			Chat c = new Chat(srv, luc, alexis);
			
			c.listener(luc);
			c.sender(luc, "exit");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			read.close();
		}
		
		//read.close();

	}
}
