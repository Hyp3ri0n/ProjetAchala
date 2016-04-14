package achala.communication;

import java.io.File;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;
import java.util.List;

public abstract class Shared extends UnicastRemoteObject implements _Shared {

	private static final long serialVersionUID = 5253539907891735969L;

	private String rmiAdresse;
	protected List<_RemotableObject> RObjectList;
	protected boolean wait;
	
	protected Shared(String rmiAdresse) throws RemoteException {
		super();
		this.RObjectList = new LinkedList<>();
		this.setRmiAdresse(rmiAdresse);
	}
	
	public List<_RemotableObject> getObjects() throws RemoteException{
		return this.RObjectList;
	}
	
	public String getRmiAdresse() {
		return this.rmiAdresse;
	}

	public void setRmiAdresse(String rmiAdresse) {
		this.rmiAdresse = rmiAdresse;
	}

	public void save(File fichier) {
		// TODO
	}
	
	public void setWait(boolean wait) throws RemoteException {
		this.wait = wait;
	}
	
	public boolean isWait() throws RemoteException {
		for(_RemotableObject o : this.getObjects()){
			if(o.isWait()) {
				this.setWait(true);
				break;
			}
		}
		return this.wait;
	}

}
