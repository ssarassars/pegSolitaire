package src;

public class HeuristicByAverage extends Heuristic{

    private HeuristicByNeighbourNodes heuristicByNeighbourNodes;
    private HeuristicByMoves HeuristicByMoves;

    public HeuristicByAverage() {
        heuristicByNeighbourNodes = new HeuristicByNeighbourNodes();
        HeuristicByMoves = new HeuristicByMoves();
    }

    @Override
    public int evaluate(State initialState, State goalState) {
        estimate = (heuristicByNeighbourNodes.evaluate(initialState, goalState)
                + HeuristicByMoves.evaluate(initialState, goalState)) / 2;

        return estimate;
    }


}
