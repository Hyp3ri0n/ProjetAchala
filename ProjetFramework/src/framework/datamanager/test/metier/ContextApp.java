package framework.datamanager.test.metier;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import framework.datamanager.test.dao.ManagerDAO;

public class ContextApp {
	
	private static final ContextApp instance = new ContextApp();
	private List<Table1> listTable1 = new ArrayList<>();
	private List<Table2> listTable2 = new ArrayList<>();
	
	private ContextApp() {}
	
	public void initialisation() {
		
		/**______________Partie obligatoire______________**/
		
		
		/*************************************************************/
		/**				Création des objets Metier					**/
		/*************************************************************/
		ResultSet rs = ManagerDAO.getBd().request(ManagerDAO.getDAOTable2().selectAll());
		
		try {
			while (rs.next()) {
				listTable2.add(new Table2("" + rs.getInt(1),rs.getString(2),rs.getString(3)));
			}
		
			rs = ManagerDAO.getBd().request(ManagerDAO.getDAOTable1().selectAll());
			
			Table2 table2 = null;
			while (rs.next()) {
				for(Table2 tbl : listTable2) {
					if (tbl.getAttrA().equals("" + rs.getInt(5))) {
						table2 = tbl;
						break;
					}
						
				}
				if (table2 != null)
					listTable1.add(new Table1("" + rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4), table2));
				
				table2 = null;
			}
			
			rs.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static ContextApp Instance() { return instance;	}

	public List<Table1> getListTable1() { return listTable1; }

	public List<Table2> getListTable2() { return listTable2; }
}
