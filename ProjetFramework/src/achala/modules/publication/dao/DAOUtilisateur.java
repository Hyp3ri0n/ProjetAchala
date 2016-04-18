package achala.modules.publication.dao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import achala.datamanager.bdd.Create;
import achala.datamanager.bdd.DAOTable;
import achala.datamanager.bdd.Delete;
import achala.datamanager.bdd.Drop;
import achala.datamanager.bdd.Insert;
import achala.datamanager.bdd.Requete;
import achala.datamanager.bdd.Select;
import achala.datamanager.bdd.TypeBD;
import achala.datamanager.bdd.Update;
	

	public class DAOUtilisateur extends DAOTable{
		

		protected DAOUtilisateur(Map<DAOTable, String> jointures) {
			super(jointures);
			// TODO Auto-generated constructor stub
		}
		
		/**Initialisation des attributs avec leurs types */
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

		/**Creation de la table */
		@Override
		protected Requete createTable() {
			return new Create("CREATE TABLE Utilisateur ("
								+ "id INTEGER PRIMARY KEY,"
								+ "nom VARCHAR2(25) NOT NULL,"
								+ "prenom VARCHAR2(25) NOT NULL,"
								+ "adresse VARCHAR2(50) NOT NULL,"
								+ "poste VARCHAR2(50) NOT NULL,"
							+ ")");
		}

		/**
		 * Permet d'inserer une ligne dans la table "Utilisateur"
		 * @param id Le premier attribut
		 * @param nom Le second attribut
		 * @param prenom Le troisieme attribut
		 * @param adresse Le quatrieme attribut
		 * @param poste Le cinquieme attribut
		 * @return La requete a executer (objet)
		 */
		public Requete insert(int id, String nom, String prenom, String adresse, String poste) {		
			HashMap<String, String> lstAttrsValue = new HashMap<>();
			lstAttrsValue.put("id", ""+id);
			lstAttrsValue.put("nom", nom);
			lstAttrsValue.put("prenom", prenom);
			lstAttrsValue.put("adresse", adresse);
			lstAttrsValue.put("poste", poste);
			
			return new Insert(lstAttrsValue, ManagerDAO.getDAOUtilisateur());
		}
		
		
		
		public Requete selectAll() {
			List<DAOTable> lstTables = new ArrayList<>();
			lstTables.add(ManagerDAO.getDAOUtilisateur());
			
			List<String> lstAttrs = new ArrayList<>();
			lstAttrs.add("*");
			
			return new Select(lstAttrs, lstTables);
		}
		
		
		/**
		 * Permet de modifier une ou plusieurs lignes dans la table "Utilisateur"
		 * @param lstAttrsValues La liste des attributs et leurs valeurs pour modification
		 * @param where La clause WHERE de la requete
		 * @return La requete a executer (objet)
		 */
		public Requete update(HashMap<String, String> lstAttrsValues, String where) {		
			return new Update(lstAttrsValues, ManagerDAO.getDAOUtilisateur(), where);
		}
		
		/**
		 * Permet de supprimer une ligne de la table
		 * @param where La clause Where
		 * @return La requete a executer (objet)
		 */
		public Requete delete(String where) {		
			return new Delete(ManagerDAO.getDAOUtilisateur(), where);
		}

		/**
		 * Permet de supprimer la table en base
		 * @return La requete a executer (objet)
		 */
		public Requete drop() {		
			return new Drop(ManagerDAO.getDAOUtilisateur());
		}
		
		
		
		/** 
		*Faire une requete 
		*Select nom prenom et titre
		*from Article join Utilisateur on (id=idediteur)
		*where utilisateur.id = 1
		*/
		
		public Requete selectSomething() {
			List<DAOTable> lstTables = new ArrayList<>();
			lstTables.add(ManagerDAO.getDAOUtilisateur());
			lstTables.add(ManagerDAO.getDAOArticle());
			
			List<String> lstAttrs = new ArrayList<>();
			lstAttrs.add("Utilisateur.nom");
			lstAttrs.add("Utilisateur.prenom");
			lstAttrs.add("Article.titre");
			
			return new Select(lstAttrs, lstTables, "WHERE Utilisateur.id = 1");
		}
		

	}


