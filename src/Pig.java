/**
 * Created by chloerainezeller on 4/4/16.
 */
import java.util.ArrayList;
import java.util.Random;


public class Pig {
    // the two players
    private Player player_one;
    private Player player_two;
    // and their scores
    private int score_one;
    private int score_two;

    /*
     * The constructor. Nothing special here.
     */
    public Pig(Player one, Player two) { // we don't care what type of Players they are, we can still have this
        this.player_one = one;
        this.player_two = two;
        this.score_one = 0;
        this.score_two = 0;
    }

    /*
     * This function is where the game takes place, where the dice are rolled
     * and the scores updated. You will need to keep track of whose turn it is,
     * and call the .decide() method for that player. Some helper functions
     * have been written for you below.
    */
    public boolean play() {
        int turn = 1;
        while (this.score_one < 100 && this.score_two < 100) {
            if (turn % 2 == 1) {
                System.out.println(this.player_one.get_name() + "'s turn:");
                this.score_one += this.take_turn(player_one, score_one, score_two);
            } else {
                System.out.println(this.player_two.get_name() + "'s turn:");
                this.score_two += this.take_turn(player_two, score_two, score_one);
            }

            System.out.println("");
            this.print_score();
            System.out.println("");
            turn += 1;
        }
        this.print_win();
        if (this.score_one > 100) {
            return true;
        } else {
            return false;
        }
    }

    /*
     * This function is in charge of one player taking their turn. We roll the
     * dice first, then ask if they want to hold or keep rolling. This
     * continues until they roll a 1, or if they decide to hold.
    */
    private int take_turn(Player player, int my_score, int other_score) {
        int total = 0;
        int dice_roll;
        ArrayList<Integer> roll_histories = new ArrayList<Integer>();

        while (true) {
            dice_roll = Pig.roll_dice();
            total += dice_roll;
            roll_histories.add(dice_roll);

            System.out.print("You rolled a ");
            System.out.print(dice_roll);
            System.out.println("!");

            if (dice_roll == 1) {
                System.out.println("Sorry!");
                return 0;
            } else {
                System.out.print("Current total: ");
                System.out.println(total);
                if (player.decide(my_score, other_score, roll_histories)) {
                    System.out.print("You scored ");
                    System.out.print(total);
                    System.out.println(" points");
                    return total;
                }
            }
        }
    }

    /*
     * This function prints the score of the two players.
    */
    private void print_score() {
        System.out.print(this.player_one.get_name() + ": ");
        System.out.print(this.score_one);
        System.out.print("; " + this.player_two.get_name() + ": ");
        System.out.println(this.score_two);
    }

    /*
     * This function prints which player has won the game (if any)
    */
    private void print_win() {
        if (score_one >= 100) {
            System.out.println(this.player_one.get_name() + " WINS!!!");
        } else {
            System.out.println(this.player_two.get_name() + " WINS!!!");
        }
    }

    /*
     * This function simulates a dice roll.
    */
    private static int roll_dice() {
        Random rand = new Random();
        return rand.nextInt(6) + 1;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /*
         * This is the main function that sets things in motion.
        */
    public static void main(String[] args) {
        Player chloe = new AIPlayer("Justin");
        Player hal = new AIPlayer2("Chloe");
        int win_one = 0;
        int win_two = 0;
        for (int i = 0; i < 10000; i +=1) {
            Pig game = new Pig(chloe, hal);
            if (game.play() == true) {
                win_one += 1;
            } else {
                win_two += 1;
            }
            game.play();
        }
        System.out.println(win_one);
        System.out.println(win_two);

    }
}