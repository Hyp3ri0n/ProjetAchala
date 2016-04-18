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
	
	/** Le chemin du fichier à enregistrer **/
	private String path;
	/** Le nom du fichier **/
	private String name;
	/** Le type de fichier contenant les données **/
	private TypeFichier type;
	/** Le contenu du fichier **/
	private String content;

	/**
	 * Constructeur public
	 * @param path Le chemin du fichier à enregister (ex. : "C:\test\")
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

	/**
	 * Permet de récupérer le contenu du fichier
	 * @return Le Contenu du fichier au format String
	 */
	public String getContent() { return this.content; }

	/**
	 * Permet de définir le contenu du fichier
	 * @param content le nouveau contenu du fichier
	 */
	public void setContent(String content) { this.content = content; }

	/**
	 * Permet d'ajouter du contenu du fichier
	 * @param content le contenu à ajouter au fichier
	 */
	public void addContent(String content) { this.content += content; }

	/**
	 * Permet de récupérer le nom du fichier
	 * @return Le nom du fichier au format String
	 */
	public String getName() { return this.name; }

	/**
	 * Permet de définir le nom du fichier
	 * @param content le nouveau nom du fichier
	 */
	public void setName(String name) { this.name = name; }
	
	/**
	 * Permet de récuperer le chemin complet (chemin + nom + extension)
	 * @return Le chemin complet
	 */
	public String getFullPath() { return this.path + this.name + this.type.toString(); }
	
	/**
	 * Permet de récuperer Le contenu du fichier si existant
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
