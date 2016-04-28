package achala.modules.publication.metier;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import achala.datamanager.bdd.TypeBD;
import achala.modules.publication.dao.ManagerDAO;
import achala.modules.publication.exception.PublicationException;


public class Article implements Comparable<Article> {

	/**
	 * Attributs priv�s
	 */
	private int id;
	private String titre;
	private String contenu;
	private String auteur;
	private String date;
	private ArrayList<Commentaire> lesCommentaires;

	/**
	 * Constructeur sans id
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
	 * Constructeur complet
	 */
	public Article(int unId, String unTitre, String unContenu, String unAuteur, String uneDate) {
		this.id = unId;
		this.titre = unTitre;
		this.contenu = unContenu;
		this.auteur = unAuteur;
		this.date = uneDate;
		this.lesCommentaires = new ArrayList<Commentaire>();
	}
	
	/**
	 * Methodes
	 */
	public void creer() {
		//Mise � jour des donn�es BD + Context
		try {
			ManagerDAO.getBd().request(ManagerDAO.getDAOArticle().insert(this.id, this.date, this.titre, this.auteur, this.contenu));
			ManagerApp.Instance().getListArticles().add(this);
		} catch(Exception e) {
			e.getMessage();
		}
	}
	
	public void supprimer() {
		//Mise � jour des donn�es BD + Context
		try {
			for(Commentaire com : lesCommentaires) {
				com.supprimer();
			}
			ManagerDAO.getBd().request(ManagerDAO.getDAOArticle().delete(this.id));
			ManagerApp.Instance().getListArticles().remove(this);
		} catch(Exception e) {
			e.getMessage();
		}
	}
	
	//Ajout du commentaire en base puis ajout dans la liste
	public void ajouterCommentaire(Commentaire com) {
		this.lesCommentaires.add(com);
	}
	
	//Suppression du commentaire en base puis suppression dans la liste
	public void supprimerCommentaire(Commentaire com) {
		com.supprimer();
		this.lesCommentaires.remove(com);
	}
	
	/**
	 * Getteurs / Accesseurs
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
	public int getId() {
		return id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		HashMap<String, String> lstAttrsValues = new HashMap<>();
		lstAttrsValues.put("titre", titre);
		ManagerDAO.getBd().request(ManagerDAO.getDAOArticle().update(lstAttrsValues, "WHERE id = " + this.id));
		this.titre = titre;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		HashMap<String, String> lstAttrsValues = new HashMap<>();
		lstAttrsValues.put("contenu", contenu);
		ManagerDAO.getBd().request(ManagerDAO.getDAOArticle().update(lstAttrsValues, "WHERE id = " + this.id));
		this.contenu = contenu;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		HashMap<String, String> lstAttrsValues = new HashMap<>();
		lstAttrsValues.put("auteur", auteur);
		ManagerDAO.getBd().request(ManagerDAO.getDAOArticle().update(lstAttrsValues, "WHERE id = " + this.id));
		this.auteur = auteur;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		HashMap<String, String> lstAttrsValues = new HashMap<>();
		lstAttrsValues.put("date", TypeBD.syntaxe(date, TypeBD.DATE));
		ManagerDAO.getBd().request(ManagerDAO.getDAOArticle().update(lstAttrsValues, "WHERE id = " + this.id));
		this.date = date;
	}

	//Pas de set commentaires possible
	public ArrayList<Commentaire> getLesCommentaires() {
		return lesCommentaires;
	}
	
	public static Article getArticleById(int id) throws PublicationException {
		for(Article art:ManagerApp.Instance().getListArticles()) {
			if(id == art.getId()) {
				return art;
			}
		}
		throw new PublicationException("L'article n'existe pas.");
	}
	
	//Comparable m�thode retourne -1 si < / 0 si = / 1 si >
	@Override
	public int compareTo(Article o) {
		if(this.getId() < o.getId()) {
			return -1;
		} else if (this.getId() > o.getId()) {
			return 1;
		} else {
			return 0;
		}
	}
}
