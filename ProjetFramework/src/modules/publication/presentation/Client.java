package modules.publication.presentation;

import modules.publication.metier.*;

public class Client {

	private Client() {}

	public static void main(String[] args) {
		ManagerApp.Instance().initialisation();
		for(Article art:ManagerApp.Instance().getListArticles()) {
			System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
			System.out.println("");
			System.out.println("* "+art.toString());
			System.out.println("");
			System.out.println("Commentaires : ");
			if(!art.getLesCommentaires().isEmpty()) {	
				for(Commentaire com:art.getLesCommentaires()) {
					System.out.println("");
					System.out.println("- "+com.toString());
				}
			} else {
				System.out.println("Aucun");
			}
			System.out.println("");
		}
	}

}
