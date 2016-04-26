package achala.modules.chat.util;

public class Util {

	private Util instance = new Util();
	
	public enum Cmd
	{
		EXIT("/exit"),
		WIZZ("/wizz"),
		IP("/ip"),
		HELP("/help");
		
		private String cmd;
		Cmd(String cmd) { this.cmd = cmd; }
		
		public String toString()
		{
			return this.cmd;
		}
		public static Cmd getCommande(String cmd)
		{
			for(Cmd c : Cmd.values())
			{
				if(c.toString().equals(cmd))
					return c;
			}
			return null;
		}
		
		public static String message(Cmd cmd, String str){
			String strReturn = "";
			
			switch(cmd)
			{
				case EXIT:
					strReturn = str + " a quitter la conversation";
					break;
				case HELP:
					strReturn = "Liste des commandes :\n"
								+ "\t-/exit : quitte le chat\n"
								+ "\t-/ip : obtient l'adresse IP du poste\n"
								+ "\t-/wizz : envoyer un wizz � votre correspondant";
					break;
				case IP:
					strReturn = "Votre adresse IP est " + str;
					break;
				case WIZZ:
					strReturn = str + " vous a envoy� un wizz";
					break;
				default:
					strReturn = "Command not found";
					break;			
			}
			
			return strReturn;
		}
	}
	
	private Util() {}
	
	public Util getInstance()
	{
		return instance;
	}
}
