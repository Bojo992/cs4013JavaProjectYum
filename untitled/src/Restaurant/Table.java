package Restaurant;

import javax.management.AttributeValueExp;
import java.security.PublicKey;
import java.util.HashMap;

/**
 * The Table class
 */
public class Table {
    private int tableNo;
    private int seats;
    private HashMap<String, Boolean> availability;
    private int numberOfTable = 0;

    /**
     * Instantiates a new Table.
     * @param tableNo the table no
     * @param seats   the seats
     */
    public Table(int tableNo, int seats) {
        this.tableNo = tableNo;
        this.seats = seats;
        this.availability = new HashMap<>();
        this.numberOfTable++;
    }

    /**
     * Gets number of all table.
     * @return the number of all table
     */
    public int getNumberOfAllTable() {
        return numberOfTable;
    }

    /**
     * Gets table no.
     * @return the table no
     */
    public int getTableNo() {
         return tableNo;
     }

    /**
     * Gets seats.
     * @return the seats
     */
    public int getSeats() {
        return seats;
    }

    /**
     * Gets availability.
     * @return the availability
     */
    public HashMap<String, Boolean> getAvailability() {
        return availability;
    }

    /**
     * Sets availability.
     * @param availability the availability
     */
    public void setAvailability(HashMap<String, Boolean> availability) {
        this.availability = availability;
    }

    /**
     * Change availability.
     * @param date the date
     */
    public void changeAvailability(String date) {
        availability.put(date, true);
    }

    /**
     * Remove reservation.
     * @param date the date
     */
    public void removeReservation(String date) {
        availability.remove(date);
    }

    @Override
    public String toString() {
        return "Table number: " + tableNo + ", Number of seats: " + seats;
    }
}
