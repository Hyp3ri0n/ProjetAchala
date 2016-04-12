package framework.datamanager;

import java.sql.Connection;
import java.sql.ResultSet;

import framework.datamanager.request.Requete;

public class Bd extends ZoneStockage {
	
	/** Repr�sente le driver pour se connecter � la BD **/
	private String driver;
	/** Repr�sente le nom d'utilisateur pour la connexion **/
	private String username;
	/** Repr�sente le mot de passe pour la connexion **/
	private String password;
	/** Repr�sente la connexion **/
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
	 * Permet d'executer la requete pass�e en param�tre
	 * @param req Un objet de type requete (Select, Update, Create, Insert, Delete, Drop)
	 * @return Un ResultSet null si vide sinon le r�sultat
	 */
	public ResultSet request(Requete req) { return req.execute(this.connexionBD); }

	/**
	 * Permet de r�cup�rer le driver
	 * @return Le driver au format String
	 */
	public String getDriver() {	return this.driver;	}

	/**
	 * Permet de r�cup�rer le nom d'utilisateur
	 * @return Le nom d'utilisateur au format String
	 */
	public String getUsername() { return this.username;	}
}
