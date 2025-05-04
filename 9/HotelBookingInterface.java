import java.rmi.Remote;
import java.rmi.RemoteException;

public interface HotelBookingInterface extends Remote {
    // Book a room for a guest and return a confirmation message
    String bookRoom(String guestName, int roomNumber) throws RemoteException;

    // Cancel a booking for a guest and return a confirmation message
    String cancelBooking(String guestName, int roomNumber) throws RemoteException;
}