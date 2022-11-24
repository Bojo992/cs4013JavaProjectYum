package Restaurant;

import People.Customer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * The type Reservation.
 */
public class Reservation {
    private Customer customer;
    private String date;
    private Table table;
    private Restaurant restaurant;
    private int noOfCustomer;

    /**
     * Instantiates a new Reservation.
     *
     * @param customer     the customer
     * @param date         the date
     * @param table        the table
     * @param restaurant   the restaurant
     * @param noOfCustomer the no of customer
     */
    public Reservation(Customer customer, String date, Table table, Restaurant restaurant, int noOfCustomer) {
        this.customer = customer;
        this.date = date;
        this.table = table;
        this.restaurant = restaurant;
        this.noOfCustomer = noOfCustomer;

        this.table.changeAvailability(date);
    }

    /**
     * Res to csv string.
     *
     * @param file the file
     * @return the string
     * @throws IOException the io exception
     */
    public String resToCSV(File file) throws IOException {//Todo move to UtilsCSV
        FileWriter writer;
        File reservationCSV =new File("reservation.csv");
        Scanner in = new Scanner(file);

        if (reservationCSV.exists() && reservationCSV.canWrite()) {
            writer = new FileWriter(reservationCSV, true);
        } else {
            writer = new FileWriter(reservationCSV);
        }
        StringBuilder resString = new StringBuilder();
        //resString.append();ToDo use .toCSV
        return String.valueOf(resString);
    }


    /**
     * Gets customer.
     *
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Gets date.
     *
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * Gets restaurant.
     *
     * @return the restaurant
     */
    public Restaurant getRestaurant() {
        return restaurant;
    }

    /**
     * Gets table.
     *
     * @return the table
     */
    public Table getTable() {
        return table;
    }

    @Override
    public String toString() {
        return "Restaurant id: " + restaurant.getId() + ", Table number: " + table.getTableNo() + ", Time: " + date + ", Number of people: " + noOfCustomer;
    }

    /**
     * To csv string. Formatting CSV file
     *
     * @return the string
     */
    public String toCSV(){
        return date + ", " +
                table.getTableNo() + ", " + restaurant.getId() + ", " + noOfCustomer;
    }
}
