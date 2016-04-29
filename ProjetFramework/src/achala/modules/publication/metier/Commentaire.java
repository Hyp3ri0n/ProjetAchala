package achala.modules.publication.metier;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import achala.datamanager.bdd.TypeBD;
import achala.modules.publication.dao.ManagerDAO;
import achala.modules.publication.exception.PublicationException;

public class Commentaire {
	
	// ATTRIBUTS PRIVES
	private int id;
	private String contenu;
	private String auteur;
	private String date;
	private int idArticle;
	
	/**
	 * Constructeur avec generation d'id puis insertion en base / insertion dans la liste du ManagerApp
	 * @param unContenu
	 * @param unAuteur
	 * @param uneDate
	 * @param idArticle
	 */
	public Commentaire(String unContenu, String unAuteur, String uneDate, int idArticle) {
		this.id = Commentaire.getIdCourant();
		this.contenu = unContenu;
		this.auteur = unAuteur;
		this.date = uneDate;
		this.idArticle = idArticle;
		try{
			this.creer();
			Article.getArticleById(idArticle).ajouterCommentaire(this);
		} catch(PublicationException e) {
			e.getMessage();
		}

	}
	
	/**
	 * Constructeur complet sans traitement par la suite
	 * @param unId
	 * @param unContenu
	 * @param unAuteur
	 * @param uneDate
	 * @param idArticle
	 */
	public Commentaire(int unId, String unContenu, String unAuteur, String uneDate, int idArticle) {
		this.id = unId;
		this.contenu = unContenu;
		this.auteur = unAuteur;
		this.date = uneDate;
		this.idArticle = idArticle;
	}
	
	// METHODES
	/**
	 * Mise a jour des donnees BD et liste lesCommentaires du ManagerApp
	 */
	public void creer() {
		try {
			// Execution de la requete d'insertion
			ManagerDAO.getBd().request(ManagerDAO.getDAOCommentaire().insert(this.id, this.date, this.contenu, this.auteur, this.idArticle));
			// Mise a jour de la liste lesCommentaires, on ajoute le commentaire
			ManagerApp.Instance().getListCommentaires().add(this);
		} catch(Exception e) {
			e.getMessage();
		}
	}

	/**
	 * Mise à jour des donnees BD et liste lesCommentaires du ManagerApp
	 * @require
	 */
	public void supprimer() {
		try {
			// Execution de la requete de suppression
			ManagerDAO.getBd().request(ManagerDAO.getDAOCommentaire().delete(this.id));
			// Mise a jour de la liste lesCommentaires, on retire le commentaire
			ManagerApp.Instance().getListCommentaires().remove(this);
		} catch(Exception e) {
			e.getMessage();
		}
	}
	
	// SETTEURS ET ACCESSEURS
	/**
	 * generation d'id pour insertion
	 * @return la valeur maximale de la colonne id de la table commentaire, incrementee de 1
	 */
	private static int getIdCourant() {
		// Execution de la requete de selection
		ResultSet rs = ManagerDAO.getBd().request(ManagerDAO.getDAOCommentaire().selectMaxId());
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
	 * Accesseur id commentaire
	 * @return l'id de l'objet Commentaire
	 */
	public int getId() {
		return id;
	}

	/**
	 * Accesseur contenu commentaire
	 * @return le contenu de l'objet Commentaire
	 */
	public String getContenu() {
		return contenu;
	}
	
	/**
	 * Setteur contenu commentaire
	 * Met à jour l'enregistrement commentaire dans la BDD ainsi que l'objet dans la liste listCommentaires du ManagerApp
	 * @param contenu
	 */
	public void setContenu(String contenu) {
		// Renseignement des attributs a modifier
		HashMap<String, String> lstAttrsValues = new HashMap<>();
		lstAttrsValues.put("contenu", contenu);
		// Execution de la requete d'update
		ManagerDAO.getBd().request(ManagerDAO.getDAOCommentaire().update(lstAttrsValues,this.id));
		this.contenu = contenu;
	}

	/**
	 * Accesseur auteur commentaire
	 * @return l'auteur de l'objet Commentaire
	 */
	public String getAuteur() {
		return auteur;
	}

	/**
	 * Setteur auteur commentaire
	 * Met à jour l'enregistrement commentaire dans la BDD ainsi que l'objet dans la liste listCommentaires du ManagerApp
	 * @param auteur
	 */
	public void setAuteur(String auteur) {
		// Renseignement des attributs a modifier
		HashMap<String, String> lstAttrsValues = new HashMap<>();
		lstAttrsValues.put("auteur", auteur);
		// Execution de la requete d'update
		ManagerDAO.getBd().request(ManagerDAO.getDAOCommentaire().update(lstAttrsValues,this.id));
		this.auteur = auteur;
	}
	
	/**
	 * Accesseur date commentaire
	 * @return la date de l'objet Commentaire
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Setteur auteur commentaire
	 * Met à jour l'enregistrement commentaire dans la BDD ainsi que l'objet dans la liste listCommentaires du ManagerApp
	 * @param date
	 */
	public void setDate(String date) {
		// Renseignement des attributs a modifier
		HashMap<String, String> lstAttrsValues = new HashMap<>();
		lstAttrsValues.put("date", TypeBD.syntaxe(date, TypeBD.DATE));
		// Execution de la requete d'update
		ManagerDAO.getBd().request(ManagerDAO.getDAOCommentaire().update(lstAttrsValues,this.id));
		this.date = date;
	}
	
	/**
	 * Accesseur objet Commentaire 
	 * @param id du commentaire souhaite
	 * @return l'objet Commentaire s'il existe dans la liste listCommentaires du ManagerApp
	 */
	public static Commentaire getCommentaireById(int id) {
		// Parcours de la liste lesCommentaires du ManagerApp
		for(Commentaire com:ManagerApp.Instance().getListCommentaires()) {
			if(id == com.getId()) {
				return com;
			}
		}
		return null;
	}
}
