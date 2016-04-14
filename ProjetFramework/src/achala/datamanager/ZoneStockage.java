package achala.datamanager;

public abstract class ZoneStockage {
	
	/** L'adresse IP du server contenant les données **/
	private String adresseIP;
	/** Le port du server contenant les données **/
	private int port;
	
	/**
	 * Permet de récupérer l'adresse IP du serveur contenant les données
	 * @return L'adresse IP au format String
	 */
	public String getAdresseIP() { return this.adresseIP; }
	
	/**
	 * Permet de définir l'adresse IP du serveur contenant les données
	 * @param adresseIP La nouvelle adresse IP
	 */
	public void setAdresseIP(String adresseIP) { this.adresseIP = adresseIP; }
	
	/**
	 * Permet de récupérer le port du serveur contenant les données
	 * @return Le port au format int
	 */
	public int getPort() { return this.port; }
	
	/**
	 * Permet de définir le port du serveur contenant les données
	 * @param port Le nouveau port
	 */
	public void setPort(int port) {	this.port = port; }
}
