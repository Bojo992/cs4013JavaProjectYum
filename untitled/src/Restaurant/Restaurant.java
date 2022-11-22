package Restaurant;

import CLI.LoginManager;
import People.Chef;
import People.Customer;
import People.Waiter;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private List<Food> menu;
    private ArrayList<Table> tables = new ArrayList<>();
    private ArrayList<Waiter> waiters = new ArrayList<>();
    private ArrayList<Chef> chefs = new ArrayList<>();
    private ArrayList<Customer> customers = new ArrayList<>();
    public Restaurant() {
        menu = new ArrayList<>();
    }

    public List<Food> getMenu() {
        return menu;
    }

    public void addTable() {

    }

    public void addWaiter(Waiter newWaiter) {
        waiters.add(newWaiter);
        //LoginManager.createAcc();
    }

    /*
    add array lists from the datastorage
    - add waiter() which will generate an user + password and pass thru the login manager
    same for others
     */
}
