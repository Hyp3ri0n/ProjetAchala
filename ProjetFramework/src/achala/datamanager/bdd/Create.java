package achala.datamanager.bdd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Create extends Requete {
	/** Represente la requ�te complexe **/
	private String req;
	
	/**
	 * Constructeur public de la requ�te create complexe
	 * @param req La requete complexe de creation
	 */
	public Create(String req) {
		super();
		this.req = req;
	}

	
	@Override
	public ResultSet execute(Statement stmt) throws SQLException {

		System.out.println(this.req);
		return stmt.executeQuery(this.req);
	}

}
