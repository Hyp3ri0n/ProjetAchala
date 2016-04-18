package achala.modules.publication.metier;
import java.util.ArrayList;
import achala.modules.publication.dao.ManagerDAO;

import achala.modules.publication.exception.PublicationException;


public class Article {

	/**
	 * Attributs privés
	 */
	private int id;
	private String titre;
	private String contenu;
	private String nomAuteur;
	private ArrayList<Commentaire> lesCommentaires;
	
	/**
	 * Constructeur sans contenu
	 */
	public Article(int unId, String unTitre, String unNomAuteur) {
		this.id = unId;
		this.titre = unTitre;
		this.contenu = null;
		this.nomAuteur = unNomAuteur;
		this.lesCommentaires = new ArrayList<Commentaire>();
	}

	/**
	 * Constructeur complet
	 */
	public Article(int unId, String unTitre, String unContenu, String unNomAuteur) {
		this.id = unId;
		this.titre = unTitre;
		this.contenu = unContenu;
		this.nomAuteur = unNomAuteur;
		this.lesCommentaires = new ArrayList<Commentaire>();
	}
	
	/**
	 * Methodes
	 */
	public void creer() {
		//APPEL DAO
		try {
			ManagerDAO.getDAOArticle().insert(this.id, this.titre, this.contenu, this.nomAuteur);
		} catch(Exception e) {
			e.getMessage();
		}
	}
	
	public void modifier(Article nouvelArticle) throws PublicationException {
		if (this.getId() == nouvelArticle.getId()) {
			//APPEL DAO
		}
		else {
			throw new PublicationException("L'id du nouvel article ne correspond pas à l'id actuel de l'article.");
		}
	}
	
	public void supprimer() {
		//APPEL DAO
	}
	
	public void ajouterCommentaire(Commentaire com) {
		this.lesCommentaires.add(com);
	}
	
	public void supprimerCommentaire(Commentaire com) {
		this.lesCommentaires.remove(com);
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

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public String getNomAuteur() {
		return nomAuteur;
	}

	public void setAuteur(String nomAuteur) {
		this.nomAuteur = nomAuteur;
	}

	public ArrayList<Commentaire> getLesCommentaires() {
		return lesCommentaires;
	}

	public void setLesCommentaires(ArrayList<Commentaire> lesCommentaires) {
		this.lesCommentaires = lesCommentaires;
	}
}
