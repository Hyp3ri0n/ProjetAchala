package achala.communication.apptest;

import java.rmi.RMISecurityManager;
import java.util.Scanner;

import achala.communication.Message;
import achala.communication._RemotableObject;
import achala.communication._Shared;
import achala.communication.server.Server;
import achala.communication.server._Server;
import achala.communication.utilisateur.Utilisateur;
import achala.communication.utilisateur._Utilisateur;

@SuppressWarnings("deprecation")
public class Client1 {

	public static void main(String[] args) {

		Scanner read = new Scanner(System.in);
		try {
			System.setProperty("java.security.policy", "src/achala/communication/apptest/policy");
			System.setProperty("java.net.SocketPermission", "src/achala/communication/apptest/policy");
			if (System.getSecurityManager() == null) {
				System.setSecurityManager(new RMISecurityManager());
			}

			System.out.println("Adresse IP du serveur : ");
			String ip = read.next();

			_Utilisateur alexis = new Utilisateur("Martinier", "Alexis");

			// _Server srv = (_Server) Naming.lookup("rmi://" + ip + "/srv");
			_Server srv = Server.getServer(ip);

			alexis.connect(srv);

			System.out.println("Start ?");
			read.next();

			_Shared corres = srv.getSharedZone(alexis, "Zone42");

			System.out.println("Votre message : ");
			String message = read.next();

			corres.send(new Message(alexis, message));
			
			System.out.println("Votre correspondant a repondu : ");
			for (_RemotableObject o : corres.receive(alexis)) {
				System.out.println(o.getObject().toString());
			}

		} catch (Exception e) {
			e.printStackTrace();
			read.close();
		}

		read.close();

	}

}
