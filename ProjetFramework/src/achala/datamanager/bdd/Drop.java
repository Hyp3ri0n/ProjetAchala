package achala.datamanager.bdd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Drop extends DeleteManager {
	
	/**
	 * Constructeur public
	 * @param table La table à créer
	 * @param where La clause where
	 */
	public Drop(DAOTable table) {
		super();
		this.table = table;
	}
	
	
	@Override
	public ResultSet execute(Statement stmt) throws SQLException {
		String req = "DROP TABLE ";
		
		req += this.table.getNomTable();

		System.out.println(req);
		
		return stmt.executeQuery(req);
	}

}
