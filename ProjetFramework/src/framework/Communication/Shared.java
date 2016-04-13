package framework.Communication;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;
import java.util.List;

public abstract class Shared extends UnicastRemoteObject implements _Shared {

	private static final long serialVersionUID = 5253539907891735969L;

	protected List<_RemotableObject> RObjectList;
	
	protected Shared() throws RemoteException {
		super();
		this.RObjectList = new LinkedList<>();
	}
	
	public List<_RemotableObject> getObjects() {
		return this.RObjectList;
	}

}
