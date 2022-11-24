package Restaurant;

import javax.management.AttributeValueExp;
import java.security.PublicKey;
import java.util.HashMap;

public class Table {
    private int tableNo;
    private int seats;
    private HashMap<String, Boolean> availability;
    private int numberOfTable = 0;

    public Table(int tableNo, int seats) {
        this.tableNo = tableNo;
        this.seats = seats;
        this.availability = new HashMap<>();
        this.numberOfTable++;
    }



     /*------------------
       Getters/Setters
      ------------------*/

    public int getNumberOfAllTable() {
        return numberOfTable;
    }

    public int getTableNo() {
         return tableNo;
     }

    public int getSeats() {
        return seats;
    }

    public HashMap<String, Boolean> getAvailability() {
        return availability;
    }

    public void setAvailability(HashMap<String, Boolean> availability) {
        this.availability = availability;
    }

    public void changeAvailability(String date) {
        availability.put(date, true);
    }

    public void removeReservation(String date) {
        availability.remove(date);
    }

    @Override
    public String toString() {
        return "Table number: " + tableNo + ", Number of seats: " + seats;
    }
}
