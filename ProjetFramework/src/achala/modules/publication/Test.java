package achala.modules.publication;

import achala.modules.publication.metier.*;
import junit.framework.TestCase;

public class Test extends TestCase {
	
	//Before
	public void setUp() {
		ManagerApp.Instance().initialisation();
		new Commentaire(4, "Commentaire 4", "Aurélien Fernandes","25/04/2016",1,false);
		new Commentaire(5, "Commentaire 5", "Audrey C.","25/04/2016",2,false);
		new Article(3,"Article 3","Contenu 3","Oxford","26/04/2016",false);
	}
	
	//Test
//	public void test1() throws Exception {
//		assertEquals(2,ManagerApp.Instance().getListArticles().size());
//		assertEquals(3,ManagerApp.Instance().getListCommentaires().size());
//	}
	
	//Test2
	public void test2() throws Exception {
		assertEquals(5,ManagerApp.Instance().getListCommentaires().size());
		assertEquals(3,ManagerApp.Instance().getListArticles().size());
	}
	
	//After
	public void tearDown() {
		
	}
	

}