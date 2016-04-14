package framework.datamanager.testA.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import framework.datamanager.testA.dao.ManagerDAO;
import framework.datamanager.bdd.DAOTable;
import framework.datamanager.bdd.Insert;
import framework.datamanager.bdd.Requete;
import framework.datamanager.bdd.Select;
import framework.datamanager.bdd.TypeBD;
import framework.datamanager.bdd.Update;
import framework.datamanager.testA.dao.DAOUtilisateur;


public class DAOArticle extends DAOTable {

	protected DAOArticle(Map<DAOTable, String> jointures) {
		super(jointures);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void initialisation() {
		
		this.setNomTable("Article");
		
		Map<String, TypeBD> lstAttrs = new HashMap<>();
		lstAttrs.put("Article.id", TypeBD.STRING);
		lstAttrs.put("Article.libelle", TypeBD.STRING);
		lstAttrs.put("Article.idediteur", TypeBD.STRING);
		
		this.setAttributs(lstAttrs);
	}
	
	
	public Requete updateSomething() {		
		HashMap<String, String> lstAttrsValue = new HashMap<>();
		lstAttrsValue.put("Utilisateur.id", "1");
		
		return new Update(lstAttrsValue, ManagerDAO.getDAOUtilisateur(), "WHERE Utilisateur.id = 1");
	}
	
	


}
