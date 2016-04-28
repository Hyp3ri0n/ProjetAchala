package achala.modules.publication.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import achala.datamanager.bdd.Create;
import achala.datamanager.bdd.DAOTable;
import achala.datamanager.bdd.Delete;
import achala.datamanager.bdd.Drop;
import achala.datamanager.bdd.Insert;
import achala.datamanager.bdd.Requete;
import achala.datamanager.bdd.Select;
import achala.datamanager.bdd.TypeBD;
import achala.datamanager.bdd.Update;


public class DAOArticle extends DAOTable {

	protected DAOArticle(Map<DAOTable, String> jointures) {
		super(jointures);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void initialisation() {
		this.setNomTable("Article");
		
		Map<String, TypeBD> lstAttrs = new HashMap<>();
		lstAttrs.put("id", TypeBD.INTEGER);
		lstAttrs.put("dateA", TypeBD.DATE);
		lstAttrs.put("titre", TypeBD.STRING);
		lstAttrs.put("contenu", TypeBD.STRING);
		lstAttrs.put("auteur", TypeBD.STRING);
		
		this.setAttributs(lstAttrs);
	}
	
	
	/** Creation de la requete */
	@Override
	public Requete createTable() {
		return new Create("CREATE TABLE Article ("
							+ "id INTEGER PRIMARY KEY,"
							+ "dateA DATE,"
							+ "titre VARCHAR2(50),"
							+ "contenu VARCHAR2(2500),"
							+ "auteur VARCHAR2 (250)"
						+ ")");
	}

	
	
	/**
	 * Permet de modifier une ou plusieurs lignes dans la table "Article"
	 * @param lstAttrsValues La liste des attributs et leurs valeurs pour modification
	 * @param where La clause WHERE de la requete
	 * @return La requete a executer (objet)
	 */
	public Requete update(HashMap<String, String> lstAttrsValues, String where) {		
		return new Update(lstAttrsValues, ManagerDAO.getDAOArticle(), where);
	}
	
	
	
	/**
	 * Permet d'inserer une ligne dans la table "Article"
	 * @param id Le premier attribut
	 * @param titre Le second attribut
	 * @param auteur Le troisieme attribut
	 * @param lescommentaires Le quatrieme attribut
	 * @return La requete a executer (objet)
	 */
	public Requete insert(int id, String date, String titre, String auteur, String contenu) {		
		HashMap<String, String> lstAttrsValue = new HashMap<>();
		lstAttrsValue.put("id", String.valueOf(id));
		lstAttrsValue.put("dateA", date);
		lstAttrsValue.put("titre", titre);
		lstAttrsValue.put("contenu", contenu);
		lstAttrsValue.put("auteur", auteur);
		return new Insert(lstAttrsValue, ManagerDAO.getDAOArticle());
	}

	
	/**
	 * Permet de supprimer la table en base
	 * @return La requete a executer (objet)
	 */
	public Requete drop() {		
		return new Drop(ManagerDAO.getDAOArticle());
	}

	
	/**
	 * Permet de supprimer la ligne en base
	 * @return La requete a executer (objet)
	 */
	public Requete delete(int id) {		
		return new Delete(ManagerDAO.getDAOArticle(), "WHERE id = " + id);
	}
	
	
	/**
	 * Permet de selectionner tous les articles de la BDD
	 * @return La requete a executer (objet)
	 */
	public Requete selectAll() {
		List<DAOTable> lstTables = new ArrayList<>();
		lstTables.add(ManagerDAO.getDAOArticle());
		
		List<String> lstAttrs = new ArrayList<>();
		lstAttrs.add("*");
		
		return new Select(lstAttrs, lstTables);
	}
	
	/**
	 * Permet de selectionner tous les articles de la BDD ordonn�s par titres
	 * @return La requete a executer (objet)
	 */
	public Requete selectAllOrderByTitre() {
		return new Select("SELECT * FROM Article ORDER BY Titre");
	}
	
	/**
	 * Permet de selectionner l'id max courante des articles
	 * @return La requete a executer (objet)
	 */
	public Requete selectMaxId() {
		List<DAOTable> lstTables = new ArrayList<>();
		lstTables.add(ManagerDAO.getDAOArticle());
		
		List<String> lstAttrs = new ArrayList<>();
		lstAttrs.add("MAX(id)");
		
		return new Select(lstAttrs, lstTables);
	}
	
	
	/** creation de requete */
	
	public Requete update(HashMap<String, String> lstAttrsValue, int id) {
		return new Update(lstAttrsValue,ManagerDAO.getDAOArticle(), "WHERE id = " + id);
	}
	
}
