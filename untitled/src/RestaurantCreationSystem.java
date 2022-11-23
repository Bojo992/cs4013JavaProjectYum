import CLI.CreateRestaurant;
import Restaurant.Restaurant;
import Restaurant.UtilsCSV;
import utils.DataStorage;

import java.io.File;
import java.util.Scanner;

public class RestaurantCreationSystem {
    public static void main(String[] args) {
        new CreateRestaurant(new Scanner(System.in));

        File restCSV = new File("restaurant.csv");
        for (Restaurant restaurant: DataStorage.getAllRestaurants()) {

        }
    }
}
