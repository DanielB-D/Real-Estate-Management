import java.util.*;

public class Main {

    // Global variable for the RealEstateManager
    private static RealEstateManager realEstateManager = new RealEstateManager("Global Real Estate Manager");

    public static void main(String[] args) {
        // Load properties from DataManager
        realEstateManager.getProperties().addAll(DataManager.getSampleProperties());

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1 > Search Properties");
            System.out.println("2 > Financial Report");
            System.out.println("3 > Commercial Yield");
            System.out.println("4 > Properties by City");
            System.out.println("5 > Number of Cities");
            System.out.println("-1 > Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    propertiesList(scanner);
                    break;
                case 2:
                    financialReport();
                    break;
                case 3:
                    commercialYield();
                    break;
                case 4:
                    propertiesByCity(scanner);
                    break;
                case 5:
                    numberOfCities();
                    break;
                case -1:
                    System.out.println("Exiting program. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // 10. Search Properties
    private static void propertiesList(Scanner scanner) {
        try {
            System.out.print("Enter maximum price: ");
            double maxPrice = scanner.nextDouble();
            if (maxPrice < 0) throw new PriceException("Price cannot be negative.");

            List<Property> properties = realEstateManager.getPropertiesBelowPrice(maxPrice);
            if (properties.isEmpty()) {
                System.out.println("No properties found below the given price.");
            } else {
                properties.forEach(System.out::println);
            }
        } catch (PriceException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // 11. Financial Report
    private static void financialReport() {
        System.out.println("Financial Report:");
        for (Property property : realEstateManager.getProperties()) {
            System.out.print(property + " -> ");
            property.taxIt();
        }
    }

    // 12. Commercial Yield
    private static void commercialYield() {
        double totalYield = 0;
        for (Property property : realEstateManager.getProperties()) {
            if (property instanceof Commercial commercial) {
                totalYield += commercial.calculateMonthlyProfit();
            }
        }
        System.out.println("Total Monthly Yield from Commercial Properties: " + totalYield + " USD");
    }

    // 13. Properties by City
    private static void propertiesByCity(Scanner scanner) {
        System.out.print("Enter city name: ");
        String cityInput = scanner.nextLine().toLowerCase().replace("-", "");

        System.out.println("Properties in " + cityInput + ":");
        boolean found = false;
        for (Property property : realEstateManager.getProperties()) {
            String city = property.getAddress().split(",")[0].toLowerCase().replace("-", "");
            if (city.equals(cityInput)) {
                System.out.println(property);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No properties found in the specified city.");
        }
    }

    // 14. Number of Cities
    private static void numberOfCities() {
        Set<String> cities = new HashSet<>();
        for (Property property : realEstateManager.getProperties()) {
            String city = property.getAddress().split(",")[0].toLowerCase().replace("-", "");
            cities.add(city);
        }
        System.out.println("Number of distinct cities: " + cities.size());
        System.out.println("Cities: " + cities);
    }

    // Exception class for negative price
    static class PriceException extends Exception {
        public PriceException(String message) {
            super(message);
        }
    }
}