package modules.publication.dao;
import java.sql.SQLException;
import java.util.HashMap;

import achala.datamanager.Bd;
import achala.datamanager.bdd.DAOTable;
import modules.publication.dao.DAOArticle;
import modules.publication.dao.DAOCommentaire;
import modules.publication.dao.ManagerDAO;


public class ManagerDAO {
		
		// ATTRIBUTS PRIVES
		private static ManagerDAO instance = new ManagerDAO();
		private static Bd bd;
		private static DAOArticle DAOArticle ;
		private static DAOCommentaire DAOCommentaire ;
		
		
		// METHODES
		/**
		 * Constructeur
		 */
		private ManagerDAO() {
			/**______________Partie obligatoire______________**/
			
			
			/*********************************/
			/**		Creation connexion bd	**/
			/*********************************/
			try {
				bd = new Bd("jdbc:oracle:thin:@im2ag-oracle.e.ujf-grenoble.fr:1521:im2ag", "ortizlu", "bd");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
			/*************************************************************/
			/**		Creation des objets DAO avec jointures (ou pas)		**/
			/*************************************************************/
			//Creation des tables sans cles etrangeres en premier
			DAOArticle = new DAOArticle(null);
			
			//Puis les tables avec cles etrangeres (meme systeme BDD)
			HashMap<DAOTable, String> lstJointuresTbl = new HashMap<>();
			lstJointuresTbl.put(DAOArticle, "Commentaire.article = Article.id");
			DAOCommentaire= new DAOCommentaire(lstJointuresTbl);
			
		}

		//ACCESSEURS
		/**
		 * Accesseur ManagerDAO Instance
		 * @return objet ManagerDAO
		 */
		public static ManagerDAO getInstance() { return instance; }

		/**
		 * Accesseur DAOArticle
		 * @return objet DAOArticle
		 */
		public static DAOArticle getDAOArticle() { return DAOArticle; }

		/**
		 * Accesseur DAOCommentaire
		 * @return objet DAOCommentaire
		 */
		public static DAOCommentaire getDAOCommentaire() { return DAOCommentaire; }
		
		/**
		 * Accesseur BD
		 * @return objet BD
		 */
		public static Bd getBd() { return bd; }
		
		
}


