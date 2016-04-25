package achala.modules.publication.dao;

import java.sql.Date;
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

public class DAOCommentaire extends DAOTable {

	protected DAOCommentaire(Map<DAOTable, String> jointures) {
		super(jointures);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void initialisation() {
		
		this.setNomTable("Commentaire");
		
		Map<String, TypeBD> lstAttrs = new HashMap<>();
		lstAttrs.put("Commentaire.id", TypeBD.STRING);
		lstAttrs.put("date", TypeBD.DATE);
		lstAttrs.put("Commentaire.contenu", TypeBD.STRING);
		lstAttrs.put("Commentaire.auteur", TypeBD.STRING);
		
		this.setAttributs(lstAttrs);
	}
	
	
	/** Creation de la requete */
	@Override
	protected Requete createTable() {
		return new Create("CREATE TABLE Commentaire ("
							+ "id INTEGER PRIMARY KEY,"
							+ "date DATE,"
							+ "contenu VARCHAR2(250),"
							+ "auteur VARCHAR2(250), "
							+ "article INTEGER NOT NULL, "
							+ "CONSTRAINT fk FOREIGN KEY (article) REFERENCES Article(id)"
						+ ")");
	}

	
	
	/**
	 * Permet de modifier une ou plusieurs lignes dans la table "Commentaire"
	 * @param lstAttrsValues La liste des attributs et leurs valeurs pour modification
	 * @param where La clause WHERE de la requete
	 * @return La requete a executer (objet)
	 */
	public Requete update(HashMap<String, String> lstAttrsValues, String where) {		
		return new Update(lstAttrsValues, ManagerDAO.getDAOArticle(), where);
	}
	
	
	
	/**
	 * Permet d'inserer une ligne dans la table "Commentaire"
	 * @param id Le premier attribut
	 * @param contenu Le second attribut
	 * @param auteur Le troisieme attributt
	 * @return La requete a executer (objet)
	 */
	public Requete insert(int id, Date date, String contenu, String nomAuteur, int idArticle) {
		HashMap<String, String> lstAttrsValue = new HashMap<>();
		lstAttrsValue.put("id", String.valueOf(id));
		lstAttrsValue.put("date", TypeBD.syntaxe(date.toString(), TypeBD.DATE));
		lstAttrsValue.put("contenu", contenu);
		lstAttrsValue.put("auteur", nomAuteur);
		lstAttrsValue.put("article", String.valueOf(idArticle));
		
		return new Insert(lstAttrsValue, ManagerDAO.getDAOCommentaire());
	}

	
	/**
	 * Permet de supprimer la table en base
	 * @return La requete a executer (objet)
	 */
	public Requete drop() {		
		return new Drop(ManagerDAO.getDAOCommentaire());
	}
	
	/**
	 * Permet de r�cupperer tout les commentaires
	 * @return La requete a executer (objet)
	 */
	public Requete selectAll() {
		List<DAOTable> lstTables = new ArrayList<>();
		lstTables.add(ManagerDAO.getDAOCommentaire());
		
		List<String> lstAttrs = new ArrayList<>();
		lstAttrs.add("*");
		
		return new Select(lstAttrs, lstTables);
	}
	

//	public Requete selectSomething() {
//		List<DAOTable> lstTables = new ArrayList<>();
//		lstTables.add(ManagerDAO.getDAOCommentaire());
//		lstTables.add(ManagerDAO.getDAOArticle());
//		
//		List<String> lstAttrs = new ArrayList<>();
//		lstAttrs.add("Article.titre");
//		lstAttrs.add("Utilisateur.prenom");
//		lstAttrs.add("Article.libelle");
//		
//		return new Select(lstAttrs, lstTables, "WHERE Utilisateur.id = 1");
//	}
	
}
