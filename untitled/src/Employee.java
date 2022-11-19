public class Employee extends Person{
    private String department; //distinguish from chef and waiter

    public Employee(String name, String email, String phone, String department) {
        super(name, email, phone);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Account Details : \n" +
                "Name : " + getName() + "\n" +
                "Email : " + getEmail() + "\n" +
                "Phone Number : " + getPhone() + "\n" +
                "Department : " + department;
    }
}
