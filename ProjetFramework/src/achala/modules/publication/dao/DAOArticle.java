package achala.modules.publication.dao;

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
		lstAttrs.put("Article.titre", TypeBD.STRING);
		lstAttrs.put("Article.auteur", TypeBD.STRING);
		lstAttrs.put("Article.contenu", TypeBD.STRING);
		
		this.setAttributs(lstAttrs);
	}
	
	
	/** Creation de la requete */
	@Override
	protected Requete createTable() {
		return new Create("CREATE TABLE Article ("
							+ "id INTEGER PRIMARY KEY,"
							+ "titre VARCHAR2(50),"
							+ "auteur VARCHAR2 (250),"
							+ "contenu TEXT"
							//+ "CONSTRAINT fk FOREIGN KEY (auteur) REFERENCES Utilisateur(id)"
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
	public Requete insert(int id, String titre, String nomAuteur, String contenu) {		
		HashMap<String, String> lstAttrsValue = new HashMap<>();
		lstAttrsValue.put("id", id+"");
		lstAttrsValue.put("titre", titre);
		lstAttrsValue.put("contenu", contenu);
		lstAttrsValue.put("nomAuteur", nomAuteur+"");
		return new Insert(lstAttrsValue, ManagerDAO.getDAOArticle());
	}

	
	/**
	 * Permet de supprimer la table en base
	 * @return La requete a executer (objet)
	 */
	public Requete drop() {		
		return new Drop(ManagerDAO.getDAOArticle());
	}
	
	
	public Requete selectAll() {
		List<DAOTable> lstTables = new ArrayList<>();
		lstTables.add(ManagerDAO.getDAOArticle());
		
		List<String> lstAttrs = new ArrayList<>();
		lstAttrs.add("*");
		
		return new Select(lstAttrs, lstTables);
	}
	
	
	/** creation de requete */
	
	public Requete updateSomething() {		
		HashMap<String, String> lstAttrsValue = new HashMap<>();
		lstAttrsValue.put("Article.id", "1");
		
		return new Update(lstAttrsValue, ManagerDAO.getDAOUtilisateur(), "WHERE Article.id = 1");
	}
	
	

	public Requete selectSomething() {
		List<DAOTable> lstTables = new ArrayList<>();
		lstTables.add(ManagerDAO.getDAOCommentaire());
		lstTables.add(ManagerDAO.getDAOArticle());
		
		List<String> lstAttrs = new ArrayList<>();
		lstAttrs.add("Article.titre");
		lstAttrs.add("Commentaire.contenu");
		
		return new Select(lstAttrs, lstTables, "WHERE Article.id = 1");
	}
	
}
