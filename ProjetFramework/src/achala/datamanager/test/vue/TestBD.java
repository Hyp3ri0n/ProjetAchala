package achala.datamanager.test.vue;

import achala.datamanager.test.metier.ContextApp;
import achala.datamanager.test.metier.Table1;
import achala.datamanager.test.metier.Table2;

public class TestBD {

	public static void main(String[] args) {		
		
		//Création du jeu d'essai
		//Pas obligatoire si déjà créer dans BDD
		Table2.jeuEssai();
		Table1.jeuEssai();
		
		//Création des objets métier
		//Obligatoire car après on ne travaillera qu'avec
		//les objets se trouvant dans cette classe
		ContextApp.Instance().initialisation();
		
		//Encore des tests (non fonctionnel)
		System.out.println(ContextApp.Instance().getListTable1().get(0).selectSomething());
		
	}

}
