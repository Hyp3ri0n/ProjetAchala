package achala.datamanager.testA.dao;

import java.sql.SQLException;
import java.util.HashMap;

import achala.datamanager.Bd;
import achala.datamanager.bdd.DAOTable;
import achala.datamanager.testA.dao.DAOArticle;
import achala.datamanager.testA.dao.DAOUtilisateur;
import achala.datamanager.testA.dao.ManagerDAO;

public class ManagerDAO {
	private static ManagerDAO instance = new ManagerDAO();
	private static Bd bd;
	private static DAOUtilisateur DAOUtilisateur ;
	private static DAOArticle DAOArticle;
	
	private ManagerDAO() {
		
		/*********************************/
		/**		Cr�ation connexion bd	**/
		/*********************************/
		try {
			bd = new Bd("jdbc:oracle:thin:@im2ag-oracle.e.ujf-grenoble.fr:1521:im2ag", "claudeau", "bd");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		/*****************************************************/
		/**		Cr�ation des tables sans cl�s �trang�re		**/
		/*****************************************************/
		DAOArticle= new DAOArticle(null);
		
		
		/*****************************************************/
		/**		Cr�ation des tables avec cl�s �trang�re		**/
		/*****************************************************/
		HashMap<DAOTable, String> lstJointuresTbl1 = new HashMap<>();
		lstJointuresTbl1.put(DAOArticle, "Utilisateur.id = Article.idediteur");
		DAOUtilisateur = new DAOUtilisateur(lstJointuresTbl1);
		
	}

	public static ManagerDAO getInstance() { return instance; }

	public static DAOUtilisateur getDAOUtilisateur() { return DAOUtilisateur; }

	public static DAOArticle getDAOArticle() { return DAOArticle; }

	public static Bd getBd() { return bd; }
	
}
