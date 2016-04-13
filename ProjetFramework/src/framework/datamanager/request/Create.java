package framework.datamanager.request;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Create extends Requete {
	/** La table à créer **/
	private DAOTable table;
	
	/**
	 * Constructeur public
	 * @param table La table à créer
	 */
	public Create(DAOTable table) {
		super();
		this.table = table;
	}

	
	@Override
	public ResultSet execute(Statement stmt) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
