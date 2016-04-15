package achala.datamanager.testA.vue;

import java.sql.ResultSet;
import java.sql.SQLException;

import achala.datamanager.testA.dao.ManagerDAO;

public class TestBD {

	public static void main(String[] args) {		
		//Test SELECT
		ResultSet rs = ManagerDAO.getBd().request(ManagerDAO.getDAOUtilisateur().selectSomething());
		try {
			while (rs.next())
				{
					String nom = rs.getString(1);
					String prenom =  rs.getString(2);
					String libelle =  rs.getString(3);
					System.out.println(nom+" "+prenom + " " + libelle);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Test UPDATE
		//ManagerDAO.getBd().request(ManagerDAO.getDAOArticle().updateSomething());
		//Test INSERT
		//for(int i =1; i<2;i++){	
			//ManagerDAO.getBd().request(ManagerDAO.getDAOUtilisateur().insertSomething(i,"jea","j"));
			
		//}
	}
}
