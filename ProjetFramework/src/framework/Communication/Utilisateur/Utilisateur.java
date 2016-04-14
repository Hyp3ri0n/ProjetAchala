package framework.Communication.Utilisateur;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Utilisateur extends UnicastRemoteObject implements _Utilisateur{

	private static final long serialVersionUID = -2512980221726350413L;
	
	private int id;
	private String nom;
	private String prenom;
	//private _Server server; //???
	
	public Utilisateur() throws RemoteException{
		super();
	}
	
	public Utilisateur(String nom, String prenom) throws RemoteException {
		this();
		this.setNom(nom);
		this.setPrenom(prenom);
	}
	
	public Utilisateur(int id, String nom, String prenom) throws RemoteException {
		this(nom, prenom);
		this.setId(id);
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	@Override
	public String toString() {
		return this.getNom() + " " + this.getPrenom();
	}
	
	public String identify() throws RemoteException {
		return this.getNom() + this.getId();
	}
	
	public boolean equals(Utilisateur u) throws RemoteException {
		if(!this.getNom().equals(u.getNom())) return false;
		if(!this.getPrenom().equals(u.getPrenom())) return false;
		return true;
	}
}
