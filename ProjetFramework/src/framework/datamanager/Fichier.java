package framework.datamanager;

public class Fichier extends ZoneStockage {
	
	/** Le chemin du fichier contenant les données **/
	private String path;

	/**
	 * Permet de récupérer le chemin du fichier contenant les données
	 * @return Le chemin du fichier au format String
	 */
	public String getPath() { return this.path;	}

	/**
	 * Permet de définir le chemin du fichier contenant les données
	 * @param path le nouveau chemin du fichier
	 */
	public void setPath(String path) { this.path = path; }
}
