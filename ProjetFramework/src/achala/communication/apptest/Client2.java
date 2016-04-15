package achala.communication.apptest;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.util.Scanner;

import achala.communication.Message;
import achala.communication._RemotableObject;
import achala.communication._Shared;
import achala.communication.server._Server;
import achala.communication.utilisateur.Utilisateur;
import achala.communication.utilisateur._Utilisateur;

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
			
			_Server srv = (_Server)Naming.lookup("rmi://localhost/srv");
			srv.connect(luc);
			
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
			
			corres.send(new Message(luc, message));
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		read.close();

	}
}
