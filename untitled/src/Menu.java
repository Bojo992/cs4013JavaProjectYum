import java.util.Scanner;

public class Menu {

    private Scanner in;

    public Menu() {

        in = new Scanner(System.in);
    }

    public void run() {
        System.out.println("Restaurant Menu");

        boolean more = true;

        while (more) {
            System.out.println("Login as E)mployee or U)ser");
            String command = in.nextLine().toUpperCase();

            switch (command) {
                case "E" -> {
                    System.out.println("Enter employee's ID and password");
                    //csv or new EmployeeLoginMenu(in).run; just like the user one
                }

                case "U" -> {
                    new UserLoginMenu(in).run();
                }

            }

        }


    }

}
