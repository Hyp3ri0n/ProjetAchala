package framework.Communication;

import java.io.File;
import java.rmi.RemoteException;
import java.util.Date;

import framework.Communication.Utilisateur.Utilisateur;

public class Fichier extends RemotableObject {

	private static final long serialVersionUID = -4565122649490152817L;

	private File fichier;
	
	protected Fichier(Utilisateur sender, File fichier) throws RemoteException {
		super(sender, new Date());
		this.setFichier(fichier);
	}

	public File getFichier() {
		return this.fichier;
	}
	
	public void setFichier(File fichier) {
		this.fichier = fichier;
	}

}
