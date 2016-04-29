package achala.datamanager.test.metier;

import java.util.HashMap;

import achala.datamanager.test.dao.ManagerDAO;

public class Table2 {
	private String attrA;
	private String attrB;
	private String attrC;
	
	public Table2(String attrA, String attrB, String attrC) {
		this.attrA = attrA;
		this.attrB = attrB;
		this.attrC = attrC;
	}
	
	/**
	 * JUSTE POUR LES TESTS (Creation de donnees dans la base)
	 */
	public static void jeuEssai() {
		for (int i = 1; i < 42; i++) {
			ManagerDAO.getBd().request(ManagerDAO.getDAOTable2().insert("" + i, "test" + i, "retest" + i));
		}
	}

	
	public String getAttrA() { return attrA; }

	public void setAttrA(String attrA) {
		HashMap<String, String> lstAttrsValues = new HashMap<>();
		lstAttrsValues.put("AttrA", attrA);
		ManagerDAO.getBd().request(ManagerDAO.getDAOTable2().update(lstAttrsValues, "WHERE AttrA = " + this.attrA));
		this.attrA = attrA;
	}

	public String getAttrB() { return attrB; }

	public void setAttrB(String attrB) {
		HashMap<String, String> lstAttrsValues = new HashMap<>();
		lstAttrsValues.put("AttrB", attrB);
		ManagerDAO.getBd().request(ManagerDAO.getDAOTable2().update(lstAttrsValues, "WHERE AttrA = " + this.attrA));
		this.attrB = attrB;
	}

	public String getAttrC() { return attrC; }

	public void setAttrC(String attrC) {
		HashMap<String, String> lstAttrsValues = new HashMap<>();
		lstAttrsValues.put("AttrC", attrC);
		ManagerDAO.getBd().request(ManagerDAO.getDAOTable2().update(lstAttrsValues, "WHERE AttrA = " + this.attrA));
		this.attrC = attrC;
	}
	
}
