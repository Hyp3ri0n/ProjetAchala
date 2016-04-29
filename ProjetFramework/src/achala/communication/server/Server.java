package achala.communication.server;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import achala.communication.Correspondance;
import achala.communication._Shared;
import achala.communication.exception.CommunicationException;
import achala.communication.server.exception.ServerException;
import achala.communication.utilisateur._Utilisateur;

@SuppressWarnings("deprecation")
public class Server extends UnicastRemoteObject implements _Server {

	private static final long serialVersionUID = -1500108230668609512L;

	private static int idUser = 0;

	private List<_Utilisateur> users;
	private List<_Shared> shares;
	private String ip;

	/**
	 * Constructeur d'un serveur
	 * 
	 * @param r
	 *            Registry registre du serveur
	 * @throws RemoteException
	 *             leve une exception en cas d'echec de communication
	 * @throws UnknownHostException
	 *             leve une exception en cas d'adresse inconnue
	 */
	private Server() throws RemoteException, UnknownHostException {
		super();
		this.users = new ArrayList<>();
		this.shares = new ArrayList<>();
		this.ip = InetAddress.getLocalHost().getHostAddress();
		System.out.println("Server run at : " + ip);
	}

	private static int getIdUser() {
		setIdUser(idUser + 1);
		return Server.idUser;
	}

	private static void setIdUser(int idUser) {
		Server.idUser = idUser;
	}

	@Override
	public List<_Shared> getShares() {
		return this.shares;
	}

	public void setShares(List<_Shared> shares) {
		this.shares = shares;
	}

	@Override
	public List<_Utilisateur> getUtilisateurs() throws RemoteException {
		return this.users;
	}

	@Override
	public List<_Utilisateur> getUtilisateurs(String name) throws RemoteException {
		List<_Utilisateur> _users = new ArrayList<>();
		for (_Utilisateur u : this.getUtilisateurs()) {
			if (u.getNom().equals(name)) {
				_users.add(u);
			}
		}
		return _users;
	}

	@Override
	public _Utilisateur getUtilisateur(String nom, String prenom) throws RemoteException {
		for (_Utilisateur u : this.getUtilisateurs()) {
			if (u.getNom().equals(nom) && u.getPrenom().equals(prenom)) {
				return u;
			}
		}
		return null;
	}

	@Override
	public _Shared getSharedZone(_Utilisateur user, String zoneName)
			throws RemoteException, ServerException, MalformedURLException, NotBoundException, CommunicationException {
		if (!this.getUtilisateurs().contains(user))
			throw new ServerException("Server : " + user.toStringRemote() + " isn't recorded on this server");

		String url = this.getRMIShared(user, zoneName);
		if (url.equals("")) {
			url += "rmi://";
			url += this.ip;
			url += "/";
			url += zoneName;

			List<_Utilisateur> users = new ArrayList<>();
			users.add(user);
			_Shared s = new Correspondance(users, url, zoneName);
			this.getShares().add(s);
			LocateRegistry.getRegistry().rebind(zoneName, s);
		}

		_Shared _s = (_Shared) Naming.lookup(url);
		if (!_s.isAllowed(user))
			throw new CommunicationException(user.toStringRemote() + " Acces denied to " + _s.getZoneName());

		return _s;
	}

	@Override
	public void addSharedZone(_Utilisateur user, _Shared zone)
			throws RemoteException, MalformedURLException, NotBoundException, CommunicationException, ServerException {
		if (!this.getUtilisateurs().contains(user))
			throw new ServerException("Server : " + user.toStringRemote() + " isn't recorded on this server");
		
		zone.addUsers(this.getUtilisateurs());
		this.getShares().add(zone);		
	}
	
	@Override
	public void connect(_Utilisateur u) throws RemoteException, CommunicationException {
		if (this.getUtilisateurs().contains(u))
			return;

		u.setId(getIdUser());
		this.getUtilisateurs().add(u);

		for (_Shared s : this.getShares()) {
			s.addUser(u);
		}

		System.out.println("Connexion : " + u.toStringRemote());
	}

	@Override
	public void disconnect(_Utilisateur u) throws RemoteException {
		if (!this.getUtilisateurs().contains(u))
			return;

		try {
			for (_Shared s : this.getShares()) {
				if (s.getUtilisateurs().contains(u)) {
					s.removeUser(u);
				}
			}

			System.out.println("Deconnexion : " + u.toStringRemote());
			this.getUtilisateurs().remove(u);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public boolean alreadyExist(String zoneName) throws RemoteException {
		for (_Shared s : this.getShares()) {
			if (s.getZoneName().equals(zoneName)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String getRMIShared(_Utilisateur user, String zoneName) throws RemoteException {
		String url = "";

		for (_Shared s : this.getShares()) {
			if (s.getZoneName().equals(zoneName) && s.isAllowed(user))
				url = s.getRmiAdresse();
		}

		return url;
	}

	/**
	 * Recupere le serveur lance a l'adresse donnee
	 * 
	 * @param ipAdresse
	 *            String : ip du serveur
	 * @return _Server : serveur de communication
	 * @throws MalformedURLException
	 *             leve une exception en cas d'URL mal formee
	 * @throws RemoteException
	 *             leve une exception en cas d'echec de communication
	 * @throws NotBoundException
	 *             leve une exception en cas d'echec de Bind
	 */
	public static _Server getServer(String ipAdresse) throws MalformedURLException, RemoteException, NotBoundException {
		return (_Server) Naming.lookup("rmi://" + ipAdresse + "/srv");
	}

	/**
	 * Demarre le serveur sur le poste, avec le policyFile pour les droits
	 * d'acces
	 * 
	 * @param policyPath
	 *            String : chemin d'acces au policyFile
	 */
	public static void startServer(String policyPath) {
		try {
			System.setProperty("java.security.policy", policyPath);
			System.setProperty("java.net.SocketPermission", policyPath);
			if (System.getSecurityManager() == null) {
				System.setSecurityManager(new RMISecurityManager());
			}

			Registry registry = LocateRegistry.createRegistry(1099);
			_Server server = new Server();

			registry.rebind("srv", server);

			System.out.println("Serveur lance !");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
