package modules.chat.clients;

import java.rmi.RMISecurityManager;
import java.util.Scanner;

import achala.communication.server.Server;
import achala.communication.server._Server;
import achala.communication.utilisateur.Utilisateur;
import achala.communication.utilisateur._Utilisateur;
import modules.chat.Chat;
import modules.chat.util.Commande;

@SuppressWarnings("deprecation")
public class Client2 {

	public static void main(String[] args) {

		Scanner read = new Scanner(System.in);
		try
		{
			System.setProperty("java.security.policy", "src/achala/modules/chat/clients/policy");
			System.setProperty("java.net.SocketPermission", "src/achala/modules/chat/clients/policy");
			if (System.getSecurityManager() == null) {
				System.setSecurityManager(new RMISecurityManager());
			}
			
			_Utilisateur luc = new Utilisateur("Ortiz", "Luc");
			
			_Server srv = Server.getServer("192.168.43.84");
//			_Server srv = (_Server) Naming.lookup("rmi://192.168.43.84/srv");
			luc.connect(srv);
			
			System.out.println("Start ?");
			read.next();
			
			Chat c = new Chat(srv, luc, srv.getUtilisateurs(), "zoneTest");
			
			c.listener();
			c.sender(Commande.EXIT.getCmdLine());
		}
		catch(Exception e)
		{
			e.printStackTrace();
			read.close();
		}
		
		//read.close();

	}
}
