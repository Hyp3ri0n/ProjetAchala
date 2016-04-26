package achala.datamanager.bdd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Delete extends DeleteManager {

	/** La clause where **/
	private String where = "";
	
	/**
	 * Constructeur public
	 * @param table La table à creer
	 * @param where La clause where
	 */
	public Delete(DAOTable table, String where) {
		super();
		this.table = table;
		this.where = where;
	}
	
	@Override
	public ResultSet execute(Statement stmt) throws SQLException {
		String req = "DELETE FROM ";
		
		req += this.table.getNomTable();
		
		req += " " + this.where;
		
		System.out.println(req);
		
		return stmt.executeQuery(req);
	}

}
