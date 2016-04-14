package framework.datamanager.testA.metier;

import framework.datamanager.bdd.DAOTable;

public class Article {

	public int id ;
	public String libelle ;
	public int idediteur;
	
	public Article(int id, String libelle, int idediteur){
		this.id = id;
		this.libelle = libelle;
		this.idediteur = idediteur;
	}
	
	
	
}
