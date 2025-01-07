public class Office extends Property {
    public Office(String address, double area, double price) {
        super(address, area, price);
    }

    @Override
    public void taxIt() {
        System.out.println("Tax to pay: " + (getPrice() * 0.05) + " USD");
    }
}