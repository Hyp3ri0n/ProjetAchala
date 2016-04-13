package framework.datamanager.request;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import framework.datamanager.exception.DMException;

public class Insert extends Requete {
	/** La liste des attributs à créer avec leur valeur **/
	private Map<String, String> attributs = new HashMap<>();
	/** La table à référencer **/
	private DAOTable table;
	
	/**
	 * Constructeur public
	 * @param attributs La liste des attributs à créer avec leurs valeurs
	 * @param table La table à référencer
	 */
	public Insert(HashMap<String, String> attributs, DAOTable table) {
		super();
		this.attributs = attributs;
		this.table = table;
	}

	
	@Override
	public ResultSet execute(Statement stmt) throws SQLException {
		
		String req = "INSERT INTO ";
		
		req += this.table.getNomTable() + " (";
		
		int cptAttr = 0;
		for(String attr : this.attributs.keySet()) {
			cptAttr++;
			
			if (!this.table.getAttributs().containsKey(attr)) throw new SQLException("Attribut non existant");
			
			req += attr;
			
			if (this.attributs.size() == cptAttr) break;
			
			req += ", ";
		}
		
		req += ") VALUES (";
		
		
		cptAttr = 0;
		for(String attr : this.attributs.keySet()) {
			cptAttr++;
			
			req += TypeBD.syntaxe(this.attributs.get(attr), this.table.getAttributs().get(attr));
			
			if (this.attributs.size() == cptAttr) break;
			
			req += ", ";
		}
		
		req += ")";
		
		System.out.println(req);
		
		return stmt.executeQuery(req);
	}

}
