package framework.datamanager.request;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Drop extends DeleteManager {
	
	/**
	 * Constructeur public
	 * @param table La table � cr�er
	 * @param where La clause where
	 */
	public Drop(DAOTable table) {
		super();
		this.table = table;
	}
	
	
	@Override
	public ResultSet execute(Statement stmt) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
