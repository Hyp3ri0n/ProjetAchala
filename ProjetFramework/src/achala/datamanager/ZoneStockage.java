package achala.datamanager;

public abstract class ZoneStockage {
	
	/** L'adresse IP du server contenant les donn�es **/
	private String adresseIP;
	/** Le port du server contenant les donn�es **/
	private int port;
	
	/**
	 * Permet de r�cup�rer l'adresse IP du serveur contenant les donn�es
	 * @return L'adresse IP au format String
	 */
	public String getAdresseIP() { return this.adresseIP; }
	
	/**
	 * Permet de d�finir l'adresse IP du serveur contenant les donn�es
	 * @param adresseIP La nouvelle adresse IP
	 */
	public void setAdresseIP(String adresseIP) { this.adresseIP = adresseIP; }
	
	/**
	 * Permet de r�cup�rer le port du serveur contenant les donn�es
	 * @return Le port au format int
	 */
	public int getPort() { return this.port; }
	
	/**
	 * Permet de d�finir le port du serveur contenant les donn�es
	 * @param port Le nouveau port
	 */
	public void setPort(int port) {	this.port = port; }
}
