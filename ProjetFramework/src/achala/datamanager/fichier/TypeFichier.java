package achala.datamanager.fichier;

public enum TypeFichier {
	XML("xml"),
	TEXT("txt"),
	SQL("sql");
	
	/** Repr�sente l'extension **/
	String extension;
	
	/**
	 * Constructeur par d�faut
	 * @param extension l'extension
	 */
	TypeFichier(String extension) { this.extension = extension; }
	
	@Override
	public String toString() {	return this.extension; }
}
