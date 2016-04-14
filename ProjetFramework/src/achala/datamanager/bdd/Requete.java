package achala.datamanager.bdd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public abstract class Requete {
	
	/**
	 * Permet d'éxecuter la requête
	 * @param stmt la connexion avec la bdd
	 * @return Un ResultSet null si vide sinon le résultat
	 * @throws SQLException 
	 */
	public abstract ResultSet execute(Statement stmt) throws SQLException;
	
}
