package Restaurant;

import java.util.HashMap;

public class Table {
    private int tableNo;
    private int seats;
    private HashMap<String, Boolean> availability;

    public Table(int tableNo, int seats) {
        this.tableNo = tableNo;
        this.seats = seats;
        this.availability = new HashMap<>();
    }


     /*------------------
       Getters/Setters
      ------------------*/

    public void changeAvailability(String date) {
        availability.put(date, true);
    }

    public int getTableNo() {
        return tableNo;
    }


}
