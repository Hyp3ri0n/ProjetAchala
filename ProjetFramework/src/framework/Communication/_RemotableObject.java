package framework.Communication;

import java.rmi.Remote;
import java.util.Date;

public interface _RemotableObject extends Remote {

	Date getDate();
	void save();
	void send(_Shared shared);
	String receive(_Shared shared);
}
