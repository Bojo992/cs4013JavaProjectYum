import People.Chef;
import People.Waiter;
import Restaurant.*;
import utils.UtilsCSV;

import java.io.IOException;
import java.util.ArrayList;

public class testCSV {
    public static void main(String[] args) throws IOException {
        Restaurant restaurant = new Restaurant(5);

        restaurant.addChef(new Chef("boris", "99999", "monkey"), "Russian");
        restaurant.addChef(new Chef("Szymon", "111111", "0-0"), "Polish");
        restaurant.addChef(new Chef("Italo", "2521515", "Brazzzzil"), "Brazilian");
        restaurant.addChef(new Chef("Craig", "123456789", "Uhhh"), "Irish");

        restaurant.addWaiter(new Waiter("test", "11", "af"), "12");
        restaurant.addWaiter(new Waiter("test 1", "12311", "afqwr"), "53");

        restaurant.addTable(new Table(14, 1));
        restaurant.addTable(new Table(34, 2));
        restaurant.addTable(new Table(39, 3));

        UtilsCSV utilsCSV = new UtilsCSV();

        ArrayList<Restaurant> test = utilsCSV.readRestaurants();

        System.out.println(test);
    }
}
