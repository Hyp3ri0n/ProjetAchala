//package achala.communication.apptest;
//
//import java.rmi.Naming;
//import java.rmi.RMISecurityManager;
//import java.util.Scanner;
//
//import achala.communication.Message;
//import achala.communication._Shared;
//import achala.communication.server._Server;
//import achala.communication.utilisateur.Utilisateur;
//import achala.communication.utilisateur._Utilisateur;
//
//@SuppressWarnings("deprecation")
//public class Client1 {
//
//	public static void main(String[] args) {
//
//		Scanner read = new Scanner(System.in);
//		try
//		{
//			System.setProperty("java.security.policy", "src/achala/communication/apptest/policy");
//			System.setProperty("java.net.SocketPermission", "src/achala/communication/apptest/policy");
//			if (System.getSecurityManager() == null) {
//				System.setSecurityManager(new RMISecurityManager());
//			}
//
//			_Utilisateur alexis = new Utilisateur("Martinier", "Alexis");
//			
//			_Server srv = (_Server)Naming.lookup("rmi://130.190.29.31/srv");
//			alexis.connect(srv);
//			//srv.connect(alexis);
//			
//			System.out.println("Start ?");
//			read.next();			
//			
//			_Shared corres = srv.getSharedZone(alexis, srv.getUtilisateur("Ortiz", "Luc"));
//			
//			System.out.println("Votre message : ");
//			String message = read.next();
//			
//			corres.send(new Message(alexis, message));
//			
//			
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//			read.close();
//		}
//		
//		//read.close();
//
//	}
//
//}
