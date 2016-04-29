package achala.datamanager.test.dao;

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

public class DAOTable2 extends DAOTable {

	protected DAOTable2(Map<DAOTable, String> jointures) {
		super(jointures);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initialisation() {
		
		this.setNomTable("Table2");
		
		Map<String, TypeBD> lstAttrs = new HashMap<>();
		lstAttrs.put("AttrA", TypeBD.INTEGER);
		lstAttrs.put("AttrB", TypeBD.STRING);
		lstAttrs.put("AttrC", TypeBD.STRING);
		
		this.setAttributs(lstAttrs);
	}
	
	
	@Override
	public Requete createTable() {
		return new Create("CREATE TABLE Table2 ("
							+ "AttrA INTEGER PRIMARY KEY,"
							+ "AttrB VARCHAR2(25),"
							+ "AttrC VARCHAR2(25)"
						+ ")");	
	}

	
	/**
	 * Permet de Selectionner tout les lignes de la table "Table2"
	 * @return La requête a executer (objet)
	 */
	public Requete selectAll() {
		List<DAOTable> lstTables = new ArrayList<>();
		lstTables.add(ManagerDAO.getDAOTable2());
		
		List<String> lstAttrs = new ArrayList<>();
		lstAttrs.add("*");
		
		return new Select(lstAttrs, lstTables);
	}
	
	
	/**
	 * Permet de modifier une ou plusieurs lignes dans la table "Table2"
	 * @param lstAttrsValues La liste des attributs et leurs valeurs pour modification
	 * @param where La clause WHERE de la requête
	 * @return La requête a executer (objet)
	 */
	public Requete update(HashMap<String, String> lstAttrsValues, String where) {		
		return new Update(lstAttrsValues, ManagerDAO.getDAOTable1(), where);
	}
	
	
	/**
	 * Permet d'inserer une ligne dans la table "Table2"
	 * @param attrA Le premier attribut
	 * @param attrB Le second attribut
	 * @param attrC Le troisieme attribut
	 * @return La requête a executer (objet)
	 */
	public Requete insert(String attrA, String attrB, String attrC) {		
		HashMap<String, String> lstAttrsValue = new HashMap<>();
		lstAttrsValue.put("AttrA", attrA);
		lstAttrsValue.put("AttrB", attrB);
		lstAttrsValue.put("AttrC", attrC);
		
		return new Insert(lstAttrsValue, ManagerDAO.getDAOTable2());
	}

	
	/**
	 * Permet de supprimer la table en base
	 * @return La requête a executer (objet)
	 */
	public Requete drop() {		
		return new Drop(ManagerDAO.getDAOTable2());
	}
}
