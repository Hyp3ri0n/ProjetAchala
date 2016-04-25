package achala.modules.publication.presentation;

import achala.modules.publication.metier.ManagerApp;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ManagerApp.Instance().initialisation();
		System.out.println(ManagerApp.Instance().getListCommentaires().get(0).getDate().toString());
	}

}
