package framework.datamanager.requete;

public enum TypeBD {
	
	INTEGER("INT"),
	STRING("VARCHAR2");
	
	/** Représente le type sql **/
	String typeSQL;
	
	/**
	 * Constructeur par défaut
	 * @param typeSQL Le type sql
	 */
	TypeBD(String typeSQL) { this.typeSQL = typeSQL; }
	
	@Override
	public String toString() {	return this.typeSQL; }
}
