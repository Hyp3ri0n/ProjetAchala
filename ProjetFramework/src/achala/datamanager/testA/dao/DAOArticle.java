package achala.datamanager.testA.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import achala.datamanager.bdd.Create;
import achala.datamanager.bdd.DAOTable;
import achala.datamanager.bdd.Drop;
import achala.datamanager.bdd.Insert;
import achala.datamanager.bdd.Requete;
import achala.datamanager.bdd.Select;
import achala.datamanager.bdd.TypeBD;
import achala.datamanager.bdd.Update;
import achala.datamanager.testA.dao.DAOUtilisateur;
import achala.datamanager.testA.dao.ManagerDAO;


public class DAOArticle extends DAOTable {

	protected DAOArticle(Map<DAOTable, String> jointures) {
		super(jointures);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void initialisation() {
		
		this.setNomTable("Article");
		
		Map<String, TypeBD> lstAttrs = new HashMap<>();
		lstAttrs.put("Article.id", TypeBD.STRING);
		lstAttrs.put("Article.libelle", TypeBD.STRING);
		lstAttrs.put("Article.idediteur", TypeBD.STRING);
		
		this.setAttributs(lstAttrs);
	}
	
	
	/** Creation de la requete */
	@Override
	protected Requete createTable() {
		return new Create("CREATE TABLE Article ("
							+ "id INTEGER PRIMARY KEY,"
							+ "libelle VARCHAR2(25),"
							+ "idediteur INTEGER "
						+ ")");	
	}

	
	
	/**
	 * Permet d'ins�rer une ligne dans la table "Table2"
	 * @param id Le premier attribut
	 * @param libelle Le second attribut
	 * @param idediteur Le troisi�me attribut
	 * @return La requ�te � executer (objet)
	 */
	public Requete insert(String id, String libelle, String idediteur) {		
		HashMap<String, String> lstAttrsValue = new HashMap<>();
		lstAttrsValue.put("5", id);
		lstAttrsValue.put("Nom5", libelle);
		lstAttrsValue.put("3", idediteur);
		
		return new Insert(lstAttrsValue, ManagerDAO.getDAOArticle());
	}

	
	/**
	 * Permet de supprimer la table en base
	 * @return La requ�te � executer (objet)
	 */
	public Requete drop() {		
		return new Drop(ManagerDAO.getDAOArticle());
	}
	
	
	
	
	/** creation de requete */
	
	public Requete updateSomething() {		
		HashMap<String, String> lstAttrsValue = new HashMap<>();
		lstAttrsValue.put("Utilisateur.id", "1");
		
		return new Update(lstAttrsValue, ManagerDAO.getDAOUtilisateur(), "WHERE Utilisateur.id = 1");
	}
	
	


}
