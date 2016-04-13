package framework.datamanager.test.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import framework.datamanager.request.DAOTable;
import framework.datamanager.request.Requete;
import framework.datamanager.request.Select;
import framework.datamanager.request.TypeBD;

public class DAOTable1 extends DAOTable {

	protected DAOTable1(Map<DAOTable, String> jointures) {
		super(jointures);
		// TODO Auto-generated method stub
	}

	@Override
	public void initialisation() {
		
		this.setNomTable("Table1");
		
		Map<String, TypeBD> lstAttrs = new HashMap<>();
		lstAttrs.put("Table1.Attr1", TypeBD.STRING);
		
		this.setAttributs(lstAttrs);
	}

	public Requete selectSomething() {
		List<DAOTable> lstTables = new ArrayList<>();
		lstTables.add(ManagerDAO.getDAOTable1());
		lstTables.add(ManagerDAO.getDAOTable2());
		
		List<String> lstAttrs = new ArrayList<>();
		lstAttrs.add("Table1.Attr1");
		lstAttrs.add("Table2.Attr1");
		lstAttrs.add("Table2.Attr2");
		
		
		return new Select(lstAttrs, lstTables, "WHERE Table1.attr1 > 42", "GROUP BY Table1.attr1, Table2.attr1, Table2.attr2", "HAVING COUNT(Table1.attr1) >42");
	}
	
}
