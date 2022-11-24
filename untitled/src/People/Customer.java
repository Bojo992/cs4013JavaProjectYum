package People;
import Restaurant.Food;
import Restaurant.Reservation;
import Restaurant.Table;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Customer class which extends Person class
 */
public class Customer extends Person {

    private ArrayList<Reservation> reservations;

    /**
     * Constructor which specifies name
     * @param name
     */
    public Customer(String name) {
        super(name);
        reservations = new ArrayList<>();
    }

    /**
     * Constructor which specifies name and phone
     * @param name
     * @param phone
     */
    public Customer(String name, String phone) {
        super(name, phone);
        reservations = new ArrayList<>();
    }

    /**
     * @param reservation
     * Adds a Reservation object to an ArrayList of reservations
     */
    public void addReservation(Reservation reservation){
        reservations.add(reservation);
    }

    /**
     * @param reservation
     * Removes a Reservation object to an ArrayList of reservations
     */
    public void removeReservation(Reservation reservation) {
        reservations.remove(reservation);
        reservation.getTable().removeReservation(reservation.getDate());
    }


    /**
     * @return
     * Gets the ArrayList of reservations
     */
    public ArrayList<Reservation> getReservations() {
         return reservations;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
