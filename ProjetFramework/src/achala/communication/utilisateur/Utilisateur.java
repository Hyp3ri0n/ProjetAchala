package achala.communication.utilisateur;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import achala.communication._RemotableObject;
import achala.communication._Shared;
import achala.communication.exception.CommunicationException;
import achala.communication.server._Server;

public class Utilisateur extends UnicastRemoteObject implements _Utilisateur{

	private static final long serialVersionUID = -2512980221726350413L;
	
	private int id;
	private String lastName;
	private String firstName;
	private _Server server;
	
	public Utilisateur(String nom, String prenom) throws RemoteException {
		super();
		this.setNom(nom);
		this.setPrenom(prenom);
	}
	
	public Utilisateur(String nom, String prenom, _Server server) throws RemoteException {
		this(nom, prenom);
		this.setServer(server);
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNom() {
		return this.lastName;
	}
	
	public void setNom(String nom) {
		this.lastName = nom;
	}

	public String getPrenom() {
		return firstName;
	}

	public void setPrenom(String prenom) {
		this.firstName = prenom;
	}
	
	public _Server getServer() {
		return server;
	}

	public void setServer(_Server server) {
		this.server = server;
	}
	
	
	
	
	@Override
	public void connect(_Server server) throws RemoteException {
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
	public String identify() throws RemoteException {
		return this.getNom() + this.getId();
	}
	
	/**
	 * Teste l'egalite de deux utilisateur
	 * @param u _Utilisateur : utilisateur a comparer
	 * @return boolean : true si l'utilisateur courant et l'utilisateur u sont les memes
	 * @throws RemoteException leve une excpetion en cas d'echec de communication
	 */
	public boolean equals(Utilisateur u) throws RemoteException {
		if(!this.getNom().equals(u.getNom())) return false;
		if(!this.getPrenom().equals(u.getPrenom())) return false;
		if(this.getId() != u.getId()) return false;
		return true;
	}
}
