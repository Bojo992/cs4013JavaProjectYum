package CLI;

import People.Customer;
import utils.DataStorage;

import java.util.Random;
import java.util.Scanner;

public class UserLoginMenu {
    private Scanner in;
    private String type;
    private LoginManager login;

    public UserLoginMenu(Scanner in, String type) {
        this.in = in;
        this.type = type;
    }

    public void run() {
        boolean quit = true;
        while (quit) {
            System.out.println("L)ogin, C)reate Account, B)ack");
            String command = in.nextLine().toUpperCase();

            switch (command) {
                case "L" -> {
                    System.out.print("Enter Username : ");
                    String username= in.nextLine();
                    System.out.print("Enter password : ");
                    String password = in.nextLine();

                    if(LoginManager.checkPass(username, password)) {
                        login.setType(type);
                        login.setUser(username);
                        login.run();
                    } else {
                        System.out.println("Invalid Username and/or Password");
                    }
                }

                case "C" -> {
                    System.out.print("    Enter your name: ");
                    String name = in.nextLine();

                    while (name.isBlank()) {
                        System.out.println("    Please enter a name: ");
                        name = in.nextLine();
                    }

                    System.out.print("    Enter your phone number (Press ENTER to skip): ");
                    String phoneNumber = in.nextLine();

                    System.out.print("    Enter your password: ");
                    String password = in.nextLine();

                    Customer customer;

                    if (!phoneNumber.isBlank()) {
                        customer = new Customer(name, phoneNumber);
                    } else {
                        customer = new Customer(name);
                    }

                    int randomNumber = (int) (Math.floor(Math.random() * (1001)));
                    customer.setId(customer.getName() + randomNumber);
                    customer.setPassword(password);

                    while (DataStorage.getAllUsernamesAndPasswords().containsKey(customer.getId())) {
                        Random random = new Random();
                        customer.setId("" + random.nextInt(100000, 999999));
                    }

                    System.out.println("    Your username: " + customer.getId());
                    System.out.println("    Your password: " + password);

                    login = new LoginManager(type, in, customer);
                    LoginManager.createAcc(customer.getId(), customer);
                }

                case "B" -> quit = false;
            }
        }
    }
}