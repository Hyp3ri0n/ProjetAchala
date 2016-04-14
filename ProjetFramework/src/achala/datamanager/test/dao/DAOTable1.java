package achala.datamanager.test.dao;

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

public class DAOTable1 extends DAOTable {

	protected DAOTable1(Map<DAOTable, String> jointures) {
		super(jointures);
		// TODO Auto-generated method stub
	}

	@Override
	public void initialisation() {
		
		this.setNomTable("Table1");
		
		Map<String, TypeBD> lstAttrs = new HashMap<>();
		lstAttrs.put("AttrA", TypeBD.INTEGER);
		lstAttrs.put("AttrB", TypeBD.STRING);
		lstAttrs.put("AttrC", TypeBD.STRING);
		lstAttrs.put("AttrD", TypeBD.STRING);
		lstAttrs.put("AttrE", TypeBD.INTEGER);
		
		this.setAttributs(lstAttrs);
	}
	
	@Override
	protected Requete createTable() {
		return new Create("CREATE TABLE Table1 ("
							+ "AttrA INTEGER PRIMARY KEY,"
							+ "AttrB VARCHAR2(25) NOT NULL,"
							+ "AttrC VARCHAR2(25) NOT NULL,"
							+ "AttrD VARCHAR2(25) NOT NULL,"
							+ "AttrE INTEGER NOT NULL,"
							+ "CONSTRAINT fk FOREIGN KEY (AttrE) REFERENCES Table2(AttrA)"
						+ ")");
	}

	/**
	 * Permet de Selectionner tout les lignes de la table "Table1"
	 * @return La requête à executer (objet)
	 */
	public Requete selectAll() {
		List<DAOTable> lstTables = new ArrayList<>();
		lstTables.add(ManagerDAO.getDAOTable1());
		
		List<String> lstAttrs = new ArrayList<>();
		lstAttrs.add("*");
		
		return new Select(lstAttrs, lstTables);
	}

	
	/**
	 * Une requête select basique
	 * @return La requête à executer (objet)
	 */
	public Requete selectSomething() {
		List<DAOTable> lstTables = new ArrayList<>();
		lstTables.add(ManagerDAO.getDAOTable1());
		lstTables.add(ManagerDAO.getDAOTable2());
		
		List<String> lstAttrs = new ArrayList<>();
		lstAttrs.add("Table2.AttrB");
		
		return new Select(lstAttrs, lstTables, "WHERE Table1.attrA = 24");
	}
	

	/**
	 * Permet d'insérer une ligne dans la table "Table2"
	 * @param attrA Le premier attribut
	 * @param attrB Le second attribut
	 * @param attrC Le troisième attribut
	 * @param attrD Le quatrième attribut
	 * @param attrE Le cinquième attribut
	 * @return La requête à executer (objet)
	 */
	public Requete insert(String attrA, String attrB, String attrC, String attrD, String attrE) {		
		HashMap<String, String> lstAttrsValue = new HashMap<>();
		lstAttrsValue.put("AttrA", attrA);
		lstAttrsValue.put("AttrB", attrB);
		lstAttrsValue.put("AttrC", attrC);
		lstAttrsValue.put("AttrD", attrD);
		lstAttrsValue.put("AttrE", attrE);
		
		return new Insert(lstAttrsValue, ManagerDAO.getDAOTable1());
	}

	/**
	 * Permet de modifier une ou plusieurs lignes dans la table "Table2"
	 * @param lstAttrsValues La liste des attributs et leurs valeurs pour modification
	 * @param where La clause WHERE de la requête
	 * @return La requête à executer (objet)
	 */
	public Requete update(HashMap<String, String> lstAttrsValues, String where) {		
		return new Update(lstAttrsValues, ManagerDAO.getDAOTable1(), where);
	}
	
	/**
	 * Permet de supprimer une ligne de la table
	 * @param where La clause Where
	 * @return La requête à executer (objet)
	 */
	public Requete delete(String where) {		
		return new Delete(ManagerDAO.getDAOTable1(), where);
	}

	/**
	 * Permet de supprimer la table en base
	 * @return La requête à executer (objet)
	 */
	public Requete drop() {		
		return new Drop(ManagerDAO.getDAOTable1());
	}
	
}
