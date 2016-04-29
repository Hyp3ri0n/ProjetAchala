package achala.datamanager.bdd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public abstract class Requete {
	
	/**
	 * Permet d'executer la requete
	 * @param stmt la connexion avec la bdd
	 * @return Un ResultSet null si vide sinon le resultat
	 * @throws SQLException 
	 */
	public abstract ResultSet execute(Statement stmt) throws SQLException;
	
}
