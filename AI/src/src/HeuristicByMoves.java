package src;

public class HeuristicByMoves extends Heuristic {

    @Override
    public int evaluate(State stateInitial, State finalState) {

        int estimate = 0;
        for (int i = 0; i < stateInitial.getGrid().length; i++) {
            for (int j = 0; j < stateInitial.getGrid().length; j++) {
                if (stateInitial.isGridWithinBound(i, j) && stateInitial.getGrid()[i][j] != null) {
                    estimate += getEstimate(stateInitial, i, j);

                }
            }
        }

        return estimate - 1 - (1/(estimate+1));
    }

    public int getEstimate(State stateInitial, int i, int j) {
    int estimate = 0;

        if(move.isRight(stateInitial, i, j)) {
            estimate++;
        }

        if(move.isLeft(stateInitial, i, j)) {
            estimate++;
        }

        if(move.isUp(stateInitial, i, j)) {
            estimate++;
        }

        if(move.isDown(stateInitial, i, j)) {
            estimate++;
        }

        return estimate;

    }


}
