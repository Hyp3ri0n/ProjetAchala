package framework.datamanager.requete;

import java.sql.ResultSet;

public abstract class Requete {
	
	/**
	 * Permet d'éxecuter la requête
	 * @param co la connexion avec la bdd
	 * @return Un ResultSet null si vide sinon le résultat
	 */
	public abstract ResultSet execute(java.sql.Connection co);
	
}
