package achala.modules.chat.clients;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import achala.communication.server.Server;
import achala.communication.server._Server;
import achala.communication.utilisateur.Utilisateur;
import achala.communication.utilisateur._Utilisateur;
import achala.modules.chat.Chat;
import achala.modules.chat.util.Util.Cmd;

@SuppressWarnings("deprecation")
public class Client1 {

	public static void main(String[] args) {

		Scanner read = new Scanner(System.in);
		try
		{
			System.setProperty("java.security.policy", "src/achala/modules/chat/clients/policy");
			System.setProperty("java.net.SocketPermission", "src/achala/modules/chat/clients/policy");
			if (System.getSecurityManager() == null) {
				System.setSecurityManager(new RMISecurityManager());
			}

			_Utilisateur alexis = new Utilisateur("Martinier", "Alexis");
			
//			_Server srv = Server.getServer("192.168.43.84");
			_Server srv = (_Server)Naming.lookup("rmi://192.168.43.84/srv");
			alexis.connect(srv);
			
			System.out.println("Start ?");
			read.next();
			
			_Utilisateur luc = srv.getUtilisateur("Ortiz", "Luc");
			List<_Utilisateur> users = new ArrayList<_Utilisateur>();
			users.add(luc);
			Chat c = new Chat(srv, alexis, users, "Luc_Alexis");
			
			c.listener();
			c.sender(Cmd.EXIT);
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			read.close();
		}
		
		//read.close();

	}

}
