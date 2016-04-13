package framework.datamanager.test.dao;

import java.util.HashMap;
import java.util.Map;

import framework.datamanager.request.Create;
import framework.datamanager.request.DAOTable;
import framework.datamanager.request.Drop;
import framework.datamanager.request.Insert;
import framework.datamanager.request.Requete;
import framework.datamanager.request.TypeBD;
import framework.datamanager.request.Update;

public class DAOTable2 extends DAOTable {

	protected DAOTable2(Map<DAOTable, String> jointures) {
		super(jointures);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initialisation() {
		
		this.setNomTable("Table2");
		
		Map<String, TypeBD> lstAttrs = new HashMap<>();
		lstAttrs.put("Table2.Attr1", TypeBD.STRING);
		lstAttrs.put("Table2.Attr2", TypeBD.STRING);
		
		this.setAttributs(lstAttrs);
	}
	
	
	@Override
	protected Requete createTable() {
		return new Create("CREATE TABLE Table2 ("
						+ "attr1 VARCHAR2(25),"
						+ "attr2 VARCHAR2(25)"
						+ ")");	
	}
	
	
	public Requete updateSomething() {		
		HashMap<String, String> lstAttrsValue = new HashMap<>();
		lstAttrsValue.put("Table1.Attr1", "42");
		
		return new Update(lstAttrsValue, ManagerDAO.getDAOTable1(), "WHERE Table1.attr1 > 42");
	}
	
	
	public Requete insertSomething() {		
		HashMap<String, String> lstAttrsValue = new HashMap<>();
		lstAttrsValue.put("Table2.Attr1", "42");
		lstAttrsValue.put("Table2.Attr2", "84");
		
		return new Insert(lstAttrsValue, ManagerDAO.getDAOTable2());
	}

	
	public Requete dropSomething() {		
		return new Drop(ManagerDAO.getDAOTable2());
	}
}
