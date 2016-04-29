package achala.modules.publication.metier;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import achala.datamanager.bdd.TypeBD;
import achala.modules.publication.dao.ManagerDAO;
import achala.modules.publication.exception.PublicationException;


public class Article implements Comparable<Article> {

	// ATTRIBUTS PRIVES
	private int id;
	private String titre;
	private String contenu;
	private String auteur;
	private String date;
	private ArrayList<Commentaire> lesCommentaires;

	/**
	 * Constructeur avec generation d'id puis insertion en base / insertion dans la liste du ManagerApp
	 * @param unTitre
	 * @param unContenu
	 * @param unAuteur
	 * @param uneDate
	 */
	public Article(String unTitre, String unContenu, String unAuteur, String uneDate) {
		this.id = Article.getIdCourant();
		this.titre = unTitre;
		this.contenu = unContenu;
		this.auteur = unAuteur;
		this.date = uneDate;
		this.lesCommentaires = new ArrayList<Commentaire>();
		creer();
	}
	
	/**
	 * Constructeur complet sans traitement par la suite
	 * @param unId
	 * @param unTitre
	 * @param unContenu
	 * @param unAuteur
	 * @param uneDate
	 */
	public Article(int unId, String unTitre, String unContenu, String unAuteur, String uneDate) {
		this.id = unId;
		this.titre = unTitre;
		this.contenu = unContenu;
		this.auteur = unAuteur;
		this.date = uneDate;
		this.lesCommentaires = new ArrayList<Commentaire>();
	}
	
	// METHODES
	/**
	 * Mise a jour des donnees BD et liste lesArticles du ManagerApp
	 */
	public void creer() {
		try {
			// Execution de la requete d'insertion
			ManagerDAO.getBd().request(ManagerDAO.getDAOArticle().insert(this.id, this.date, this.titre, this.auteur, this.contenu));
			// Mise a jour de la liste lesArticles, on ajoute l'article
			ManagerApp.Instance().getListArticles().add(this);
		} catch(Exception e) {
			e.getMessage();
		}
	}
	
	/**
	 * 
	 */
	public void supprimer() {
		//Mise à jour des données BD + Context
		try {
			// Parcours de la liste des commentaires appartenant a l'article afin de la supprimer pour qu'aucune contrainte d'integrite ne soit violee
			for(Commentaire com : lesCommentaires) {
				com.supprimer();
			}
			// Execution de la requete de suppression
			ManagerDAO.getBd().request(ManagerDAO.getDAOArticle().delete(this.id));
			// Mise a jour de la liste lesArticles, on retire l'article
			ManagerApp.Instance().getListArticles().remove(this);
		} catch(Exception e) {
			e.getMessage();
		}
	}
	
	/**
	 * Ajout du commentaire passe en parametre dans la liste
	 * Methode appelee dans le constructeur de la classe Commentaire
	 * @param com
	 */
	public void ajouterCommentaire(Commentaire com) {
		this.lesCommentaires.add(com);
	}
	
	/**
	 * Suppression du commentaire en base puis suppression dans la liste
	 * @param com
	 */
	public void supprimerCommentaire(Commentaire com) {
		com.supprimer();
		this.lesCommentaires.remove(com);
	}
	
	// SETTEURS ET ACCESSEURS
	/**
	 * generation d'id pour insertion
	 * @return la valeur maximale de la colonne id de la table article, incrementee de 1
	 */
	private static int getIdCourant() {
		ResultSet rs = ManagerDAO.getBd().request(ManagerDAO.getDAOArticle().selectMaxId());
		try {
			if(rs.next()) {
				return rs.getInt(1)+1;
			}
		} catch(SQLException e){
			e.getMessage();
		}
		return 1;
	}
	
	//Pas de setId possible
	/**
	 * Accesseur id article
	 * @return l'id de l'objet Article
	 */
	public int getId() {
		return id;
	}

	/**
	 * Accesseur titre article
	 * @return le titre de l'objet Article
	 */
	public String getTitre() {
		return titre;
	}

	/**
	 * Setteur titre article
	 * Met à jour l'enregistrement article dans la BDD ainsi que l'objet dans la liste listArticles du ManagerApp
	 * @param titre
	 */
	public void setTitre(String titre) {
		// Renseignement des attributs a modifier
		HashMap<String, String> lstAttrsValues = new HashMap<>();
		lstAttrsValues.put("titre", titre);
		// Execution de la requete d'update
		ManagerDAO.getBd().request(ManagerDAO.getDAOArticle().update(lstAttrsValues,this.id));
		this.titre = titre;
	}

	/**
	 * Accesseur contenu article
	 * @return le contenu de l'objet Article
	 */
	public String getContenu() {
		return contenu;
	}

	/**
	 * Setteur contenu article
	 * Met à jour l'enregistrement article dans la BDD ainsi que l'objet dans la liste listArticles du ManagerApp
	 * @param contenu
	 */
	public void setContenu(String contenu) {
		// Renseignement des attributs a modifier
		HashMap<String, String> lstAttrsValues = new HashMap<>();
		lstAttrsValues.put("contenu", contenu);
		// Execution de la requete d'update
		ManagerDAO.getBd().request(ManagerDAO.getDAOArticle().update(lstAttrsValues,this.id));
		this.contenu = contenu;
	}
	
	/**
	 * Accesseur auteur article
	 * @return l'auteur de l'objet Article
	 */
	public String getAuteur() {
		return auteur;
	}
	
	/**
	 * Setteur auteur article
	 * Met à jour l'enregistrement article dans la BDD ainsi que l'objet dans la liste listArticles du ManagerApp
	 * @param auteur
	 */
	public void setAuteur(String auteur) {
		// Renseignement des attributs a modifier
		HashMap<String, String> lstAttrsValues = new HashMap<>();
		lstAttrsValues.put("auteur", auteur);
		// Execution de la requete d'update
		ManagerDAO.getBd().request(ManagerDAO.getDAOArticle().update(lstAttrsValues,this.id));
		this.auteur = auteur;
	}
	
	/**
	 * Accesseur date article
	 * @return la date de l'objet Article
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Setteur date article
	 * Met à jour l'enregistrement article dans la BDD ainsi que l'objet dans la liste listArticles du ManagerApp
	 * @param date
	 */
	public void setDate(String date) {
		// Renseignement des attributs a modifier
		HashMap<String, String> lstAttrsValues = new HashMap<>();
		lstAttrsValues.put("date", TypeBD.syntaxe(date, TypeBD.DATE));
		// Execution de la requete d'update
		ManagerDAO.getBd().request(ManagerDAO.getDAOArticle().update(lstAttrsValues,this.id));
		this.date = date;
	}

	//Pas de set commentaires possible
	/**
	 * Accesseur listeCommentaires article
	 * @return la liste des commentaires rattaches a l'article
	 */
	public ArrayList<Commentaire> getLesCommentaires() {
		return lesCommentaires;
	}
	
	/**
	 * Accesseur objet Article 
	 * @param id de l'article souhaite
	 * @return l'objet Article s'il existe dans la liste lesArticles du ManagerApp
	 */
	public static Article getArticleById(int id) throws PublicationException {
		// Parcours de la liste lesArticles du ManagerApp
		for(Article art:ManagerApp.Instance().getListArticles()) {
			if(id == art.getId()) {
				return art;
			}
		}
		throw new PublicationException("L'article n'existe pas.");
	}
	
	/**
	 * Redifinition de la methode compareTo afin de trier la liste d'articles du ManagerApp
	 * @return -1 si this.attribut < o.attribut || 0 si this.attribut = o.attribut || 1 si this.attribut > o.attribut
	 */
	@Override
	public int compareTo(Article o) {
		// En fonction du typeTri defini dans le ManagerApp, le tri ne se fera pas sur le même attribut
		switch(ManagerApp.Instance().getTypeTri()) {
			case "id" : 
				if(this.getId() < o.getId()) {
					return -1;
				} else if (this.getId() > o.getId()) {
					return 1;
				} else {
					return 0;
				}
			case "titre" : 
				return this.getTitre().compareTo(o.getTitre());
			case "auteur" : 
				return this.getAuteur().compareTo(o.getAuteur());
			default :
				return 0;
		}
	}
	
	@Override
	public String toString() {
		return "L'article "+this.titre+" ecrit le "+this.date+" par "+this.auteur+"\nA pour contenu : "+this.contenu;
	}
}
