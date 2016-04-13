package framework.Communication;

import java.rmi.RemoteException;
import java.util.Date;

public class Message extends RemotableObject {

	private static final long serialVersionUID = -2287686573955510539L;

	private String message;
	
	protected Message(String message) throws RemoteException {
		super(new Date());
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}

	

}
