package utils;

import java.util.Scanner;

/**
 * The Utils menu class
 */
public abstract class UtilsMenu {
    private Scanner in = new Scanner(System.in);

    /**
     * Run
     */
    public abstract void run();

    /**
     * Pick object
     * @param choices the choices
     * @return the object
     */
    public Object pick(Object[] choices) {
        if (choices.length == 0) {
            System.out.println("There are no options chose from");
            return null;
        }

        while (true) {
            int i = 0;

            System.out.printf(" %d) Exit\n", i);
            for (Object c : choices) {
                i++;
                System.out.printf(" %d) %s", i, c.toString());
                System.out.println();
            }
            while (true) {
                int j = -1;

                while (true) {
                    String line = in.nextLine();
                    try{
                        j = Integer.parseInt(line);
                        break;
                    }catch (Exception ex){
                        System.out.println("Please pick from above: ");
                    }
                }
                if (j == 0){
                    return null;
                }
                if (j>0 && j <= choices.length){
                    return choices[j - 1];
                }

                System.out.println("Please pick from above");
            }
        }
    }

    /**
     * Show
     * @param choices the choices
     */
    public void show(Object[] choices){
        int i = 1;
        for (Object c:choices){
            System.out.printf(" %d) %s", i, c.toString());
            System.out.println();
        }
        System.out.println();
    }
}
