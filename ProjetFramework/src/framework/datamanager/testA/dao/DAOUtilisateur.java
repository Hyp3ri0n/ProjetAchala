package framework.datamanager.testA.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import framework.datamanager.bdd.DAOTable;
import framework.datamanager.bdd.Insert;
import framework.datamanager.bdd.Requete;
import framework.datamanager.bdd.Select;
import framework.datamanager.bdd.TypeBD;
import framework.datamanager.testA.dao.ManagerDAO;

public class DAOUtilisateur extends DAOTable{
	

	protected DAOUtilisateur(Map<DAOTable, String> jointures) {
		super(jointures);
		// TODO Auto-generated constructor stub
	}
	@Override
		public void initialisation() {
			
			this.setNomTable("Utilisateur");
			
			Map<String, TypeBD> lstAttrs = new HashMap<>();
			lstAttrs.put("Utilisateur.id", TypeBD.STRING);
			lstAttrs.put("Utilisateur.nom", TypeBD.STRING);
			lstAttrs.put("Utilisateur.prenom", TypeBD.STRING);
			lstAttrs.put("Utilisateur.adresse", TypeBD.STRING);
			lstAttrs.put("Utilisateur.poste", TypeBD.STRING);
			
			this.setAttributs(lstAttrs);
		}

		public Requete selectSomething() {
			List<DAOTable> lstTables = new ArrayList<>();
			lstTables.add(ManagerDAO.getDAOUtilisateur());
			lstTables.add(ManagerDAO.getDAOArticle());
			
			List<String> lstAttrs = new ArrayList<>();
			lstAttrs.add("Utilisateur.nom");
			lstAttrs.add("Utilisateur.prenom");
			
			return new Select(lstAttrs, lstTables, "WHERE Utilisateur.id = 1");
		}
		
		public Requete insertSomething(int id, String nom,String prenom) {		
			
			HashMap<String, String> lstAttrsValue = new HashMap<>();
			lstAttrsValue.put("Utilisateur.id", id+"");
			lstAttrsValue.put("Utilisateur.nom",nom);
			lstAttrsValue.put("Utilisateur.prenom",prenom);
			
			return new Insert(lstAttrsValue, ManagerDAO.getDAOUtilisateur());
		}
		

}
