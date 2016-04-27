package achala.modules.publication;

import achala.modules.publication.metier.*;
import junit.framework.TestCase;

public class Test extends TestCase {
	int sizeArticles;
	int sizeCommentaires;
	//Before
	public void setUp() {
		ManagerApp.Instance().initialisation();
		sizeArticles = ManagerApp.Instance().getListArticles().size();
		sizeCommentaires = ManagerApp.Instance().getListCommentaires().size();
		Commentaire c4 = new Commentaire("Commentaire 4", "Aurélien Fernandes","25-04-2016",1);
		Commentaire c5 = new Commentaire("Commentaire 5", "Audrey C.","25-04-2016",2);
		Article a3 = new Article("Article 3","Contenu 3","Oxford","26-04-2016");
		c5.setAuteur("Jean");
		c4.supprimer();
	}
	
	//Test
	public void test2() throws Exception {
		assertEquals(5,sizeCommentaires + 1);
		assertEquals(4,sizeArticles + 1);
		assertEquals("Jean",Commentaire.getCommentaireById(5).getAuteur());
	}
	
	//After
	public void tearDown() {
		
	}
	

}