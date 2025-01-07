public class Vacation extends Residential {
    private int guests = 1;

    public Vacation(String address, double area, double price, int parkingLots, int guests) {
        super(address, area, price, parkingLots);
        setGuests(guests);
    }

    public int getGuests() {
        return guests;
    }

    public void setGuests(int guests) {
        if (guests < 1) {
            throw new IllegalArgumentException("Guests must be at least 1.");
        }
        this.guests = guests;
    }

    @Override
    public void taxIt() {
        System.out.println("Tax to pay: " + (getPrice() * 0.25) + " USD");
    }

    @Override
    public String toString() {
        return super.toString() + ", Guests: " + guests;
    }
}