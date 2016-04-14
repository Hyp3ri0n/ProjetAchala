package framework.datamanager.bdd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


public class Create extends Requete {
	/** La table à créer **/
	private DAOTable table;
	/** Indice de primary key par rapport à la liste des attributs de la table **/
	private List<Integer> IndicesPrimaryKey;
	/** Représente la requête complexe **/
	private String req;
	/** Représente l'utilisation ou non de la requête complexe **/
	private boolean reqUser = false;
	
	/**
	 * Constructeur public
	 * @param table La table à créer
	 * @param indicePK L'indice de primary key par rapport à la liste des attributs de la table
	 */
	public Create(DAOTable table, List<Integer> indicesPK) {
		super();
		this.table = table;
		this.IndicesPrimaryKey = indicesPK;
	}
	
	/**
	 * Constructeur public de la requête create complexe
	 * @param req La requete complexe de création
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
