package achala.modules.publication;

import achala.modules.publication.dao.ManagerDAO;
import achala.modules.publication.metier.*;
import junit.framework.TestCase;

public class Test extends TestCase {
	int sizeArticles,sizeCommentaires,sizeCommentairesAfter,sizeArticlesAfter;
	//Before
	public void setUp() {
		ManagerDAO.getBd().request(ManagerDAO.getDAOCommentaire().drop());
		ManagerDAO.getBd().request(ManagerDAO.getDAOArticle().drop());
		ManagerDAO.getBd().request(ManagerDAO.getDAOArticle().createTable());
		ManagerDAO.getBd().request(ManagerDAO.getDAOCommentaire().createTable());
		ManagerApp.Instance().initialisation();
		sizeArticles = ManagerApp.Instance().getListArticles().size();
		sizeCommentaires = ManagerApp.Instance().getListCommentaires().size();
		Article a1 = new Article("La truelle de Prolog","La récursivité c'est la vie","Denis Bouhineau","25-04-2016");
		Article a2 = new Article("Yolo","Contenu de l'article 2","Carlito","26-04-2016");
		Commentaire c4 = new Commentaire("J'adore !!", "Jean","25-04-2016",1);
		Commentaire c5 = new Commentaire("Commentaire 5", "Audrey C.","25-04-2016",2);
		Article a3 = new Article("Noirs et professionnels","L'album est dans les bacs !","Roi Hennock","27-04-2016");
		c5.setAuteur("Aurélien Fernando");
		c4.supprimer();
		ManagerApp.Instance().triParId();
		sizeArticlesAfter = ManagerApp.Instance().getListArticles().size();
		sizeCommentairesAfter = ManagerApp.Instance().getListCommentaires().size();
		
		// Test tri par id
		/*for(Article art:ManagerApp.Instance().getListArticles()) {
			System.out.println("Art id :"+art.getId());
		}
		for(Commentaire com:ManagerApp.Instance().getListCommentaires()) {
			System.out.println("Com id :"+com.getId());
		}*/
	}
	
	//Test
	public void test1() throws Exception {
		assertEquals(sizeCommentaires + 1,sizeCommentairesAfter);
		assertEquals(sizeArticles + 3,sizeArticlesAfter);
		//assertEquals("Jean",Commentaire.getCommentaireById(2).getAuteur());	
	}
	
	//After
	public void tearDown() {
		
	}
	

}