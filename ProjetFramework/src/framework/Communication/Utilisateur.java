package framework.Communication;

public class Utilisateur {

	private int id;
	private String nom;
	private String prenom;
	
	public Utilisateur() {}
	
	public Utilisateur(String nom, String prenom) {
		this();
		this.setNom(nom);
		this.setPrenom(prenom);
	}
	
	public Utilisateur(int id, String nom, String prenom) {
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
	
	public void setNom(String prenom) {
		this.prenom = prenom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String toString() {
		return this.getNom() + " " + this.getPrenom();
	}
	
	public boolean equals() {
		return true;
	}
}
