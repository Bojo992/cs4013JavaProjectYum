import CLI.CreateRestaurant;
import utils.UtilsCSV;
import utils.DataStorage;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RestaurantCreationSystem {
    public static void main(String[] args) throws FileNotFoundException {
        DataStorage.setAllRestaurants(new UtilsCSV().readRestaurants());

        new CreateRestaurant(new Scanner(System.in)).run();

        new UtilsCSV().writeRestaurants(DataStorage.getAllRestaurants());
    }
}
