package achala.datamanager.testA.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import achala.datamanager.bdd.DAOTable;
import achala.datamanager.bdd.Insert;
import achala.datamanager.bdd.Requete;
import achala.datamanager.bdd.Select;
import achala.datamanager.bdd.TypeBD;
import achala.datamanager.bdd.Update;
import achala.datamanager.testA.dao.DAOUtilisateur;
import achala.datamanager.testA.dao.ManagerDAO;


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
