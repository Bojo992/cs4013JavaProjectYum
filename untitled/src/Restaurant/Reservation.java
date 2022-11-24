package Restaurant;

import People.Customer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Reservation {
    private Customer customer;
    private String date;
    private Table table;
    private Restaurant restaurant;
    private int noOfCustomer;

    public Reservation(Customer customer, String date, Table table, Restaurant restaurant, int noOfCustomer) {
        this.customer = customer;
        this.date = date;
        this.table = table;
        this.restaurant = restaurant;
        this.noOfCustomer = noOfCustomer;

        this.table.changeAvailability(date);
    }

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


    public Customer getCustomer() {
        return customer;
    }

    public String getDate() {
        return date;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public Table getTable() {
        return table;
    }

    @Override
    public String toString() {
        return "Restaurant id: " + restaurant.getId() + ", Table number: " + table.getTableNo() + ", Time: " + date + ", Number of people: " + noOfCustomer;
    }

    public String toCSV(){
        return date + ", " +
                table.getTableNo() + ", " + restaurant.getId() + ", " + noOfCustomer;
    }
}
