package framework.Communication;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

public abstract class RemotableObject extends UnicastRemoteObject implements _RemotableObject {

	private static final long serialVersionUID = 655492702812581170L;

	private Date date;
	
	protected RemotableObject(Date date) throws RemoteException {
		super();
		this.date = date;
	}
	
	@Override
	public Date getDate() {
		// TODO Auto-generated method stub
		return this.date;
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub

	}

	@Override
	public void send(_Shared shared) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public String receive(_Shared shared) {
		// TODO Auto-generated method stub
		return null;
	}

}
