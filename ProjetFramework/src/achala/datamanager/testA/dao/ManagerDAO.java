package achala.datamanager.testA.dao;

import java.sql.SQLException;
import java.util.HashMap;

import achala.datamanager.Bd;
import achala.datamanager.bdd.DAOTable;

public class ManagerDAO {
	private static ManagerDAO instance = new ManagerDAO();
	private static Bd bd;
	private static DAOUtilisateur DAOUtilisateur ;
	private static DAOArticle DAOArticle;
	
	private ManagerDAO() {
/**______________Partie obligatoire______________**/
		
		
		/*********************************/
		/**		Creation connexion bd	**/
		/*********************************/
		try {
			bd = new Bd("jdbc:oracle:thin:@im2ag-oracle.e.ujf-grenoble.fr:1521:im2ag", "claudeau", "bd");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		/*************************************************************/
		/**		Creation des objets DAO avec jointures (ou pas)		**/
		/*************************************************************/
		//Creation des tables sans cles etrangeres en premier
		DAOArticle = new DAOArticle(null);
		//Puis les tables avec cles etrangeres (meme systeme BDD)
		HashMap<DAOTable, String> lstJointuresTbl1 = new HashMap<>();
		lstJointuresTbl1.put(DAOArticle, "Utilisateur.id = Article.id");
		DAOUtilisateur= new DAOUtilisateur(lstJointuresTbl1);
		
		
		
		
		/**______________Partie non obligatoire______________**/
		
		
		/*****************************************************/
		/**				Suppression des tables				**/
		/*****************************************************/
		bd.request(DAOUtilisateur.drop());			//Pas obligatoire si deja creer en BDD
		bd.request(DAOArticle.drop());			//Pas obligatoire si deja creer en BDD
		
		
		/*****************************************************/
		/**			Creation des tables en Base	 			**/
		/*****************************************************/
		bd.request(DAOArticle.createTable());	//Pas obligatoire si deja creer en BDD
		bd.request(DAOUtilisateur.createTable());	//Pas obligatoire si deja creer en BDD
		
	}

	public static ManagerDAO getInstance() { return instance; }

	public static DAOUtilisateur getDAOUtilisateur() { return DAOUtilisateur; }

	public static DAOArticle getDAOArticle() { return DAOArticle; }

	public static Bd getBd() { return bd; }
	
	
}
