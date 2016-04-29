package achala.datamanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import achala.datamanager.bdd.Requete;

public class Bd extends ZoneStockage {
	
	/** Represente le driver pour se connecter a la BD **/
	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	/** Represente l'url pour la connexion **/
	private String url;
	/** Represente le nom d'utilisateur pour la connexion **/
	private String username;
	/** Represente le mot de passe pour la connexion **/
	private String password;
	/** Represente la connexion **/
	private Connection connexionBD;
	
	/**
	 * Constructeur public
	 * @param driver L'url pour la connexion
	 * @param username Le nom d'utilisateur pour la connexion
	 * @param password Le password pour la connexion
	 * @throws SQLException 
	 */
	public Bd(String url, String username, String password) throws SQLException
	{
		this.url = url;
		this.username = username;
		this.password = password;
		this.connexionBD = DriverManager.getConnection(this.url, this.username, this.password);
	}
	
	/**
	 * Permet d'executer la requete passee en param�tre
	 * @param req Un objet de type requete (Select, Update, Create, Insert, Delete, Drop)
	 * @return Un ResultSet null si vide sinon le resultat
	 */
	public ResultSet request(Requete req) { 
		try {
			ResultSet rs = req.execute(this.connexionBD.createStatement());
			this.connexionBD.commit();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} 
	}

	/**
	 * Permet de recuperer le driver
	 * @return Le driver au format String
	 */
	public String getDriver() {	return driver;	}

	/**
	 * Permet de recuperer le nom d'utilisateur
	 * @return Le nom d'utilisateur au format String
	 */
	public String getUsername() { return this.username;	}
}
