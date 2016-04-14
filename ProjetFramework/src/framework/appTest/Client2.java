package framework.appTest;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.util.Scanner;

import framework.Communication.Message;
import framework.Communication._RemotableObject;
import framework.Communication._Shared;
import framework.Communication.Utilisateur.Utilisateur;
import framework.Communication.Utilisateur._Utilisateur;
import framework.Server._Server;

public class Client2 {

	public static void main(String[] args) {

		Scanner read = new Scanner(System.in);
		try
		{
			System.setProperty("java.security.policy", "src/policy");
			System.setProperty("java.net.SocketPermission", "src/policy");
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
