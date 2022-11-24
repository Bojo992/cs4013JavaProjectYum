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

//        restaurants = csv.readRestaurants();
//        DataStorage.setAllRestaurants(restaurants);
//        customers = csv.readCustomers();
//
//        var reservation = new Reservation(customers.get(0),
//                "24/11/2022",
//                restaurants.get(0).getTables().get(0),
//                restaurants.get(0),
//                1);
//
//        customers.get(0).addReservation(reservation);

        csv.wrightCustomers(customers);
//        csv.writeRestaurants(restaurants);
    }
}
