public class Employee {
    private String name;
    private int phoneNo;
    private String address;
    private String department;
    private String position;

    public Employee(String name, int phoneNo, String address, String department, String position) {
        this.name = name;
        this.address = address;
        this.phoneNo = phoneNo;
        this.department = department;
        this.position = position;
    }

    /*
    Search which table is taken.
    Create an order for a table:
    •	Should specify person’s meal
    •	Meal should be coherent with menu of restaurant
    Change status of an order.

    public void tableOrder(param) {
        Order customer = new Order(); //from another class (maybe an array list for orders)

        if (check if order is coherent with menu) {
            customer.add(param);
        } else {
            maybe throw a try and catch here with the exceptions to handle it
        }
    }

    public void orderStatus(param) {
        order.setStatus(param); // setStatus() from the order class
    }
    */

    public String getName() {
        return name;
    }

    public int getPhoneNo() {
        return phoneNo;
    }

    public String getAddress() {
        return address;
    }

    public String getPosition() {
        return position;
    }

    public String getDepartment() {
        return department;
    }

    public String toString() {
        return "Employee" +
                "\n Name: " + name +
                "\n Phone Number: " + phoneNo +
                "\n Address: " + address +
                "\n Department: " + department +
                "\n Position: " + position;
    }
}