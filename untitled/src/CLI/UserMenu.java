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
                    var restaurant = (Restaurant) chooseFirstType(DataStorage.getAllRestaurants().values().toArray());

                    System.out.println("Enter the date of your reservation : ");
                    System.out.print("Date (DD/MM/YYYY) : ");
                    String chosenDate = in.nextLine();

                    System.out.println("Choose which table you would like to reserve : ");
                    var table = (Table) chooseFirstType(DataStorage.getAllTables().values().toArray());
                    System.out.println("Table : ");
                    String chosenTable = in.nextLine();

                    //TODO reserve(chosenRestaurant, chosenDate, chosenTable);
                    System.out.println("Successful reservation.");
                }

                case "V" -> {
                    System.out.println("These are your reservation :");
                    //TODO showReservations() from reservation class
                }

                case "C" -> {
                    System.out.println("Choose which reservation you would like to cancel : ");
                    //TODO showReservations()
                    showFirstType(DataStorage.getAllTables().values().toArray());
                    /*
                    boolean quitFromChangeRes = true;
                    while (quitFromChangeRes) {
                        System.out.println("Which reservation would you like to change? :");
                        String input = in.nextLine().toUpperCase();
                        //TODO showReservations() from reservation class
                        // getReservation(input) from reservation class
                        System.out.println("Select which part you would like to change");
                        System.out.println("E)mail , N)ame , A)ttendance, D)ate, T)ime, G)o Back");

                        switch (input) {
                            case "E" -> {
                                System.out.print("Previous Email : ");
                                //ToDo getEamil() from reserv class

                                System.out.print("New Email : ");
                                String email = in.nextLine();
                                //ToDo setEmail() from reserv class
                                //ToDo BACK END = change the email from this reserv
                            }

                            case "N" -> {
                                System.out.print("Previous Name : ");
                                //ToDo getName() from reserv class

                                System.out.print("New Name : ");
                                String name = in.nextLine();
                                //ToDo setName() from reserv class
                            }

                            case "A" -> {
                                System.out.print("Previous People Attending :");
                                //ToDo getPeopleAttl() from reserv class

                                System.out.println("New People Attending : ");
                                String numOfPeopleAttending = in.nextLine();
                                //ToDo setPeopleAtt() from reserv class
                            }

                            case "D" -> {
                                System.out.println("Previous Date : ");
                                //ToDo getDate() from reserv class

                                System.out.print("New Date : ");
                                String date = in.nextLine();
                                //ToDo setDate() from reserv class
                            }

                            case "T" -> {
                                System.out.print("Previous Time :");
                                //ToDo getTime() from reserv class

                                System.out.println("New Time : ");
                                String time = in.nextLine();
                                //ToDo setTime() from reserv class
                            }

                            case "G" -> {
                                quitFromChangeRes = false;
                            }
                        }
                    } */
                }

                case "B" -> {
                    quitBackToMain = false;
                }

            }
        }
    }
}
