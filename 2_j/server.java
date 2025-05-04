import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class server {
    public static void main(String[] args) {
        try {
            // Create and export remote object
            ConcatImpl obj = new ConcatImpl();

            // Start the RMI registry on port 1099
            Registry registry = LocateRegistry.getRegistry();

            // Bind the object to the name "ConcatService"
            registry.rebind("ConcatService", obj);

            System.out.println("Server is ready.");
        } catch (Exception e) {
            System.out.println("Server exception: " + e);
        }
    }
}
