/**
 * Created by chloerainezeller on 4/4/16.
 */
import java.util.ArrayList;
import java.util.Scanner;

public class HumanPlayer extends Player {

    public HumanPlayer(String name) {
        super(name);
    }

    /*
     * This function should ask the user for input, for whether they should
     * roll or hold. The function returns true if the player decides to hold,
     * and false if they decided to roll.
    */
    public boolean decide(int my_score,
                          int other_score,
                          ArrayList<Integer> roll_history) {
        String input = HumanPlayer.get_input("Do you want to (r)oll or (h)old? ");
        // keep asking until the user types "r" or "h"
        while (!(input.equals("r") || input.equals("h"))) {
            System.out.println("Please type either \"r\" or \"h\".");
            input = HumanPlayer.get_input("Do you want to (r)oll or (h)old? ");
        }
        return input.equals("h");

    }

    /*
     * This function gets and returns a single word from the user (as a
     * string). It takes a String argument, which is what you want to ask the
     * user.
    */
    private static String get_input(String prompt) {
        System.out.print(prompt);
        Scanner scan = new Scanner(System.in);
        return scan.next();
    }
}
