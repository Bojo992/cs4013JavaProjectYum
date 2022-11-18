import com.sun.security.jgss.GSSUtil;

import java.util.Scanner;

public class UserMenu {

    private Scanner in;

    public void run() {
        while (true) {
            System.out.println("R)eserve a table, V)iew reservation,C)hange Reservation, B)ack");
            String command = in.nextLine().toUpperCase();
            switch (command) {
                case "R" -> {
                    System.out.print("Email : ");
                    String email = in.nextLine().toUpperCase();
                    System.out.print("Name : ");
                    String name = in.nextLine().toUpperCase();
                    System.out.print("People Attending : ");
                    String attendance = in.nextLine().toUpperCase();
                    System.out.print("Date : ");
                    String date = in.nextLine().toUpperCase();
                    System.out.print("Time : ");
                    String time = in.nextLine().toUpperCase();

                    //where's time?'

                    //pass those strings to a method to reserve table
                    //eg: reserve(email, name, attendance, date);
                }
                case "V" -> {
                    System.out.println("These are your reservation :");
                    //showReservations() from reservation class
                }
                case "C" -> {
                    System.out.println("Which reservation would you like to change? :");
                    String input = in.nextLine().toUpperCase();
                    // showReservations() from reservation class
                    // getReservation(input) from reservation class
                    System.out.println("Select which part you would like to change");
                    System.out.println("E)mail , N)ame , A)ttendance, D)ate, T)ime");

                    switch (command) {
                        case "E" -> {
                            System.out.print("Previous Email : ");
                            //getEamil() from reserv class

                            System.out.print("New Email : ");
                            String email = in.nextLine();
                            //setEmail() from reserv class
                            //BACK END = change the email from this reserv
                        }

                        case "N" -> {
                            System.out.print("Previous Name : ");
                            //getName() from reserv class

                            System.out.print("New Name : ");
                            String name = in.nextLine();
                            //setName() from reserv class
                        }

                        case "A" -> {
                            System.out.print("Previous People Attending :");
                            //getPeopleAttl() from reserv class

                            System.out.println("New People Attending : ");
                            String numOfPeopleAttending = in.nextLine();
                            //setPeopleAtt() from reserv class
                        }

                        case "D" -> {
                            System.out.println("Previous Date : ");
                            //getDate() from reserv class

                            System.out.print("New Date : ");
                            String date = in.nextLine();
                            //setDate() from reserv class
                        }

                        case "T" -> {
                            System.out.print("Previous Time :");
                            //getTime() from reserv class

                            System.out.println("New Time : ");
                            String time = in.nextLine();
                            //setTime() from reserv class
                        }
                    }
                }

                case "B" -> {
                    break;
                }
            }
        }
    }

    public UserMenu(Scanner in) {
        this.in = in;
    }
}
