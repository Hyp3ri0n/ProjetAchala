package framework.datamanager.requete;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Select extends Requete {
	
	/** La liste des attributs à afficher **/
	private List<String> attributs = new ArrayList<>();
	/** La liste des tables à référencer **/
	private List<DAOTable> tables = new ArrayList<>();
	/** La clause where **/
	private String where;
	/** La clause group by **/
	private String groupBy;
	/** La clause having **/
	private String having;
	
	/**
	 * Constructeur public
	 * @param attributs La liste des attributs à afficher (Select attr1, attr2 [...])
	 * @param tables La liste des tables à référencer ([...] From table1 JOIN table2 ON [...])
	 */
	public Select(List<String> attributs, List<DAOTable> tables) {
		super();
		this.attributs = attributs;
		this.tables = tables;
	}

	/**
	 * Constructeur public
	 * @param attributs La liste des attributs à afficher (Select attr1, attr2 [...])
	 * @param tables La liste des tables à référencer ([...] From table1 JOIN table2 ON [...])
	 * @param where La clause "where" au format string sans le where ([...] "Where attr1 > 42")
	 */
	public Select(List<String> attributs, List<DAOTable> tables, String where) {
		this.attributs = attributs;
		this.tables = tables;
		this.where = where;
	}
	
	/**
	 * Constructeur public
	 * @param attributs La liste des attributs à afficher (Select attr1, attr2 [...])
	 * @param tables La liste des tables à référencer ([...] From table1 JOIN table2 ON [...])
	 * @param where La clause "where" au format string sans le where ([...] "Where attr1 > 42" [...])
	 * @param groupBy La clause "group by" au format string sans le group by ([...] "group by attr1, attr2")
	 */
	public Select(List<String> attributs, List<DAOTable> tables, String where, String groupBy) {
		super();
		this.attributs = attributs;
		this.tables = tables;
		this.where = where;
		this.groupBy = groupBy;
	}

	/**
	 * Constructeur public
	 * @param attributs La liste des attributs à afficher (Select attr1, attr2 [...])
	 * @param tables La liste des tables à référencer ([...] From table1 JOIN table2 ON [...])
	 * @param where La clause "where" au format string sans le where ([...] "Where attr1 > 42" [...])
	 * @param groupBy La clause "group by" au format string sans le group by ([...] "group by attr1, attr2" [...])
	 * @param having La clause "having" au format string sans le having ([...] "having count(attr1) > 42")
	 */
	public Select(List<String> attributs, List<DAOTable> tables, String where, String groupBy, String having) {
		super();
		this.attributs = attributs;
		this.tables = tables;
		this.where = where;
		this.groupBy = groupBy;
		this.having = having;
	}

	
	@Override
	public ResultSet execute(Connection co) {
		// TODO Auto-generated method stub
		return null;
	}

}
