package achala.datamanager.testA.dao;

import java.sql.SQLException;
import java.util.HashMap;

import achala.datamanager.Bd;
import achala.datamanager.bdd.DAOTable;
import achala.datamanager.test.dao.DAOTable1;
import achala.datamanager.test.dao.DAOTable2;
import achala.datamanager.testA.dao.DAOArticle;
import achala.datamanager.testA.dao.DAOUtilisateur;
import achala.datamanager.testA.dao.ManagerDAO;

public class ManagerDAO {
	private static ManagerDAO instance = new ManagerDAO();
	private static Bd bd;
	private static DAOUtilisateur DAOUtilisateur ;
	private static DAOArticle DAOArticle;
	
	private ManagerDAO() {
/**______________Partie obligatoire______________**/
		
		
		/*********************************/
		/**		Cr�ation connexion bd	**/
		/*********************************/
		try {
			bd = new Bd("jdbc:oracle:thin:@im2ag-oracle.e.ujf-grenoble.fr:1521:im2ag", "claudeau", "bd");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		/*************************************************************/
		/**		Cr�ation des objets DAO avec jointures (ou pas)		**/
		/*************************************************************/
		//Cr�ation des tables sans cl�s �trang�res en premier
		DAOArticle = new DAOArticle(null);
		//Puis les tables avec cl�s �trang�res (m�me syst�me BDD)
		HashMap<DAOTable, String> lstJointuresTbl1 = new HashMap<>();
		lstJointuresTbl1.put(DAOArticle, "Utilisateur.id = Article.id");
		DAOUtilisateur= new DAOUtilisateur(lstJointuresTbl1);
		
		
		
		
		/**______________Partie non obligatoire______________**/
		
		
		/*****************************************************/
		/**				Suppression des tables				**/
		/*****************************************************/
		bd.request(DAOUtilisateur.drop());			//Pas obligatoire si d�j� cr�er en BDD
		bd.request(DAOArticle.drop());			//Pas obligatoire si d�j� cr�er en BDD
		
		
		/*****************************************************/
		/**			Cr�ation des tables en Base	 			**/
		/*****************************************************/
		bd.request(DAOArticle.createTable());	//Pas obligatoire si d�j� cr�er en BDD
		bd.request(DAOUtilisateur.createTable());	//Pas obligatoire si d�j� cr�er en BDD
		
	}

	public static ManagerDAO getInstance() { return instance; }

	public static DAOUtilisateur getDAOUtilisateur() { return DAOUtilisateur; }

	public static DAOArticle getDAOArticle() { return DAOArticle; }

	public static Bd getBd() { return bd; }
	
	
}
