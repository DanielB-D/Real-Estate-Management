public abstract class Residential extends Property {
    private int parkingLots = 0;

    public Residential(String address, double area, double price, int parkingLots) {
        super(address, area, price);
        setParkingLots(parkingLots);
    }

    public int getParkingLots() {
        return parkingLots;
    }

    public void setParkingLots(int parkingLots) {
        if (parkingLots < 0) {
            throw new IllegalArgumentException("Parking lots must not be negative.");
        }
        this.parkingLots = parkingLots;
    }
}
