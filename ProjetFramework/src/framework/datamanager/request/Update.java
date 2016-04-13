package framework.datamanager.request;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Update extends Requete {
	/** La liste des attributs à modifier avec leur valeur **/
	private Map<String, String> attributs = new HashMap<>();
	/** La liste des tables à référencer **/
	private List<DAOTable> tables = new ArrayList<>();
	/** La clause where **/
	private String where;
	
	/**
	 * Constructeur public
	 * @param attributs La liste des attributs à modifier avec leur valeur
	 * @param tables La liste des tables à référencer
	 */
	public Update(Map<String, String> attributs, List<DAOTable> tables) {
		super();
		this.attributs = attributs;
		this.tables = tables;
	}

	/**
	 * Constructeur public
	 * @param attributs La liste des attributs à modifier avec leur valeur
	 * @param tables La liste des tables à référencer
	 * @param where La clause "where" au format string sans le where ([...] "Where attr1 > 42")
	 */
	public Update(Map<String, String> attributs, List<DAOTable> tables, String where) {
		this(attributs, tables);
		this.where = where;
	}

	
	@Override
	public ResultSet execute(Statement stmt) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
