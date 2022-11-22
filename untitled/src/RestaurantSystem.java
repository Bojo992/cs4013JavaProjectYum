import CLI.*;
import Restaurant.Restaurant;

public class RestaurantSystem {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant(4);
        Menu menu = new Menu();
        menu.run();
    }
}

