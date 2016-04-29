package achala.datamanager.test.dao;

import java.sql.SQLException;
import java.util.HashMap;

import achala.datamanager.Bd;
import achala.datamanager.bdd.DAOTable;

public class ManagerDAO {
	private static ManagerDAO instance = new ManagerDAO();
	private static Bd bd;
	private static DAOTable1 DAOTable1;
	private static DAOTable2 DAOTable2;
	
	private ManagerDAO() {
		
		/**______________Partie obligatoire______________**/
		
		
		/*********************************/
		/**		Creation connexion bd	**/
		/*********************************/
		try {
			bd = new Bd("jdbc:oracle:thin:@im2ag-oracle.e.ujf-grenoble.fr:1521:im2ag", "fernaaur", "bd");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		/*************************************************************/
		/**		Creation des objets DAO avec jointures (ou pas)		**/
		/*************************************************************/
		//Creation des tables sans cles etrangeres en premier
		DAOTable2 = new DAOTable2(null);
		//Puis les tables avec cles etrangeres (m�me systeme BDD)
		HashMap<DAOTable, String> lstJointuresTbl1 = new HashMap<>();
		lstJointuresTbl1.put(DAOTable2, "Table1.AttrE = Table2.AttrA");
		DAOTable1 = new DAOTable1(lstJointuresTbl1);
		
		
		
		
		/**______________Partie non obligatoire______________**/
		
		
		/*****************************************************/
		/**				Suppression des tables				**/
		/*****************************************************/
		bd.request(DAOTable1.drop());			//Pas obligatoire si dej� creer en BDD
		bd.request(DAOTable2.drop());			//Pas obligatoire si dej� creer en BDD
		
		
		/*****************************************************/
		/**			Creation des tables en Base	 			**/
		/*****************************************************/
		bd.request(DAOTable2.createTable());	//Pas obligatoire si dej� creer en BDD
		bd.request(DAOTable1.createTable());	//Pas obligatoire si dej� creer en BDD
		
	}

	public static ManagerDAO getInstance() { return instance; }

	public static DAOTable1 getDAOTable1() { return DAOTable1; }

	public static DAOTable2 getDAOTable2() { return DAOTable2; }

	public static Bd getBd() { return bd; }
	
	
}
