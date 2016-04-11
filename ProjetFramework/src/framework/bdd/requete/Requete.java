package framework.bdd.requete;

public abstract class Requete {
	
	/**
	 * Permet d'éxecuter la requête
	 * @param co la connexion avec la bdd
	 * @return true si tout c'est bien passer false sinon
	 */
	public abstract boolean execute(java.sql.Connection co);
	
}
