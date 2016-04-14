package framework.datamanager.test.dao;

import java.sql.SQLException;
import java.util.HashMap;

import framework.datamanager.Bd;
import framework.datamanager.request.DAOTable;

public class ManagerDAO {
	private static ManagerDAO instance = new ManagerDAO();
	private static Bd bd;
	private static DAOTable1 DAOTable1;
	private static DAOTable2 DAOTable2;
	
	private ManagerDAO() {
		
		/**______________Partie obligatoire______________**/
		
		
		/*********************************/
		/**		Cr�ation connexion bd	**/
		/*********************************/
		try {
			bd = new Bd("jdbc:oracle:thin:@im2ag-oracle.e.ujf-grenoble.fr:1521:im2ag", "fernaaur", "bd");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		/*************************************************************/
		/**		Cr�ation des objets DAO avec jointures (ou pas)		**/
		/*************************************************************/
		//Cr�ation des tables sans cl�s �trang�res en premier
		DAOTable2 = new DAOTable2(null);
		//Puis les tables avec cl�s �trang�res (m�me syst�me BDD)
		HashMap<DAOTable, String> lstJointuresTbl1 = new HashMap<>();
		lstJointuresTbl1.put(DAOTable2, "Table1.AttrE = Table2.AttrA");
		DAOTable1 = new DAOTable1(lstJointuresTbl1);
		
		
		
		
		/**______________Partie non obligatoire______________**/
		
		
		/*****************************************************/
		/**				Suppression des tables				**/
		/*****************************************************/
		bd.request(DAOTable1.drop());			//Pas obligatoire si d�j� cr�er en BDD
		bd.request(DAOTable2.drop());			//Pas obligatoire si d�j� cr�er en BDD
		
		
		/*****************************************************/
		/**			Cr�ation des tables en Base	 			**/
		/*****************************************************/
		bd.request(DAOTable2.createTable());	//Pas obligatoire si d�j� cr�er en BDD
		bd.request(DAOTable1.createTable());	//Pas obligatoire si d�j� cr�er en BDD
		
	}

	public static ManagerDAO getInstance() { return instance; }

	public static DAOTable1 getDAOTable1() { return DAOTable1; }

	public static DAOTable2 getDAOTable2() { return DAOTable2; }

	public static Bd getBd() { return bd; }
	
	
}
