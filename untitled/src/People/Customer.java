package People;
import Restaurant.Food;
import Restaurant.Reservation;
import Restaurant.Table;

import java.time.LocalDate;
import java.util.ArrayList;

public class Customer extends Person {
    private int noOfCustomer;
    private ArrayList<Reservation> reservations;

    public Customer(String name) {
        super(name);
        reservations = new ArrayList<>();
    }

    public Customer(String name, String phone) {
        super(name, phone);
        reservations = new ArrayList<>();
    }

    public void makeOrder(Table table, Food food){

    }

<<<<<<< HEAD
    public void addReservation(Reservation reservation){
        reservations.add(reservation);
    }

    public void removeReservation(Reservation reservation) {
        reservations.remove(reservation);
    }

=======
>>>>>>> ffbe52922593a2bb3d656eb8a3c64dca98e590f0
    /*------------------
       Getters/Setters
      ------------------*/

    public ArrayList<Reservation> getReservations() {
         return reservations;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
