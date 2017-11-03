import java.util.ArrayList;

public class AIPlayerBAD extends Player {

    public AIPlayerBAD(String name) {
        super(name);
    }
    public boolean decide(int my_score,
                          int other_score,
                          ArrayList<Integer> roll_history) {
        int total_roll = 0;
        for (int i = 0; i < roll_history.size(); i += 1)
            total_roll += roll_history.get(i);
                while (total_roll + my_score < other_score) {
                    return false;
                }
        return true;
        // outside return hold
        // for loop that goes through roll_history and adds up your current roll score
        // while your roll_history + my_score < other_score
        // we want to roll
        // we want to add that roll to the roll_history
        // outside of while loop, hold


    }
}
