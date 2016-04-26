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
		Commentaire c4 = new Commentaire(4, "Commentaire 4", "Aurélien Fernandes","25-04-2016",1,false);
		Commentaire c5 = new Commentaire(5, "Commentaire 5", "Audrey C.","25-04-2016",2,false);
		Article a3 = new Article(3,"Article 3","Contenu 3","Oxford","26-04-2016",false);
		c5.setAuteur("Jean");
		c4.supprimer();
	}
	
	//Test
	public void test2() throws Exception {
		assertEquals(5,sizeCommentaires + 1);
		assertEquals(3,sizeArticles + 1);
		assertEquals("Jean",Commentaire.getCommentaireById(5).getAuteur());
	}
	
	//After
	public void tearDown() {
		
	}
	

}