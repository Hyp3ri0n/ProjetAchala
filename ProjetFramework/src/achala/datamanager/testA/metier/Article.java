package achala.datamanager.testA.metier;

import achala.datamanager.bdd.DAOTable;

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
