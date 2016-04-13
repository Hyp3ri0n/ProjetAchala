package framework.datamanager.test.dao;

import java.util.HashMap;

import framework.datamanager.Bd;
import framework.datamanager.request.DAOTable;

public class ManagerDAO {
	private static ManagerDAO instance = new ManagerDAO();
	private static Bd bd;
	private static DAOTable1 DAOTable1;
	private static DAOTable2 DAOTable2;
	
	private ManagerDAO() {
		
		/*********************************/
		/**		Cr�ation connexion bd	**/
		/*********************************/
		bd = new Bd("", "", "");
		
		
		/*****************************************************/
		/**		Cr�ation des tables sans cl�s �trang�re		**/
		/*****************************************************/
		DAOTable2 = new DAOTable2(null);
		
		
		/*****************************************************/
		/**		Cr�ation des tables avec cl�s �trang�re		**/
		/*****************************************************/
		HashMap<DAOTable, String> lstJointuresTbl1 = new HashMap<>();
		lstJointuresTbl1.put(DAOTable2, "Table1.Attr1 = Table2.Attr2");
		DAOTable1 = new DAOTable1(lstJointuresTbl1);
		
	}

	public static ManagerDAO getInstance() { return instance; }

	public static DAOTable1 getDAOTable1() { return DAOTable1; }

	public static DAOTable2 getDAOTable2() { return DAOTable2; }

	public static Bd getBd() { return bd; }
	
	
}
