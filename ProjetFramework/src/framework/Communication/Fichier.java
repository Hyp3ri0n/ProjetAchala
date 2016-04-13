package framework.Communication;

import java.io.File;
import java.rmi.RemoteException;
import java.util.Date;

public class Fichier extends RemotableObject {

	private static final long serialVersionUID = -4565122649490152817L;

	private File fichier;
	
	protected Fichier(File fichier) throws RemoteException {
		super(new Date());
		this.setFichier(fichier);
	}

	public File getFichier() {
		return this.fichier;
	}
	
	private void setFichier(File fichier) {
		this.fichier = fichier;
	}

}
