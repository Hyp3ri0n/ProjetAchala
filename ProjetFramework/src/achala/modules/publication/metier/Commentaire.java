package achala.modules.publication.metier;

import java.sql.Date;
import java.util.HashMap;

import achala.datamanager.bdd.TypeBD;
import achala.modules.publication.dao.ManagerDAO;
import achala.modules.publication.exception.PublicationException;

public class Commentaire {
	
	/**
	 * Attributs priv�s
	 */
	private int id;
	private String contenu;
	private String nomAuteur;
	private Date date;
	
	/**
	 * Constructeur
	 */
	public Commentaire(int unId, String unContenu, String unAuteur, Date uneDate) {
		this.id = unId;
		this.contenu = unContenu;
		this.nomAuteur = unAuteur;
		this.date = uneDate;
	}
	
	/**
	 * M�thodes
	 */
	public void creer(int idArticle) {
		//APPEL DAO
		try {
			ManagerDAO.getDAOCommentaire().insert(this.id, this.date, this.contenu, this.nomAuteur, idArticle);
		} catch(Exception e) {
			e.getMessage();
		}
	}
	
	public void modifier(Commentaire nouveauCommentaire) throws PublicationException {
		if (this.getId() == nouveauCommentaire.getId()) {
			//APPEL DAO
		}
		else {
			throw new PublicationException("L'id du nouveau commentaire ne correspond pas � l'id actuel du commentaire.");
		}
	}
	
	public void supprimer() {
		//APPEL DAO
	}
	
	/**
	 * Getteurs / Accesseurs
	 */
	//Pas de setId possible
	public int getId() {
		return id;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		HashMap<String, String> lstAttrsValues = new HashMap<>();
		lstAttrsValues.put("contenu", contenu);
		ManagerDAO.getBd().request(ManagerDAO.getDAOCommentaire().update(lstAttrsValues, "WHERE id = " + this.id));
		this.contenu = contenu;
	}

	public String getAuteur() {
		return nomAuteur;
	}

	public void setAuteur(String auteur) {
		HashMap<String, String> lstAttrsValues = new HashMap<>();
		lstAttrsValues.put("auteur", auteur);
		ManagerDAO.getBd().request(ManagerDAO.getDAOCommentaire().update(lstAttrsValues, "WHERE id = " + this.id));
		this.nomAuteur = auteur;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		HashMap<String, String> lstAttrsValues = new HashMap<>();
		lstAttrsValues.put("date", TypeBD.syntaxe(date.toString(), TypeBD.DATE));
		ManagerDAO.getBd().request(ManagerDAO.getDAOCommentaire().update(lstAttrsValues, "WHERE id = " + this.id));
		this.date = date;
	}
	

}
