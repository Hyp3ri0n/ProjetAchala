package achala.modules.publication;

import achala.modules.publication.dao.ManagerDAO;
import achala.modules.publication.metier.*;
import junit.framework.TestCase;

public class Test extends TestCase {
	int sizeArticles,sizeCommentaires,sizeCommentairesAfter,sizeArticlesAfter;

	/**
	 * Methode d'initialisation
	 */
	public void setUp() {
		// Suppression puis creation des tables
		ManagerDAO.getBd().request(ManagerDAO.getDAOCommentaire().drop());
		ManagerDAO.getBd().request(ManagerDAO.getDAOArticle().drop());
		ManagerDAO.getBd().request(ManagerDAO.getDAOArticle().createTable());
		ManagerDAO.getBd().request(ManagerDAO.getDAOCommentaire().createTable());
		
		// Creation du jeu d'essai
		ManagerApp.Instance().initialisation();
		sizeArticles = ManagerApp.Instance().getListArticles().size();
		sizeCommentaires = ManagerApp.Instance().getListCommentaires().size();
		Article a1 = new Article("Prolog","Les atouts de la récursivité","Denis Bouhineau","25-04-2016");
		Article a2 = new Article("Coder en C","Comment coder en C, les avantages / incovénients","Carlito","26-04-2016");
		Commentaire c1 = new Commentaire("J'adore !!", "Jean","25-04-2016",1);
		Commentaire c2 = new Commentaire("Sympa", "Audrey C.","25-04-2016",2);
		Article a3 = new Article("JavaCC","Comment utiliser JavaCC??....","Roi Hennock","27-04-2016");
		a3.setAuteur("Aurélien Fernando");
		c1.supprimer();
		ManagerApp.Instance().triParId();
		sizeArticlesAfter = ManagerApp.Instance().getListArticles().size();
		sizeCommentairesAfter = ManagerApp.Instance().getListCommentaires().size();
		
		// Test tri par id
		for(Article art:ManagerApp.Instance().getListArticles()) {
			System.out.println("Art id :"+art.getId());
		}
		for(Commentaire com:ManagerApp.Instance().getListCommentaires()) {
			System.out.println("Com id :"+com.getId());
		}
	}
	
	/**
	 * Methode de test
	 * @throws Exception
	 */
	public void test1() throws Exception {
		assertEquals(sizeCommentaires + 1,sizeCommentairesAfter);
		assertEquals(sizeArticles + 3,sizeArticlesAfter);
		assertEquals("Aurélien Fernando",Article.getArticleById(3).getAuteur());
	}
	

}