package achala.communication;

import java.io.File;
import java.rmi.RemoteException;
import java.util.Date;

import achala.communication.utilisateur._Utilisateur;

public class Fichier extends RemotableObject {

	private static final long serialVersionUID = -4565122649490152817L;

	private File fichier;

	protected Fichier(_Utilisateur sender, File fichier) throws RemoteException {
		super(sender, new Date());
		this.setFichier(fichier);
	}

	/**
	 * Recupere le fichier envoye
	 * 
	 * @return Fil : fichier envoye
	 */
	public File getFichier() {
		return this.fichier;
	}

	/**
	 * Affecte le fichier a envoyer
	 * 
	 * @param fichier
	 *            File : fichier a envoyer
	 */
	public void setFichier(File fichier) {
		this.fichier = fichier;
	}

	@Override
	public Object getObject() throws RemoteException {
		return this.getFichier();
	}

}
