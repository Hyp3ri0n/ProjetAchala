package framework.communication.apptest;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.util.Scanner;

import framework.communication.Message;
import framework.communication._Shared;
import framework.communication.server._Server;
import framework.communication.utilisateur.Utilisateur;
import framework.communication.utilisateur._Utilisateur;

public class Client1 {

	public static void main(String[] args) {

		Scanner read = new Scanner(System.in);
		try
		{
			System.setProperty("java.security.policy", "src/policy");
			System.setProperty("java.net.SocketPermission", "src/policy");
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
