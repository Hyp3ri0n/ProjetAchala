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
		Article a1 = new Article("Article 1","Contenu de l'article 1","Denis Bouhineau","25-04-2016");
		Article a2 = new Article("Article 2","Contenu de l'article 2","Carl","25-04-2016");
		Commentaire c4 = new Commentaire("Commentaire 4", "Aurélien Fernandes","25-04-2016",1);
		Commentaire c5 = new Commentaire("Commentaire 5", "Audrey C.","25-04-2016",2);
		Article a3 = new Article("Article 3","Contenu 3","Oxford","26-04-2016");
		c5.setAuteur("Jean");
		c4.supprimer();
	}
	
	//Test
	public void test2() throws Exception {
		assertEquals(2,sizeCommentaires + 2);
		assertEquals(3,sizeArticles + 3);
		assertEquals("Jean",Commentaire.getCommentaireById(2).getAuteur());
	}
	
	//After
	public void tearDown() {
		
	}
	

}