package achala.modules.publication;

import java.sql.Date;
import achala.modules.publication.metier.*;
import junit.framework.TestCase;

public class Test extends TestCase {

	public void TestArticle() {
		ManagerApp.Instance().initialisation();
		ManagerApp.Instance().getListArticles();
		ManagerApp.Instance().getListCommentaires();
		assertEquals(ManagerApp.Instance().getListArticles().size(),2);
		assertEquals(ManagerApp.Instance().getListCommentaires().size(),4);
		Commentaire c5 = new Commentaire(5, "Commentaire 5", "Aurélien Fernandes", new Date(25,04,2016),1);
		Commentaire c6 = new Commentaire(6, "Commentaire 6", "Audrey C.", new Date(25,04,2016),2);
		assertEquals(ManagerApp.Instance().getListCommentaires().size(),6);
		Article a3 = new Article(3,"Article 3","Contenu 3","Oxford",new Date(26,04,2016));
		assertEquals(ManagerApp.Instance().getListArticles().size(),3);
	
	}
}
