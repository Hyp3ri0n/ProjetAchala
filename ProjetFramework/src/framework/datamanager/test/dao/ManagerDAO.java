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
		/**		Création connexion bd	**/
		/*********************************/
		bd = new Bd("", "", "");
		
		
		/*****************************************************/
		/**		Création des tables sans clés étrangère		**/
		/*****************************************************/
		DAOTable2 = new DAOTable2(null);
		
		
		/*****************************************************/
		/**		Création des tables avec clés étrangère		**/
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
