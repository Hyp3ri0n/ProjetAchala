package framework.datamanager.test.vue;

import java.sql.ResultSet;

import framework.datamanager.test.dao.ManagerDAO;

public class TestBD {

	public static void main(String[] args) {		
		
		//Test SELECT
		ResultSet rs = ManagerDAO.getBd().request(ManagerDAO.getDAOTable1().selectSomething());
		//Test UPDATE
		ManagerDAO.getBd().request(ManagerDAO.getDAOTable2().updateSomething());
		//Test INSERT
		ManagerDAO.getBd().request(ManagerDAO.getDAOTable2().insertSomething());
		//Test DELETE
		ManagerDAO.getBd().request(ManagerDAO.getDAOTable1().deleteSomething());
		//Test DROP
		ManagerDAO.getBd().request(ManagerDAO.getDAOTable2().dropSomething());
		
	}

}
