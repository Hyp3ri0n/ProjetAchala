package achala.modules.publication;

import achala.modules.publication.metier.*;
import junit.framework.TestCase;

public class Test extends TestCase {
	int sizeArticles,sizeCommentaires,sizeCommentairesAfter,sizeArticlesAfter;
	//Before
	public void setUp() {
		ManagerApp.Instance().initialisation();
		sizeArticles = ManagerApp.Instance().getListArticles().size();
		sizeCommentaires = ManagerApp.Instance().getListCommentaires().size();
		Article a1 = new Article("RArticle 1","Contenu de l'article 1","Denis Bouhineau","25-04-2016");
		Article a2 = new Article("BArticle 2","Contenu de l'article 2","Carl","25-04-2016");
		Commentaire c4 = new Commentaire("Commentaire 4", "Aurélien Fernandes","25-04-2016",1);
		Commentaire c5 = new Commentaire("Commentaire 5", "Audrey C.","25-04-2016",2);
		Article a3 = new Article("Article 3","Contenu 3","Oxford","26-04-2016");
		c5.setAuteur("Jean");
		c4.supprimer();
		ManagerApp.Instance().tri(true);
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