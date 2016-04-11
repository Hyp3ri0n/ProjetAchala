package framework.datamanager.requete;

public enum TypeBD {
	
	INTEGER("INT"),
	STRING("VARCHAR2");
	
	/** Repr�sente le type sql **/
	String typeSQL;
	
	/**
	 * Constructeur par d�faut
	 * @param typeSQL Le type sql
	 */
	TypeBD(String typeSQL) { this.typeSQL = typeSQL; }
	
	@Override
	public String toString() {	return this.typeSQL; }
}
