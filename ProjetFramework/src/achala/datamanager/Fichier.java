package achala.datamanager;

import achala.datamanager.fichier.TypeFichier;

public class Fichier extends ZoneStockage {
	
	/** Le chemin du fichier � enregistrer **/
	private String path;
	/** Le type de fichier contenant les donn�es **/
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
	 * Permet de r�cup�rer le chemin du fichier contenant les donn�es
	 * @return Le chemin du fichier au format String
	 */
	public String getPath() { return this.path;	}

	/**
	 * Permet de d�finir le chemin du fichier contenant les donn�es
	 * @param path le nouveau chemin du fichier
	 */
	public void setPath(String path) { this.path = path; }

	/**
	 * Permet de r�cup�rer le type du fichier contenant les donn�es
	 * @return Le type du fichier au format String
	 */
	public TypeFichier getType() { return type; }

	/**
	 * Permet de d�finir le type du fichier contenant les donn�es
	 * @param path le nouveau type du fichier
	 */
	public void setType(TypeFichier type) { this.type = type; }
	
}
