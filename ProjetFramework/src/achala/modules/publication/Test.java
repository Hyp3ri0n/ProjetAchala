package achala.modules.publication;

import java.sql.Date;
import achala.modules.publication.metier.*;
import junit.framework.TestCase;

public class Test extends TestCase {

	public void TestArticle() {
		ManagerApp.Instance().initialisation();
		ManagerApp.Instance().getListArticles();
		ManagerApp.Instance().getListCommentaires();
//		Article a1 = new Article(1, "Titre 1", "Ortiz Luc", new Date(24,04,2016));
//		Article a2 = new Article(2, "Titre 2", "Contenu 2","Aurélien Fernandes", new Date(25,04,2016));
//		a1.setContenu("Contenu 1");
//		Commentaire c1 = new Commentaire(1, "Commentaire 1", "Audrey C.", new Date(24,04,2016));
//		Commentaire c2 = new Commentaire(2, "Commentaire 2", "Alexis Martinier", new Date(24,04,2016));
//		Commentaire c3 = new Commentaire(3, "Commentaire 3", "Ronbinsoc", new Date(24,04,2016));
//		Commentaire c4 = new Commentaire(4, "Commentaire 4", "Hugo6", new Date(24,04,2016));
//		Commentaire c5 = new Commentaire(5, "Commentaire 5", "Aurélien Fernandes", new Date(25,04,2016));
//		Commentaire c6 = new Commentaire(6, "Commentaire 6", "Audrey C.", new Date(25,04,2016));
//		assertEquals(a1.getLesCommentaires().size(),0);
//		assertEquals(a2.getLesCommentaires().size(),0);
//		a1.ajouterCommentaire(c1);
//		a1.ajouterCommentaire(c2);
//		a1.ajouterCommentaire(c3);
//		a1.ajouterCommentaire(c4);
//		assertEquals(a1.getLesCommentaires().size(),4);
//		a2.ajouterCommentaire(c5);
//		a2.ajouterCommentaire(c6);
//		assertEquals(a2.getLesCommentaires().size(),2);
//		a2.supprimerCommentaire(c6);
//		assertEquals(a2.getLesCommentaires().size(),1);
	
	}
}
