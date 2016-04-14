package achala.datamanager.bdd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public abstract class Requete {
	
	/**
	 * Permet d'�xecuter la requ�te
	 * @param stmt la connexion avec la bdd
	 * @return Un ResultSet null si vide sinon le r�sultat
	 * @throws SQLException 
	 */
	public abstract ResultSet execute(Statement stmt) throws SQLException;
	
}
