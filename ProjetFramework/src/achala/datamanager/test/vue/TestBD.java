package achala.datamanager.test.vue;

import achala.datamanager.test.metier.ContextApp;
import achala.datamanager.test.metier.Table1;
import achala.datamanager.test.metier.Table2;

public class TestBD {

	public static void main(String[] args) {		
		
		//Cr�ation du jeu d'essai
		//Pas obligatoire si d�j� cr�er dans BDD
		Table2.jeuEssai();
		Table1.jeuEssai();
		
		//Cr�ation des objets m�tier
		//Obligatoire car apr�s on ne travaillera qu'avec
		//les objets se trouvant dans cette classe
		ContextApp.Instance().initialisation();
		
		//Encore des tests (non fonctionnel)
		System.out.println(ContextApp.Instance().getListTable1().get(0).selectSomething());
		
	}

}
