package framework.datamanager.request;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Delete extends DeleteManager {

	/** La clause where **/
	private String where;
	
	/**
	 * Constructeur public
	 * @param table La table à créer
	 * @param where La clause where
	 */
	public Delete(DAOTable table, String where) {
		super();
		this.table = table;
		this.where = where;
	}
	
	@Override
	public ResultSet execute(Statement stmt) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
