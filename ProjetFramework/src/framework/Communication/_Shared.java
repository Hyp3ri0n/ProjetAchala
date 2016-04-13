package framework.Communication;

import java.rmi.Remote;
import java.util.List;

public interface _Shared extends Remote {

	List<_RemotableObject> getObjects();
	
	void send(_RemotableObject object);
}
