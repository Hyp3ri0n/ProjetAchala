package framework.datamanager.requete;

import java.util.HashMap;
import java.util.Map;

public abstract class DAOTable {
	
	/** Repr�sente le nom de la table **/
	private String nomTable;
	/** Permet de pouvoir d�finir le nom qu'une seul fois **/
	private boolean nomSet = false;
	/** les attributs de la table avec leurs typeBD **/
	private Map<String, TypeBD> attributs = new HashMap<>();

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

	/**
	 * Permet de r�cup�rer les attributs de la table avec leurs typeBD
	 * @return les attributs de la table avec leurs typeBD
	 */
	public Map<String, TypeBD> getAttributs() {	return this.attributs; }

	/**
	 * Permet de d�finir les attributs de la table avec leurs typeBD
	 * @param attributs les nouveaux attributs de la table avec leurs typeBD
	 */
	public void setAttributs(Map<String, TypeBD> attributs) { this.attributs = attributs; }
}
