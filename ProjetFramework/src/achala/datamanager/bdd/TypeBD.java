package achala.datamanager.bdd;

public enum TypeBD {
	
	INTEGER("INTEGER"),
	STRING("VARCHAR2"),
	DOUBLE("NUMBER"),
	DATE("DATE"),
	CHAR("CHAR");
	
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
		case CHAR:
			valueDone = value;
			break;
		case DATE:
			valueDone = "TO_DATE(\'" + value + "\', \'dd-mm-yyyy\')";
			break;
		case DOUBLE:
			valueDone = value;
			break;
		case INTEGER:
			valueDone = value;
			break;
		case STRING:
			valueDone = "\'" + value + "\'";
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
