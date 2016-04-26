package achala.communication.apptest;

import achala.communication.server.Server;

public class LanceServer {

	public static void main(String[] args) {
		Server.startServer("src/achala/communication/apptest/policy");
	}

}
