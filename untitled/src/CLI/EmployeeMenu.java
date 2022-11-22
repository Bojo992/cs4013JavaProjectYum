package CLI;

import java.util.Scanner;

public class EmployeeMenu {
    private Scanner in;

    public EmployeeMenu(Scanner in) {
        this.in = in;
    }

    public void run() {
        boolean quitToMain = true;
        while (quitToMain) {
            System.out.println("W)alk-in, A)dd order, V)iew tables, C)hange order, O)rder List, L)ogout");
            String command = in.nextLine().toUpperCase();

            switch (command) {
                case "W" -> {
                    boolean quitFromWalkIn = true;
                    while (quitFromWalkIn) {
                        System.out.println("C)heck available tables, R)eserve table, G)o Back");
                        command = in.nextLine().toUpperCase();

                        switch (command) {
                            case "C" -> {
                                System.out.println("These tables are available for walk-ins : ");
                                //ToDo display tables that are available (this can be an option just to view for employer
                                // info)
                            }

                            case "R" -> {
                                System.out.println("Select a table for walk-in customer : ");
                                //ToDo display tables with a number for choice
                            }

                            case "G" -> {
                                quitFromWalkIn = false;
                            }
                        }
                    }
                }

                case "A" -> {
                    boolean quitFromAddOrder = true;
                    while (quitFromAddOrder) {
                        System.out.println("Select the Restaurant.Table you want to add order to : ");
                        //ToDo display tables and customers

                        System.out.println("Print something with a choice 1) 2) 3) F)");
                        command = in.nextLine();

                        switch (command) { //ToDo check if works, testing merging cases
                            case "1", "2", "3" -> { //ToDo need table numbers
                                System.out.println("A)dd meal, C)hange meal, F)inish ");
                                switch (command) {
                                    case "A" -> {
                                        System.out.println("What items would you like to add? : ");
                                    }
                                    case "C" -> {
                                        System.out.println("Previous meal : ");
                                        System.out.println("New meal : ");
                                    }
                                    case "F" -> {
                                        quitFromAddOrder = false;
                                    }
                                }

                                //This shouldn't be here
                                //it would need another switch, requesting input A)dd meal, C)hange meal, F)inish
                            }

                            //ToDo need menu ArrayList

                            case "F" -> {
                                quitFromAddOrder = false;
                            }


                        }
                    }
                }

                case "V" -> {
                    //showTable()
                    //break;

//                    System.out.println("B)ack");
//                    //ToDo tables from tables object
//                    switch (command) {
//                        case "B" -> {
//
//                        }
//
//                    }

                }

                case "C" -> {
                    System.out.println("Which order would you like to change? : ");
                    //ToDo Display all orders based on table selection??? or based on just order number?
                }

                case "O" -> {
                    System.out.println("Here is a list of all the current orders : ");
                    //ToDo make sure that list updates depending on order status.
                }

                case "L" -> {
                    quitToMain = false;
                }
            }
        }
    }
}
