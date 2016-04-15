package achala.datamanager.fichier;

public enum TypeFichier {
	XML("xml"),
	TEXT("txt"),
	SQL("sql");
	
	/** Représente l'extension **/
	String extension;
	
	/**
	 * Constructeur par défaut
	 * @param extension l'extension
	 */
	TypeFichier(String extension) { this.extension = extension; }
	
	@Override
	public String toString() {	return this.extension; }
}
