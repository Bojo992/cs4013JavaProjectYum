import People.Customer;
import Restaurant.*;
import utils.DataStorage;
import utils.UtilsCSV;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class testCustomerCSV {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
        ArrayList<Customer> customers = new ArrayList<Customer>();
//        Customer customer = new Customer("Boris");
//        customer.setPassword("monkey");
//        customer.setId("angry");
//        customers.add(customer);
//        customer = new Customer("Szymon", "legend");
//        customer.setPassword("0-0");
//        customer.setId("void");
//        customers.add(customer);
//        customer = new Customer("Italo", "worker");
//        customer.setPassword("22");
//        customer.setId("void");
//        customers.add(customer);
//        customer = new Customer("Craig", "writer");
//        customer.setPassword("44");
//        customer.setId("void");
//        customers.add(customer);

        UtilsCSV csv = new UtilsCSV();

        restaurants = csv.readRestaurants();
        DataStorage.setAllRestaurants(restaurants);
        customers = csv.readCustomers();
        DataStorage.setAllCustomers(customers);

//        var reservation = new Reservation(customers.get(0),
//                "24/11/2022",
//                restaurants.get(0).getTables().get(0),
//                restaurants.get(0),
//                1);
//
//        customers.get(0).addReservation(reservation);

        csv.wrightCustomers(customers);
        csv.writeRestaurants(restaurants);
    }
}
//Boris, null, angry, monkey, null
//Szymon, legend, void, 0-0, null
//Italo, worker, void, 22, null
//Craig, writer, void, 44, null

//restaurant, 0, 2
//tables,
//0, 1, 24/11/2022, true
//0, 1, null, false
//1, 2, null, false
//waiters
//test, teset, Waiter, 1702297201, test
//chef
//test, test, test, null, null
//orders
//started, 0, lol, 6.0
//started, 0, test, 9.0
//menu
//category, test
//test, 9.0
//test 1, 8.0
//category, qwer
//lol, 6.0
//restaurant, 1, 5
//tables,
//0, 5, null, false
//1, 5, null, false
//2, 5, null, false
//3, 3, null, false
//4, 2, null, false
//waiters
//test, test, Waiter, null, test
//chef
//test, test, test, null, test
//test, test, test, null, test
//orders
//menu
//category, test
//test, 9.0
//xc, 8.0
//chicken, 4.9
//category, lunch
//sandwich, 3.0
