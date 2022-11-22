package CLI;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class UtilsMenu<T> {
    private Scanner in;

    public abstract void run();

    protected T Choice(ArrayList<T> choices) {
        if (choices.isEmpty()) {
            System.out.println("There are no options chose from");
            return null;
        }
        while (true) {
            int i = 0;

            System.out.printf(" %d) Exit", i);
            for (T c : choices) {
                i++;
                System.out.printf(" %d) %s", i, c.toString());
                System.out.println();
            }
            while (true) {
                int j = -1;

                while (true) {
                    try{
                        j = Integer.parseInt(in.nextLine());
                        break;
                    }catch (Exception ex){
                        System.out.println("Please pick from above");
                    }
                }
                if (j == 0){
                    return null;
                }
                if (j>0 && j <= choices.size()){
                    return choices.get(j - 1);
                }

                System.out.println("Please pick from above");
            }
        }
    }

    protected void show(ArrayList<T> choices){
        int i = 0;
        for (T c:choices){
            System.out.printf(" %d) %s", i, c.toString());
        }
    }
}
