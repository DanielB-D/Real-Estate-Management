import java.util.ArrayList;
import java.util.List;

public class RealEstateManager {
    private String name;
    private List<Property> properties = new ArrayList<>();

    public RealEstateManager(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public void addProperty(Property property) {
        properties.add(property);
    }

    public List<Property> getPropertiesBelowPrice(double maxPrice) {
        List<Property> result = new ArrayList<>();
        for (Property property : properties) {
            if (property.getPrice() <= maxPrice) {
                result.add(property);
            }
        }
        return result;
    }

    public double getTotalPropertyValue() {
        double total = 0;
        for (Property property : properties) {
            total += property.getPrice();
        }
        return total;
    }
}