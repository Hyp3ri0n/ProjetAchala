package framework.datamanager.testA.dao;

import java.util.HashMap;

import framework.datamanager.Bd;
import framework.datamanager.bdd.DAOTable;
import framework.datamanager.testA.dao.DAOUtilisateur;
import framework.datamanager.testA.dao.DAOArticle;
import framework.datamanager.testA.dao.ManagerDAO;

public class ManagerDAO {
	private static ManagerDAO instance = new ManagerDAO();
	private static Bd bd;
	private static DAOUtilisateur DAOUtilisateur ;
	private static DAOArticle DAOArticle;
	
	private ManagerDAO() {
		
		/*********************************/
		/**		Cr�ation connexion bd	**/
		/*********************************/
		bd = new Bd("", "", "");
		
		
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
