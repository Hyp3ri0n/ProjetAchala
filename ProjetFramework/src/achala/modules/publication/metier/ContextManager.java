package achala.modules.publication.metier;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import achala.modules.publication.dao.ManagerDAO;

public class ContextManager {
	
	private static final ContextManager instance = new ContextManager();
	private List<Article> listArticles = new ArrayList<>();
	private List<Commentaire> listCommentaires = new ArrayList<>();
	
	private ContextManager() {}
	
	public void initialisation() {
		
		/**______________Partie obligatoire______________**/
		
		
		/*************************************************************/
		/**				Création des objets Metier					**/
		/*************************************************************/
		ResultSet rs = ManagerDAO.getBd().request(ManagerDAO.getDAOArticle().selectAll());
		
		try {
			while (rs.next()) {
				listArticles.add(new Article(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)));
			}
		
			rs = ManagerDAO.getBd().request(ManagerDAO.getDAOCommentaire().selectAll());
			
			Commentaire com;
			while (rs.next()) {
				for(Article art : listArticles) {
					if (art.getId() == rs.getInt(4)) {
						com = new Commentaire(rs.getInt(1),rs.getString(2),rs.getString(3));
						if(listCommentaires.add(com)) {
							art.ajouterCommentaire(com);
						}
						break;
					}	
				}
			}
			
			rs.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static ContextManager Instance() { return instance;	}

	public List<Article> getListTable1() { return listArticles; }

	public List<Commentaire> getListTable2() { return listCommentaires; }
}
