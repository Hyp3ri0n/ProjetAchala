package achala.datamanager;

import achala.datamanager.fichier.TypeFichier;

public class Fichier extends ZoneStockage {
	
	/** Le chemin du fichier à enregistrer **/
	private String path;
	/** Le type de fichier contenant les données **/
	private TypeFichier type;

	/**
	 * Constructeur public
	 * @param path Le chemin du fichier
	 * @param type le type de fichier
	 */
	public Fichier(String path, TypeFichier type) {
		this.path = path;
		this.type = type;
	}
	
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

	/**
	 * Permet de récupérer le type du fichier contenant les données
	 * @return Le type du fichier au format String
	 */
	public TypeFichier getType() { return type; }

	/**
	 * Permet de définir le type du fichier contenant les données
	 * @param path le nouveau type du fichier
	 */
	public void setType(TypeFichier type) { this.type = type; }
	
}
