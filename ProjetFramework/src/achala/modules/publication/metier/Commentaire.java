package achala.modules.publication.metier;

import achala.modules.publication.dao.ManagerDAO;
import achala.modules.publication.exception.PublicationException;

public class Commentaire {
	
	/**
	 * Attributs privés
	 */
	private int id;
	private String contenu;
	private String nomAuteur;
	
	/**
	 * Constructeur
	 */
	public Commentaire(int unId, String unContenu, String unAuteur) {
		this.id = unId;
		this.contenu = unContenu;
		this.nomAuteur = unAuteur;
	}
	
	/**
	 * Méthodes
	 */
	public void creer() {
		//APPEL DAO
		ManagerDAO.getDAOCommentaire().insert(this.id, this.contenu, this.nomAuteur);
	}
	
	public void modifier(Commentaire nouveauCommentaire) throws PublicationException {
		if (this.getId() == nouveauCommentaire.getId()) {
			//APPEL DAO
		}
		else {
			throw new PublicationException("L'id du nouveau commentaire ne correspond pas à l'id actuel du commentaire.");
		}
	}
	
	public void supprimer() {
		//APPEL DAO
	}
	
	/**
	 * Getteurs / Accesseurs
	 */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public String getAuteur() {
		return nomAuteur;
	}

	public void setAuteur(String auteur) {
		this.nomAuteur = auteur;
	}
	

}
