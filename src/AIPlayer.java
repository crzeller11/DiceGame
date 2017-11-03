import java.util.ArrayList;

public class AIPlayer extends Player {

    public AIPlayer(String name) {
        super(name);
    }
    public boolean decide(int my_score,
                          int other_score,
                          ArrayList<Integer> roll_history) {
        int total_roll = 0;
        for (int i = 0; i < roll_history.size(); i += 1)
            total_roll += roll_history.get(i);
            while (total_roll < 20) {
                return false;
        }
        return true;


    }
}
