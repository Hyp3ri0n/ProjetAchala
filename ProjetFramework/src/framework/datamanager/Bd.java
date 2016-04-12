package framework.datamanager;

import java.sql.Connection;
import java.sql.ResultSet;

import framework.datamanager.request.Requete;

public class Bd extends ZoneStockage {
	
	/** Représente le driver pour se connecter à la BD **/
	private String driver;
	/** Représente le nom d'utilisateur pour la connexion **/
	private String username;
	/** Représente le mot de passe pour la connexion **/
	private String password;
	/** Représente la connexion **/
	private Connection connexionBD;
	
	/**
	 * Constructeur public
	 * @param driver Le driver pour la connexion
	 * @param username Le nom d'utilisateur pour la connexion
	 * @param password Le password pour la connexion
	 */
	public Bd(String driver, String username, String password)
	{
		this.driver = driver;
		this.username = username;
		this.password = password;
		//this.connexionBD = new 
	}
	
	/**
	 * Permet d'executer la requete passée en paramètre
	 * @param req Un objet de type requete (Select, Update, Create, Insert, Delete, Drop)
	 * @return Un ResultSet null si vide sinon le résultat
	 */
	public ResultSet request(Requete req) { return req.execute(this.connexionBD); }

	/**
	 * Permet de récupérer le driver
	 * @return Le driver au format String
	 */
	public String getDriver() {	return this.driver;	}

	/**
	 * Permet de récupérer le nom d'utilisateur
	 * @return Le nom d'utilisateur au format String
	 */
	public String getUsername() { return this.username;	}
}
