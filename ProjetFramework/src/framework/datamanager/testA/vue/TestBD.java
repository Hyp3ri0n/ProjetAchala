package framework.datamanager.testA.vue;

import framework.datamanager.testA.dao.ManagerDAO;

public class TestBD {

	public static void main(String[] args) {		
		
		//Test SELECT
		ManagerDAO.getBd().request(ManagerDAO.getDAOUtilisateur().selectSomething());
		//Test UPDATE
		ManagerDAO.getBd().request(ManagerDAO.getDAOArticle().updateSomething());
		//Test INSERT
		for(int i =1; i<2;i++){	
			ManagerDAO.getBd().request(ManagerDAO.getDAOUtilisateur().insertSomething(i,"jea","j"));
			
		}
	}

}
