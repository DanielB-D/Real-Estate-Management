public class Plot extends Property {
    public enum Type {
        URBAN, AGRICULTURAL, INDUSTRIAL
    }

    private Type type;

    public Plot(String address, double area, double price, Type type) {
        super(address, area, price);
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public void taxIt() {
        double taxRate = switch (type) {
            case URBAN -> 0.1;
            case AGRICULTURAL -> 0.02;
            case INDUSTRIAL -> 0.05;
        };
        System.out.println("Tax to pay: " + (getPrice() * taxRate) + " USD");
    }

    @Override
    public String toString() {
        return super.toString() + ", Type: " + type;
    }
}
