package framework.communication.apptest;

import java.rmi.RMISecurityManager;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import framework.communication.server.Server;
import framework.communication.server._Server;

public class LanceServer {

	public static void main(String[] args)
	{
		try
		{
			System.setProperty("java.security.policy", "src/policy");
			System.setProperty("java.net.SocketPermission", "src/policy");
			if (System.getSecurityManager() == null) {
				System.setSecurityManager(new RMISecurityManager());
			}
			
			Registry registry = LocateRegistry.createRegistry(1099);
			_Server server = new Server(registry);
			
			registry.rebind("srv", server);
			
			System.out.println("Serveur lancé !");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
