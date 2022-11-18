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
       + seeOrders()
       + seeOrder(table:int)
       + addOrder(Order:Order) void
       + seeTable() arr
       + reserveTable(cust:cust , table:int)

       public String seeOrders() {
            return orders;
       }

       public String seeOrder(int table) {
            if (table.reserved == false || table.exist == true) {
                return table.toString();
            } else {
                return System.out.print("There's a miss input.");
            }
       }

       public void addOrder(Order order) {
            check with Szymon how to this
            hash map, array, arraylist? no idea
       }

       public void reserveTable(Customer customer,int table) {
            //yes
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