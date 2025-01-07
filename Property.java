public abstract class Property {

    private String address = "Na, na";
    private double area = 0;
    private double price = 0;

    public Property(String address, double area, double price) {
        setAddress(address);
        setArea(area);
        setPrice(price);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address == null || address.trim().isEmpty() || address.split(" ").length < 2) {
            throw new IllegalArgumentException("Address must not be null, empty, and must contain at least two words.");
        }
        this.address = address;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        if (area < 0) {
            throw new IllegalArgumentException("Area must not be negative.");
        }
        this.area = area;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price must not be negative.");
        }
        this.price = price;
    }

    public abstract void taxIt();

    @Override
    public String toString() {
        return "Address: " + address + ", Area: " + area + " sqm, Price: " + price + " USD";
    }
}
