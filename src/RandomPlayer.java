import java.util.ArrayList;
import java.util.Random;

public class RandomPlayer extends Player {

    public RandomPlayer(String name) {
        super(name);
    }

    public boolean decide(int my_score,
                          int other_score,
                          ArrayList<Integer> roll_history) {
        Random rand = new Random();
        // ask for a random number >= 0 < 2 (that is, 0 or 1)
        // if it's a 1, hold; if it's a 0, roll
        // essentially, randomly decide whether to roll or hold
        return (rand.nextInt(2) > 0);
    }
}
