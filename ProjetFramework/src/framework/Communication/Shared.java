package framework.Communication;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;
import java.util.List;

public abstract class Shared extends UnicastRemoteObject implements _Shared {

	private static final long serialVersionUID = 5253539907891735969L;

	protected List<_RemotableObject> RObjectList;
	protected boolean wait;
	
	protected Shared() throws RemoteException {
		super();
		this.RObjectList = new LinkedList<>();
	}
	
	public List<_RemotableObject> getObjects() throws RemoteException{
		return this.RObjectList;
	}
	
	public void save() {
		// TODO Auto-generated method stub
		
	}
	
	public void setWait(boolean wait) {
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
