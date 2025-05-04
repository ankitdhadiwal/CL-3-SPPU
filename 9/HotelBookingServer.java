import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class HotelBookingServer {
    public static void main(String[] args) {
        try {
            // Start the RMI registry on port 1099 if it's not running externally
            LocateRegistry.getRegistry();
            System.out.println("RMI registry started on port 1099.");

            // Create the remote object
            HotelBookingInterface bookingService = new HotelBookingImpl();

            // Bind the remote object to the registry with a name
            Naming.rebind("HotelBookingService", bookingService);
            System.out.println("Hotel Booking Service is ready.");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}