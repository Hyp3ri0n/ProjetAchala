package framework.datamanager.request;

import java.util.HashMap;
import java.util.Map;

public abstract class DAOTable {
	
	/** Repr�sente le nom de la table **/
	private String nomTable;
	/** Permet de pouvoir d�finir le nom qu'une seul fois **/
	private boolean nomSet = false;
	/** les attributs de la table avec leurs typeBD **/
	private Map<String, TypeBD> attributs = new HashMap<>();
	/** les jointures des tables **/
	private Map<DAOTable, String> jointures = new HashMap<>();

	protected DAOTable(Map<DAOTable, String> jointures) { 
		this.setJointures(jointures);
		this.initialisation(); 
	}
	
	/**
	 * Initialisation de la table
	 */
	public abstract void initialisation();
	
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

	/**
	 * Permet de r�cup�rer les jointures des tables
	 * @return les jointures des tables
	 */
	public Map<DAOTable, String> getJointures() { return this.jointures; }

	/**
	 * Permet de r�cup�rer les jointures des tables
	 * @param attributs les jointures des tables
	 */
	public void setJointures(Map<DAOTable, String> jointures) { this.jointures = jointures; }
}
