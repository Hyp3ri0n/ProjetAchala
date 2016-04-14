package achala.datamanager.bdd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class Select extends Requete {
	
	/** La liste des attributs à afficher **/
	private List<String> attributs = new ArrayList<>();
	/** La liste des tables à référencer **/
	private List<DAOTable> tables = new ArrayList<>();
	/** La clause where **/
	private String where = "";
	/** La clause group by **/
	private String groupBy = "";
	/** La clause having **/
	private String having = "";
	
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
	 * @param where La clause "where" au format string avec le where ([...] "Where attr1 > 42")
	 */
	public Select(List<String> attributs, List<DAOTable> tables, String where) {
		this(attributs, tables);
		this.where = where;
	}
	
	/**
	 * Constructeur public
	 * @param attributs La liste des attributs à afficher (Select attr1, attr2 [...])
	 * @param tables La liste des tables à référencer ([...] From table1 JOIN table2 ON [...])
	 * @param where La clause "where" au format string avec le where ([...] "Where attr1 > 42" [...])
	 * @param groupBy La clause "group by" au format string avec le group by ([...] "group by attr1, attr2")
	 */
	public Select(List<String> attributs, List<DAOTable> tables, String where, String groupBy) {
		this(attributs, tables, where);
		this.groupBy = groupBy;
	}

	/**
	 * Constructeur public
	 * @param attributs La liste des attributs à afficher (Select attr1, attr2 [...])
	 * @param tables La liste des tables à référencer ([...] From table1 JOIN table2 ON [...])
	 * @param where La clause "where" au format string avec le where ([...] "Where attr1 > 42" [...])
	 * @param groupBy La clause "group by" au format string avec le group by ([...] "group by attr1, attr2" [...])
	 * @param having La clause "having" au format string avec le having ([...] "having count(attr1) > 42")
	 */
	public Select(List<String> attributs, List<DAOTable> tables, String where, String groupBy, String having) {
		this(attributs, tables, where, groupBy);
		this.having = having;
	}

	
	@Override
	public ResultSet execute(Statement stmt) throws SQLException {
		
		String req = "SELECT ";
		
		int cptAttrs = 0;
		for(String attrs : this.attributs) {
			cptAttrs++;
			
			req+= attrs;
			
			if (this.attributs.size() == cptAttrs) break;
			
			req += ", ";
		}
				
		req += " FROM ";
		DAOTable nextTbl;

		if (this.tables.size() == 1)
		{
			//Requête simple (une seul table)
			req += " " + this.tables.get(0).getNomTable() + " ";
		} else {
			//Requête complexe (plusieurs tables)
			int cptTbls = 0;
			for(DAOTable table : this.tables) {
				cptTbls++;
				
				if (this.tables.size() >= cptTbls + 1) {
					nextTbl = this.tables.get(cptTbls);
					
					if (table.getJointures().get(nextTbl) == null) throw new SQLException("Jointure inexistante");
					
					req += table.getNomTable() + " JOIN " + nextTbl.getNomTable() + " ON " + table.getJointures().get(nextTbl);
					
				}
				req += " ";
			}
		}
		
		req += " " + where + " " + groupBy + " " + having;
				
		System.out.println(req);
		
		return stmt.executeQuery(req);
	}

}
