package achala.datamanager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import achala.datamanager.exception.DMException;
import achala.datamanager.fichier.TypeFichier;

public class Fichier extends ZoneStockage {
	
	/** Le chemin du fichier � enregistrer **/
	private String path;
	/** Le nom du fichier **/
	private String name;
	/** Le type de fichier contenant les donn�es **/
	private TypeFichier type;
	/** Le contenu du fichier **/
	private String content;

	/**
	 * Constructeur public
	 * @param path Le chemin du fichier � enregister (ex. : "C:\test\")
	 * @param name le nom de fichier
	 * @param type le type de fichier
	 */
	public Fichier(String path, String name, TypeFichier type) {
		this.path = path;
		this.name = name;
		this.type = type;
		this.content = this.getFileContent();
	}
	
	/**
	 * Permet de sauvegarder le fichier courant
	 * @throws DMException
	 */
	public void save() throws DMException {
		
		File file = new File(this.getFullPath());

		try  {

			// if file doesn't exists, then create it
			if (!file.exists()) { file.createNewFile();	}

			FileOutputStream fop = new FileOutputStream(file);
			
			// get the content in bytes
			byte[] contentInBytes = this.content.getBytes();

			fop.write(contentInBytes);
			fop.flush();
			fop.close();

			System.out.println("Done");

		} catch (IOException e) {
			e.printStackTrace();
			throw new DMException("[DM fx001]Erreur lors de la sauvegarde du fichier (" + this.getFullPath() + ").");
		}
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

	/**
	 * Permet de r�cup�rer le contenu du fichier
	 * @return Le Contenu du fichier au format String
	 */
	public String getContent() { return this.content; }

	/**
	 * Permet de d�finir le contenu du fichier
	 * @param content le nouveau contenu du fichier
	 */
	public void setContent(String content) { this.content = content; }

	/**
	 * Permet d'ajouter du contenu du fichier
	 * @param content le contenu � ajouter au fichier
	 */
	public void addContent(String content) { this.content += content; }

	/**
	 * Permet de r�cup�rer le nom du fichier
	 * @return Le nom du fichier au format String
	 */
	public String getName() { return this.name; }

	/**
	 * Permet de d�finir le nom du fichier
	 * @param content le nouveau nom du fichier
	 */
	public void setName(String name) { this.name = name; }
	
	/**
	 * Permet de r�cuperer le chemin complet (chemin + nom + extension)
	 * @return Le chemin complet
	 */
	public String getFullPath() { return this.path + this.name + this.type.toString(); }
	
	/**
	 * Permet de r�cuperer Le contenu du fichier si existant
	 * @return Le contenu du fichier si existant
	 */
	private String getFileContent() { 
		String line = "";
		StringBuffer content = new StringBuffer("");
		
		try
		{
			FileReader file = new FileReader(this.getFullPath());
			BufferedReader br = new BufferedReader(file);
			
			while ((line = br.readLine()) != null) {
				content.append(line);
				System.out.println("line read");
			}
			
			br.close();

		} catch (Exception e) { e.printStackTrace(); } 
		
		return content.toString(); 
	}
}
