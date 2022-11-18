import java.time.format.DateTimeFormatter;

public class Customer {
    private String name;
    private String email;
    private String phone;
    private int noOfCustomer;
    private DateTimeFormatter date
            = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    private Table table;

    public Customer(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public Customer(String name) {
        this.name = name;
    }

    public void makeOrder(Table table, Food food){

    }

    public void makeReservation(DateTimeFormatter date, Table table, int noOfCustomer){
        this.date = date;
        this.table = table;
        this.noOfCustomer = noOfCustomer;

    }

    public void changeReservation(DateTimeFormatter date, Table table){
        this.date = date;
        this.table = table;
    }

    public void cancelReservation(Table table){
        this.table = table;
        table.setAvailability(true);
        this.date = null;
    }


    /*------------------
       Getters/Setters
      ------------------*/


    public Table getTable() {
        return table;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public DateTimeFormatter getDate() {
        return date;
    }

    public void setDate(DateTimeFormatter date) {
        this.date = date;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
