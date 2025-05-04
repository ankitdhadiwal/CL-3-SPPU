import java.rmi.Naming;
import java.util.Scanner;

public class HotelBookingClient {
    public static void main(String[] args) {
        try {
            // Lookup the remote hotel booking service using the registry URL.
            HotelBookingInterface bookingService = (HotelBookingInterface) Naming.lookup("//localhost/HotelBookingService");
            System.out.println("Connected to Hotel Booking Service.");

            Scanner scanner = new Scanner(System.in);
            while (true) {
                // Display a menu for user operations
                System.out.println("\nSelect an option:");
                System.out.println("1. Book Room");
                System.out.println("2. Cancel Booking");
                System.out.println("3. Exit");
                System.out.print("Choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                if (choice == 1) {
                    // Book a room: get guest name and room number
                    System.out.print("Enter guest name: ");
                    String guestName = scanner.nextLine();
                    System.out.print("Enter room number: ");
                    int roomNumber = scanner.nextInt();
                    scanner.nextLine();  // Consume newline

                    String response = bookingService.bookRoom(guestName, roomNumber);
                    System.out.println(response);
                } else if (choice == 2) {
                    // Cancel booking: get guest name and room number
                    System.out.print("Enter guest name: ");
                    String guestName = scanner.nextLine();
                    System.out.print("Enter room number: ");
                    int roomNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    String response = bookingService.cancelBooking(guestName, roomNumber);
                    System.out.println(response);
                } else if (choice == 3) {
                    System.out.println("Exiting...");
                    break;
                } else {
                    System.out.println("Invalid option. Please try again.");
                }
            }
            scanner.close();
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}