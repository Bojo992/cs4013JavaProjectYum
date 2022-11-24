package CLI;

import People.Customer;
import utils.*;
import Restaurant.*;

import java.util.Scanner;

public class UserMenu extends UtilsMenu {
    private Scanner in;
    private Customer user;

    public UserMenu(Scanner in, Customer user) {
        this.in = in;
        this.user = user;
    }

    public void run() {
        boolean quitBackToMain = true;
        while (quitBackToMain) {
            System.out.println("R)eserve a table, V)iew reservation, C)ancel Reservation, B)ack");
            String command = in.nextLine().toUpperCase();

            switch (command) {
                case "R" -> {
                    System.out.println("Choose from which restaurant you would like to book : ");
                    var restaurant = (Restaurant) pick(DataStorage.getAllRestaurants().toArray());

                    System.out.println("Enter the date of your reservation : ");
                    System.out.print("Date (DD/MM/YYYY) : ");
                    String chosenDate = in.nextLine();

                    System.out.println("Choose which table you would like to reserve : ");
                    var table = (Table) pick(restaurant.getTables().toArray());

                    System.out.print("Enter number of people attending: ");
                    int numberOfPeople = -1;

                    while (true) {
                        try {
                            numberOfPeople = Integer.parseInt(in.nextLine());

                            if (numberOfPeople > table.getSeats()) {
                                throw new IndexOutOfBoundsException("This table can not fit this amount of people.");
                            }

                            break;
                        } catch (Exception ex) {
                            if (ex instanceof IndexOutOfBoundsException) {
                                System.out.println(ex.getMessage());
                            }
                            System.out.print("Please enter number of people attending: ");
                        }
                    }


                    var reservation = new Reservation(user, chosenDate, table, restaurant, numberOfPeople);

                    user.addReservation(reservation);
                    System.out.println("Successful reservation.");
                }

                case "V" -> {
                    System.out.println("These are your reservation :");
                    show(user.getReservations().toArray());
                    System.out.println();
                }

                case "C" -> {
                    System.out.println("Choose which reservation you would like to cancel : ");
                    Reservation reservation = (Reservation) pick(user.getReservations().toArray());

                    if (reservation == null) {
                        break;
                    }

                    user.removeReservation(reservation);

                    System.out.println("Reservation was removed.");
                    System.out.println();
                }

                case "B" -> {
                    quitBackToMain = false;
                }
            }
        }
    }
}
