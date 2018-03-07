package src;

import java.util.Map;

public class Heuristic {

    protected int estimate;
    protected Move move;
    protected Map<String, Integer> costValues;
    protected Map<String, Integer> manhattanDistance;

    public int evaluate (State initialState, State goalState) {
        return estimate;
    }
    public int getEstimate() {
        return estimate;
    }
    public void setEstimate(int estimate) {
        this.estimate = estimate;
    }
    public static void main(String[] args) {

    }
}




