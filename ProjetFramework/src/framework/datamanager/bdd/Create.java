package framework.datamanager.bdd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


public class Create extends Requete {
	/** La table � cr�er **/
	private DAOTable table;
	/** Indice de primary key par rapport � la liste des attributs de la table **/
	private List<Integer> IndicesPrimaryKey;
	/** Repr�sente la requ�te complexe **/
	private String req;
	/** Repr�sente l'utilisation ou non de la requ�te complexe **/
	private boolean reqUser = false;
	
	/**
	 * Constructeur public
	 * @param table La table � cr�er
	 * @param indicePK L'indice de primary key par rapport � la liste des attributs de la table
	 */
	public Create(DAOTable table, List<Integer> indicesPK) {
		super();
		this.table = table;
		this.IndicesPrimaryKey = indicesPK;
	}
	
	/**
	 * Constructeur public de la requ�te create complexe
	 * @param req La requete complexe de cr�ation
	 */
	public Create(String req) {
		super();
		this.req = req;
		this.reqUser = true;
	}

	
	@Override
	public ResultSet execute(Statement stmt) throws SQLException {

		System.out.println(this.req);
		if (reqUser)
			return stmt.executeQuery(this.req);
		
		
		String req = "CREATE ";
		
		req += this.table.getNomTable() + " (";
		
		int cptAttr = 0;
		for(String attr : this.table.getAttributs().keySet()) {
			cptAttr++;
			
			req += attr + " " + this.table.getAttributs().get(attr).toString();
			
			if (this.IndicesPrimaryKey.contains(cptAttr)) {
				req += " PRIMARY KEY";
				this.IndicesPrimaryKey.remove(cptAttr);
			}
			
			if (this.table.getAttributs().keySet().size() == cptAttr) break;
			
			req += ", ";
		}
		
		//WIP
//		int cptJoins = 0;
//		for(DAOTable table : this.table.getJointures().keySet()) {
//			cptJoins++;
//			
//			//req += attr + " " + this.table.getAttributs().get(attr).toString();
//			
//			if (cptJoins == this.table.getJointures().size()) break;
//			
//			req += ", ";
//		}
		
		req += " )";
		
		return stmt.executeQuery(req);
	}

}
