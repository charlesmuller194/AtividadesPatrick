package classes;

public class Room {
    public int number;
    public String type; // "solteiro", "casal", "suite"
    public double dailyPrice;
    public boolean available;

    public Room(int number, String type, double dailyPrice, boolean available) {
        this.number = number;
        this.type = type;
        this.dailyPrice = dailyPrice;
        this.available = available;
    }
}

