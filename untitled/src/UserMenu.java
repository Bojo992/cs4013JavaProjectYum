import java.util.Scanner;

public class UserMenu {

    private Scanner in;

    public void run() {
        while (true) {
            System.out.println("R)eserve a table, V)iew reservation, B)ack");
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

                    //pass those strings to a method to reserve table
                    //eg: reserve(email, name, attendance, date);
                }
                case "V" -> {
                    System.out.println("These are your reservation :");
                    //reservations
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
