import java.time.LocalDate;

public class Customer {
    private String name;
    private String email;
    private String phone;
    private int noOfCustomer;
    private LocalDate date = LocalDate.now();
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

    public void makeReservation(LocalDate date, Table table, int noOfCustomer){
        this.date = date;
        this.table = table;
        this.noOfCustomer = noOfCustomer;

    }

    public void changeReservation(LocalDate date, Table table){
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
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
