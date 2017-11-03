/**
 * Created by chloerainezeller on 4/4/16.
 */

/*
We need another class for the AI. General category of players, sub-categories, one AI and one human
HumanPLayer and AIPlayer should be subclasses of PLayer

In Java, these relationships are necessary so Java knows what types the variables are

Approach:
1. Figure out what information all Players should have/will need
2. Create the Player superclass
3. Create the HumanPlayer class by adopting existing code
4. Create the AIPlayer class

I we need to writa an AI that plays pig, what does it need to know?
It needs to know some sort of strategy
It needs to know the other players score
It needs to know its own score
It needs to know what it has just rolled and its history of rolls for the turn
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public String get_name() {
        return this.name;
    }

    /*
     * This function should ask the user for input, for whether they should
     * roll or hold. The function returns true if the player decides to hold,
     * and false if they decided to roll.
    */
    public boolean decide(int my_score,
                          int other_score,
                          ArrayList<Integer> roll_history) {
        return true; // dummy value

        /*
        String input = Player.get_input("Do you want to (r)oll or (h)old? ");
        // keep asking until the user types "r" or "h"
        while (!(input.equals("r") || input.equals("h"))) {
            System.out.println("Please type either \"r\" or \"h\".");
            input = Player.get_input("Do you want to (r)oll or (h)old? ");
        }
        return input.equals("h");
        */
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