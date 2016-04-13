package framework.datamanager.request;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Create extends Requete {
	/** La table � cr�er **/
	private DAOTable table;
	/** Indice de primary key par rapport � la liste des attributs de la table **/
	private int IndicePrimaryKey;
	/** ... **/
	private String req;
	/** ... **/
	private boolean reqUser = false;
	
	/**
	 * Constructeur public
	 * @param table La table � cr�er
	 * @param indicePK L'indice de primary key par rapport � la liste des attributs de la table
	 */
	public Create(DAOTable table, int indicePK) {
		super();
		this.table = table;
		this.IndicePrimaryKey = indicePK;
	}
	
	/**
	 * Constructeur public
	 * @param req La requete de cr�ation
	 */
	public Create(String req) {
		super();
		this.req = req;
		this.reqUser = true;
	}

	
	@Override
	public ResultSet execute(Statement stmt) throws SQLException {

		if (reqUser)
			return stmt.executeQuery(this.req);
		
		
		String req = "CREATE ";
		
		req += this.table.getNomTable() + " (";
		
		int cptAttr = 0;
		for(String attr : this.table.getAttributs().keySet()) {
			cptAttr++;
			
			req += attr + " " + this.table.getAttributs().get(attr).toString();
			
			if (cptAttr == this.IndicePrimaryKey) req += " PRIMARY KEY";
			
			if (this.table.getAttributs().keySet().size() == cptAttr) break;
			
			req += ", ";
		}
		
		int cptJoins = 0;
		for(DAOTable table : this.table.getJointures().keySet()) {
			cptJoins++;
			
			//req += attr + " " + this.table.getAttributs().get(attr).toString();
			
			if (cptJoins == this.table.getJointures().size()) break;
			
			req += ", ";
		}
		
		req += " )";
		
		return stmt.executeQuery(req);
	}

}
