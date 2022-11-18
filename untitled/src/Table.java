public class Table {
    private int tableNo;
    private int seats;
    private boolean availability;

    public Table(int tableNo, int seats, boolean availability) {
        this.tableNo = tableNo;
        this.seats = seats;
        this.availability = availability;
    }


     /*------------------
       Getters/Setters
      ------------------*/

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public int getTableNo() {
        return tableNo;
    }

    public boolean Availability() {
        return availability;
    }
}
