package achala.communication.apptest;

import achala.communication.server.Server;
import achala.communication.server._Server;
import achala.communication.utilisateur.Utilisateur;
import achala.communication.utilisateur._Utilisateur;

public class LanceServer {

	public static void main(String[] args) {
		Server.startServer("src/achala/communication/apptest/policy");

		try {
			_Server srv = Server.getServer("192.168.43.84");
			_Utilisateur user = new Utilisateur("Serveur", "Init", srv);
			srv.getSharedZone(user, "Zone51");
			srv.getSharedZone(user, "Zone42");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
