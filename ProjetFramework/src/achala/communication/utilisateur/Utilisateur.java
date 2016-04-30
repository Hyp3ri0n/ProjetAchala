package achala.communication.utilisateur;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import achala.communication._RemotableObject;
import achala.communication._Shared;
import achala.communication.exception.CommunicationException;
import achala.communication.server._Server;

public class Utilisateur extends UnicastRemoteObject implements _Utilisateur {

	private static final long serialVersionUID = -2512980221726350413L;

	private int id;
	private String lastName;
	private String firstName;
	private _Server server;
	private String ip;

	/**
	 * Construit un nouvel utilisateur
	 * 
	 * @throws RemoteException
	 *             leve une exception en cas d'echec de communication
	 * @throws UnknownHostException
	 *             leve une exception en cas d'hote inconnu
	 */
	public Utilisateur() throws RemoteException, UnknownHostException {
		super();
		this.setIp(InetAddress.getLocalHost().getHostAddress());
	}

	/**
	 * Construit un nouvel utilisateur
	 * 
	 * @param nom
	 *            String : nom de l'utilisateur
	 * @param prenom
	 *            : prenom de l'utilisateur
	 * @throws RemoteException
	 *             leve une exception en cas d'echec de communication
	 * @throws UnknownHostException
	 *             leve une exception en cas d'hote inconnu
	 */
	public Utilisateur(String nom, String prenom) throws RemoteException, UnknownHostException {
		this();
		this.setNom(nom);
		this.setPrenom(prenom);
	}

	/**
	 * Construit un nouvel utilisateur
	 * 
	 * @param nom
	 *            String : nom de l'utilisateur
	 * @param prenom
	 *            String : prenom de l'utilisateur
	 * @param server
	 *            _Server : serveur dans lequel connecter l'utilisateur
	 * @throws RemoteException
	 *             leve une exception en cas d'echec de communication
	 * @throws UnknownHostException
	 *             leve une exception en cas d'hote inconnu
	 * @throws CommunicationException
	 *             leve une exception en cas d'echec de connexion
	 */
	public Utilisateur(String nom, String prenom, _Server server)
			throws RemoteException, UnknownHostException, CommunicationException {
		this(nom, prenom);
		this.setServer(server);
		this.connect(this.getServer());
	}

	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String getNom() {
		return this.lastName;
	}

	/**
	 * Definie le nom de l'utilisateur
	 * 
	 * @param nom
	 *            String : nom de l'utilisateur
	 */
	public void setNom(String nom) {
		this.lastName = nom;
	}

	@Override
	public String getPrenom() {
		return firstName;
	}

	/**
	 * Definie le prenom de l'utilisateur
	 * 
	 * @param prenom
	 *            String : prenom de l'utilisateur
	 */
	public void setPrenom(String prenom) {
		this.firstName = prenom;
	}

	/**
	 * Renvoi le serveur sur lequel l'utilisateur est connecte
	 * 
	 * @return _Server : serveur sur lequel l'utilisateur est connecte
	 */
	public _Server getServer() {
		return server;
	}

	/**
	 * Definie le serveur sur lequel l'utilisateur se connecte
	 * 
	 * @param server
	 *            _Server : serveur sur lequel se connecter
	 */
	public void setServer(_Server server) {
		this.server = server;
	}

	@Override
	public String getIp() {
		return ip;
	}

	/**
	 * Definie l'adresse IP du poste de l'utilisateur
	 * 
	 * @param ip
	 *            String : adresse IP de l'utilisateur
	 */
	private void setIp(String ip) {
		this.ip = ip;
	}

	@Override
	public void connect(_Server server) throws RemoteException, CommunicationException {
		this.setServer(server);
		this.getServer().connect(this);
	}

	@Override
	public void send(_Shared share, _RemotableObject rObject) throws RemoteException, CommunicationException {
		share.send(rObject);
	}

	@Override
	public List<_RemotableObject> receive(_Shared share) throws RemoteException, CommunicationException {
		return share.receive(this);
	}

	@Override
	public void disconnect() throws RemoteException {
		this.getServer().disconnect(this);
	}

	@Override
	public String toString() {
		return this.getNom() + " " + this.getPrenom();
	}

	@Override
	public String toStringRemote() {
		return this.getNom() + " " + this.getPrenom();
	}

	@Override
	public String identify() throws RemoteException {
		return this.getNom() + this.getId();
	}

	@Override
	public boolean equals(_Utilisateur u) throws RemoteException {
		if (!this.getNom().equals(u.getNom()))
			return false;
		if (!this.getPrenom().equals(u.getPrenom()))
			return false;
		if (this.getId() != u.getId())
			return false;
		return true;
	}
}
