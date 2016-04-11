package framework.bdd.requete;

public abstract class DAOTable {
	
	/** Repr�sente le nom de la classe **/
	private String nomTable;
	
	private boolean nomSet = false;

	/**
	 * Permet de r�cuperer le nom de la table
	 * @return le nom de la table au format string
	 */
	public String getNomTable() { return nomTable;	}

	/**
	 * Permet de d�finir le nom de la table
	 * @param nomTable le nouveau nom de la table
	 */
	public void setNomTable(String nomTable) { 
		if (!nomSet) {
			this.nomTable = nomTable;
			this.nomSet = true;
		}
	}
	
	
	
}
