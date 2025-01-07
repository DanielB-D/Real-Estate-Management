import java.util.ArrayList;
import java.util.List;

public class DataManager {
    public static List<Property> getSampleProperties() {
        List<Property> properties = new ArrayList<>();

        // Add Plots
        properties.add(new Plot("Tel Aviv, Frishman 12", 500, 1000000, Plot.Type.URBAN));
        properties.add(new Plot("Kfar Saba, Weitzman 18", 1000, 800000, Plot.Type.AGRICULTURAL));

        // Add Apartments
        properties.add(new Apartment("Ramat Gan, Bialik 23", 120, 1200000, 2, 4));
        properties.add(new Apartment("Herzliya, Ben Gurion 5", 150, 1500000, 3, 5));

        // Add Villas
        properties.add(new Villa("Netanya, HaShalom 10", 300, 2500000, 2, 2));
        properties.add(new Villa("Ra'anana, HaTe'ena 7", 400, 3000000, 3, 3));

        // Add Vacation Properties
        properties.add(new Vacation("Eilat, HaYam 3", 200, 2000000, 1, 10));
        properties.add(new Vacation("Tiberias, HaGalil 1", 180, 1800000, 2, 8));

        // Add Commercial Properties
        properties.add(new Commercial("Petah Tikva, HaHistadrut 12", 600, 5000000, 8.0, true));
        properties.add(new Commercial("Ashdod, HaNegev 8", 700, 4000000, 6.5, false));

        // Add Offices
        properties.add(new Office("Jerusalem, King George 15", 250, 1200000));
        properties.add(new Office("Haifa, HaCarmel 20", 300, 1000000));

        return properties;
    }
}