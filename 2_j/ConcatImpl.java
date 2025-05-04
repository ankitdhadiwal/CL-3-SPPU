import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class ConcatImpl extends UnicastRemoteObject implements ConcatInterface {
    protected ConcatImpl() throws RemoteException {
        super();
    }

    public String concatenate(String s1, String s2) throws RemoteException {
        return s1 + s2;
    }
}
