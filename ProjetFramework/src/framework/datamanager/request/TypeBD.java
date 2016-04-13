package framework.datamanager.request;

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
	
	/**
	 * Permet de récuperer la valeurs avec la bonne syntaxe pour oracle
	 * @param value La valeur à traiter
	 * @param type Le type de la valeur
	 * @return La valeur avec la bonne syntaxe
	 */
	public static String syntaxe(String value, TypeBD type) {	
		String valueDone;
		
		switch (type) {
		case INTEGER:
			valueDone = value;
			break;
		case STRING:
			valueDone = "\"" + value + "\"";
			break;
		default:
			valueDone = value;
			break;
		}
		
		
		return valueDone; 	
	}
	
	
	@Override
	public String toString() {	return this.typeSQL; }
}
