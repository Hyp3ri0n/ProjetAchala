package framework.datamanager;

public class Fichier extends ZoneStockage {
	
	/** Le chemin du fichier contenant les donn�es **/
	private String path;

	/**
	 * Permet de r�cup�rer le chemin du fichier contenant les donn�es
	 * @return Le chemin du fichier au format String
	 */
	public String getPath() { return this.path;	}

	/**
	 * Permet de d�finir le chemin du fichier contenant les donn�es
	 * @param path le nouveau chemin du fichier
	 */
	public void setPath(String path) { this.path = path; }
}
