public class Apartment extends Residential {
    private int rooms = 1;

    public Apartment(String address, double area, double price, int parkingLots, int rooms) {
        super(address, area, price, parkingLots);
        setRooms(rooms);
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        if (rooms <= 1) {
            throw new IllegalArgumentException("Rooms must be greater than 1.");
        }
        this.rooms = rooms;
    }

    @Override
    public void taxIt() {
        System.out.println("Tax to pay: " + (getPrice() * 0.08) + " USD");
    }

    @Override
    public String toString() {
        return super.toString() + ", Rooms: " + rooms;
    }
}
