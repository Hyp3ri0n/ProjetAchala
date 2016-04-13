package framework.datamanager.request;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Insert extends Requete {
	/** La liste des attributs � cr�er avec leur valeur **/
	private Map<String, String> attributs = new HashMap<>();
	/** La table � r�f�rencer **/
	private DAOTable table;
	
	/**
	 * Constructeur public
	 * @param attributs La liste des attributs � cr�er avec leurs valeurs
	 * @param table La table � r�f�rencer
	 */
	public Insert(HashMap<String, String> attributs, DAOTable table) {
		super();
		this.attributs = attributs;
		this.table = table;
	}

	
	@Override
	public ResultSet execute(Statement stmt) {
		// TODO Auto-generated method stub
		return null;
	}

}
