package achala.datamanager.bdd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;


public class Update extends Requete {
	/** La liste des attributs à modifier avec leur valeur **/
	private Map<String, String> attributs = new HashMap<>();
	/** La liste des tables à referencer **/
	private DAOTable table;
	/** La clause where **/
	private String where;
	
	/**
	 * Constructeur public
	 * @param attributs La liste des attributs à modifier avec leur valeur
	 * @param tables La liste des tables à referencer
	 */
	public Update(Map<String, String> attributs, DAOTable table) {
		super();
		this.attributs = attributs;
		this.table = table;
	}

	/**
	 * Constructeur public
	 * @param attributs La liste des attributs à modifier avec leur valeur
	 * @param tables La liste des tables à referencer
	 * @param where La clause "where" au format string sans le where ([...] "Where attr1 > 42")
	 */
	public Update(Map<String, String> attributs, DAOTable table, String where) {
		this(attributs, table);
		this.where = where;
	}

	
	@Override
	public ResultSet execute(Statement stmt) throws SQLException {
		
		String req = "UPDATE ";
		
		req += this.table.getNomTable();
		
		req += " SET ";
		
		int cptAttr = 0;
		for(String attr : this.attributs.keySet()) {
			cptAttr++;
			
			if (!this.table.containsAttribut(attr)) throw new SQLException("Attribut non existant");
			
			req += attr + " = " + TypeBD.syntaxe(this.attributs.get(attr), this.table.getAttributs().get(attr));
			
			if (this.attributs.size() == cptAttr) break;
			
			req += ", ";
		}
		
		req += " " + this.where;
		
		System.out.println(req);
		
		return stmt.executeQuery(req);
	}

}
