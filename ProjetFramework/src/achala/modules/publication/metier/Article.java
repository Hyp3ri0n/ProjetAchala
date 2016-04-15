package achala.publication.articles;
import java.util.ArrayList;

import achala.publication.commentaires.*;

public class Article {

	/**
	 * Attributs privés
	 */
	private int id;
	private String titre;
	private String contenu;
	private Utilisateur auteur;
	private ArrayList<Commentaire> lesCommentaires;
	
	/**
	 * Constructeur sans contenu
	 */
	public Article(int unId, String unTitre) {
		this.id = unId;
		this.titre = unTitre;
		this.contenu = null;
		this.auteur = unAuteur;
		this.lesCommentaires = new ArrayList<Commentaire>();
	}
	
	/**
	 * Constructeur complet
	 */
	public Article(int unId, String unTitre, String unContenu) {
		this.id = unId;
		this.titre = unTitre;
		this.contenu = unContenu;
		this.auteur = unAuteur;
		this.lesCommentaires = new ArrayList<Commentaire>();
	}
	
	/**
	 * Méthodes
	 */
}
