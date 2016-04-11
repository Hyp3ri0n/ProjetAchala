package framework.datamanager.requete;

import java.sql.ResultSet;

public abstract class Requete {
	
	/**
	 * Permet d'�xecuter la requ�te
	 * @param co la connexion avec la bdd
	 * @return Un ResultSet null si vide sinon le r�sultat
	 */
	public abstract ResultSet execute(java.sql.Connection co);
	
}
