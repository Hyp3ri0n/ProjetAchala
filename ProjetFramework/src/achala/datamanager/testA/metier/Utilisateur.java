package achala.datamanager.testA.metier;

import java.util.HashMap;

import achala.datamanager.testA.dao.ManagerDAO;
import achala.datamanager.testA.metier.Article;

public class Utilisateur {

	public int id;
	public String nom;
	public String prenom;
	public String adresse;
	public String poste;
	
	
	public Utilisateur (int id, String nom, String prenom, String adresse, String poste){
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.poste = poste;
	}

	
	public int getId() { return id; }

	public void setId(int id) {
		HashMap<String,String> lstAttrsValues = new HashMap<>();
		lstAttrsValues.put("id", ""+id);
		ManagerDAO.getBd().request(ManagerDAO.getDAOUtilisateur().update(lstAttrsValues, "WHERE id = " + this.id));
		this.id = id;
	}

	public String getAttrB() { return nom; }

	public void setNom(String nom) {
		HashMap<String, String> lstAttrsValues = new HashMap<>();
		lstAttrsValues.put("nom", ""+nom);
		ManagerDAO.getBd().request(ManagerDAO.getDAOUtilisateur().update(lstAttrsValues, "WHERE id = " + this.id));
		this.nom = nom;
	}

	public String getPrenom() { return prenom; }

	public void setPrenom(String prenom) {
		HashMap<String, String> lstAttrsValues = new HashMap<>();
		lstAttrsValues.put("prenom", ""+prenom);
		ManagerDAO.getBd().request(ManagerDAO.getDAOUtilisateur().update(lstAttrsValues, "WHERE id = " + this.id));
		this.prenom = prenom;
	}

	public String getAdresse() { return adresse; }

	public void setAdresse(String adresse) {
		HashMap<String, String> lstAttrsValues = new HashMap<>();
		lstAttrsValues.put("adresse", adresse);
		ManagerDAO.getBd().request(ManagerDAO.getDAOUtilisateur().update(lstAttrsValues, "WHERE id = " + this.id));
		this.adresse = adresse;
	}


	public String getPoste() { return poste; }

	public void setPoste(String poste) {
		HashMap<String, String> lstAttrsValues = new HashMap<>();
		lstAttrsValues.put("poste", poste);
		ManagerDAO.getBd().request(ManagerDAO.getDAOUtilisateur().update(lstAttrsValues, "WHERE id = " + this.id));
		this.poste = poste;
	}




}
