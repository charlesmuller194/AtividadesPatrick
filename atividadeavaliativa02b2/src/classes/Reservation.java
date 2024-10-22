package classes;

public class Reservation {
    public Guest guest;
    public String checkInDate;
    public String checkOutDate;
    public int numRoomsReserved;
    public String roomTypeReserved;

    public Reservation(Guest guest, String checkInDate, String checkOutDate, int numRoomsReserved, String roomTypeReserved) {
        this.guest = guest;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.numRoomsReserved = numRoomsReserved;
        this.roomTypeReserved = roomTypeReserved;
    }
}
