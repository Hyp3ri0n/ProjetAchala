package achala.modules.publication.metier;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;

import achala.datamanager.bdd.TypeBD;
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
	private Date date;
	private ArrayList<Commentaire> lesCommentaires;
	
	/**
	 * Constructeur sans contenu
	 */
	public Article(int unId, String unTitre, String unNomAuteur, Date uneDate) {
		this.id = unId;
		this.titre = unTitre;
		this.contenu = null;
		this.nomAuteur = unNomAuteur;
		this.date = uneDate;
		this.lesCommentaires = new ArrayList<Commentaire>();
	}

	/**
	 * Constructeur complet
	 */
	public Article(int unId, String unTitre, String unContenu, String unNomAuteur, Date uneDate) {
		this.id = unId;
		this.titre = unTitre;
		this.contenu = unContenu;
		this.nomAuteur = unNomAuteur;
		this.date = uneDate;
		this.lesCommentaires = new ArrayList<Commentaire>();
	}
	
	/**
	 * Methodes
	 */
	public void creer() {
		//APPEL DAO
		try {
			ManagerDAO.getDAOArticle().insert(this.id,this.date, this.titre, this.contenu, this.nomAuteur );
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
	
	//Ajout du commentaire en base puis ajout dans la liste
	public void ajouterCommentaire(Commentaire com) {
		com.creer(this.id);
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

	public String getNomAuteur() {
		return nomAuteur;
	}

	public void setNomAuteur(String nomAuteur) {
		HashMap<String, String> lstAttrsValues = new HashMap<>();
		lstAttrsValues.put("nomAuteur", nomAuteur);
		ManagerDAO.getBd().request(ManagerDAO.getDAOArticle().update(lstAttrsValues, "WHERE id = " + this.id));
		this.nomAuteur = nomAuteur;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		HashMap<String, String> lstAttrsValues = new HashMap<>();
		lstAttrsValues.put("date", TypeBD.syntaxe(date.toString(), TypeBD.DATE));
		ManagerDAO.getBd().request(ManagerDAO.getDAOArticle().update(lstAttrsValues, "WHERE id = " + this.id));
		this.date = date;
	}

	//Pas de set commentaires possible
	public ArrayList<Commentaire> getLesCommentaires() {
		return lesCommentaires;
	}
}
