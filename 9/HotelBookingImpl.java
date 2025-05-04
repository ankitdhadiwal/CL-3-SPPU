import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class HotelBookingImpl extends UnicastRemoteObject implements HotelBookingInterface {
    // Map to hold booking information: key = roomNumber, value = guestName
    private Map<Integer, String> bookings;

    protected HotelBookingImpl() throws RemoteException {
        super();
        bookings = new HashMap<>();
    }

    @Override
    public synchronized String bookRoom(String guestName, int roomNumber) throws RemoteException {
        if (bookings.containsKey(roomNumber)) {
            return "Room " + roomNumber + " is already booked by " + bookings.get(roomNumber);
        }
        bookings.put(roomNumber, guestName);
        return "Room " + roomNumber + " successfully booked for " + guestName;
    }

    @Override
    public synchronized String cancelBooking(String guestName, int roomNumber) throws RemoteException {
        if (!bookings.containsKey(roomNumber)) {
            return "Room " + roomNumber + " is not currently booked.";
        }
        if (!bookings.get(roomNumber).equals(guestName)) {
            return "Booking cancellation failed: Room " + roomNumber + " is booked by " + bookings.get(roomNumber);
        }
        bookings.remove(roomNumber);
        return "Booking for room " + roomNumber + " cancelled for " + guestName;
    }
}