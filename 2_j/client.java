import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class client {
    public static void main(String[] args) {
        try {
            // Connect to the RMI registry on localhost
            Registry registry = LocateRegistry.getRegistry("localhost");

            // Look up the remote object
            ConcatInterface stub = (ConcatInterface) registry.lookup("ConcatService");

            // Input strings (can be from scanner in real use)
            String s1 = "Hello, ";
            String s2 = "World!";

            // Call the remote method
            String result = stub.concatenate(s1, s2);

            System.out.println("Concatenated String: " + result);
        } catch (Exception e) {
            System.out.println("Client exception: " + e);
        }
    }
}
