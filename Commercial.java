public class Commercial extends Property {
    private boolean storeroom = false;
    private double yield = 0.0;

    public Commercial(String address, double area, double price, double yield) {
        super(address, area, price);
        setYield(yield);
    }

    public Commercial(String address, double area, double price, double yield, boolean storeroom) {
        this(address, area, price, yield);
        this.storeroom = storeroom;
    }

    public boolean hasStoreroom() {
        return storeroom;
    }

    public void setStoreroom(boolean storeroom) {
        this.storeroom = storeroom;
    }

    public double getYield() {
        return yield;
    }

    public void setYield(double yield) {
        if (yield < 0) {
            throw new IllegalArgumentException("Yield must not be negative.");
        }
        this.yield = yield;
    }

    public double calculateMonthlyProfit() {
        return (getPrice() * (yield / 100)) / 12;
    }

    @Override
    public void taxIt() {
        System.out.println("Tax to pay: " + (getPrice() * 0.05) + " USD");
    }

    @Override
    public String toString() {
        return super.toString() + ", Storeroom: " + storeroom + ", Yield: " + yield + "%";
    }
}
