package People;

public class Employee extends Person{
    private String title; //distinguish from chef and waiter

    public Employee(String name, String email, String phone, String title) {
        super(name, email, phone);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
