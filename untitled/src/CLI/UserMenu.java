package CLI;

import utils.*;
import Restaurant.*;
import com.sun.security.jgss.GSSUtil;
import java.util.Date;
import java.util.Scanner;

public class UserMenu extends UtilsMenu {
    private Scanner in;

    public UserMenu(Scanner in) {
        this.in = in;
    }

    public void run() {
        boolean quitBackToMain = true;
        while (quitBackToMain) {
            System.out.println("R)eserve a table, V)iew reservation, C)ancel Reservation, B)ack");
            String command = in.nextLine().toUpperCase();

            switch (command) {
                case "R" -> {
                    System.out.println("Choose from which restaurant you would like to book : ");
                    var restaurant = (Restaurant) chooseFirstType(DataStorage.getAllRestaurants().toArray());

                    System.out.println("Enter the date of your reservation : ");
                    System.out.print("Date (DD/MM/YYYY) : ");
                    String chosenDate = in.nextLine();

                    System.out.println("Choose which table you would like to reserve : ");
                    var table = (Table) chooseFirstType(DataStorage.getAllTables().values().toArray());

                    //TODO reserve(restaurant, chosenDate, chosenTable) for this user

                    System.out.println("Successful reservation.");
                }

                case "V" -> {
                    System.out.println("These are your reservation :");
                    showFirstType(DataStorage.getAllTables().values().toArray());
                    //TODO show the reservation for this user
                }

                case "C" -> {
                    System.out.println("Choose which reservation you would like to cancel : ");
                    //TODO showReservations() for this user
                    showFirstType(DataStorage.getAllTables().values().toArray());
                }

                case "B" -> {
                    quitBackToMain = false;
                }

            }
        }
    }
}
