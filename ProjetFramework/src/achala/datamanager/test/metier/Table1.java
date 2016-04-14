package achala.datamanager.test.metier;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import achala.datamanager.test.dao.ManagerDAO;

public class Table1 {

	private String attrA;
	private String attrB;
	private String attrC;
	private String attrD;
	private Table2 attrE;
	
	public Table1 (String attrA, String attrB, String attrC, String attrD, Table2 attrE) {
		this.attrA = attrA;
		this.attrB = attrB;
		this.attrC = attrC;
		this.attrD = attrD;
		this.attrE = attrE;
	}
	
	/**
	 * JUSTE POUR LES TESTS (Création de données dans la base)
	 */
	public static void jeuEssai() {
		for (int i = 1; i < 42; i++) {
			ManagerDAO.getBd().request(ManagerDAO.getDAOTable1().insert("" + i, "test" + i, "retest" + i, "salut" + i, "" + i));
		}
	}

	
	public String selectSomething() {
		ResultSet rs = ManagerDAO.getBd().request(ManagerDAO.getDAOTable1().selectSomething());
		
		try {
			if (rs.next()) {
				return rs.getString(0);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ""; 
	}
	
	
	public String getAttrA() { return attrA; }

	public void setAttrA(String attrA) {
		HashMap<String, String> lstAttrsValues = new HashMap<>();
		lstAttrsValues.put("AttrA", attrA);
		ManagerDAO.getBd().request(ManagerDAO.getDAOTable1().update(lstAttrsValues, "WHERE AttrA = " + this.attrA));
		this.attrA = attrA;
	}

	public String getAttrB() { return attrB; }

	public void setAttrB(String attrB) {
		HashMap<String, String> lstAttrsValues = new HashMap<>();
		lstAttrsValues.put("AttrB", attrB);
		ManagerDAO.getBd().request(ManagerDAO.getDAOTable1().update(lstAttrsValues, "WHERE AttrA = " + this.attrA));
		this.attrB = attrB;
	}

	public String getAttrC() { return attrC; }

	public void setAttrC(String attrC) {
		HashMap<String, String> lstAttrsValues = new HashMap<>();
		lstAttrsValues.put("AttrC", attrC);
		ManagerDAO.getBd().request(ManagerDAO.getDAOTable1().update(lstAttrsValues, "WHERE AttrA = " + this.attrA));
		this.attrC = attrC;
	}

	public String getAttrD() { return attrD; }

	public void setAttrD(String attrD) {
		HashMap<String, String> lstAttrsValues = new HashMap<>();
		lstAttrsValues.put("AttrD", attrD);
		ManagerDAO.getBd().request(ManagerDAO.getDAOTable1().update(lstAttrsValues, "WHERE AttrA = " + this.attrA));
		this.attrD = attrD;
	}

	public Table2 getAttrE() { return attrE; }

	public void setAttrE(Table2 attrE) {
		HashMap<String, String> lstAttrsValues = new HashMap<>();
		lstAttrsValues.put("AttrE", attrE.getAttrA());
		ManagerDAO.getBd().request(ManagerDAO.getDAOTable1().update(lstAttrsValues, "WHERE AttrA = " + this.attrA));
		this.attrE = attrE;
	}
	
}
