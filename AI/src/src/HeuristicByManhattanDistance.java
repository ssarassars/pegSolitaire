package src;

import java.util.HashMap;

public class HeuristicByManhattanDistance extends Heuristic{


    public HeuristicByManhattanDistance(){


    }
    @Override
    public int evaluate(State initialState, State finalState) {

        int estimate = 0;
        createManhattanDistanceGrid();
        for (int i = 0; i < initialState.getGrid().length; i++) {
            for (int j = 0; j < initialState.getGrid().length; j++) {
                if (initialState.isGridWithinBound(i, j) && initialState.getGrid()[i][j] != null) {
                    String key = "" + i + j;
                    estimate = estimate + manhattanDistance.get(key);
                }
            }
        }

        return estimate;
    }

    public void createManhattanDistanceGrid() {

        manhattanDistance = new HashMap<String, Integer>();

        manhattanDistance.put("02", 1);
        manhattanDistance.put("03", 0);
        manhattanDistance.put("04", 1);
        manhattanDistance.put("11", 1);
        manhattanDistance.put("12", 0);
        manhattanDistance.put("13", 1);
        manhattanDistance.put("14", 0);
        manhattanDistance.put("15", 1);
        manhattanDistance.put("20", 3);
        manhattanDistance.put("21", 2);
        manhattanDistance.put("22", 1);
        manhattanDistance.put("23", 0);
        manhattanDistance.put("24", 1);
        manhattanDistance.put("25", 2);
        manhattanDistance.put("26", 3);
        manhattanDistance.put("30", 4);
        manhattanDistance.put("31", 3);
        manhattanDistance.put("32", 2);
        manhattanDistance.put("33", 1);
        manhattanDistance.put("34", 2);
        manhattanDistance.put("35", 3);
        manhattanDistance.put("36", 4);
        manhattanDistance.put("40", 5);
        manhattanDistance.put("41", 4);
        manhattanDistance.put("42", 3);
        manhattanDistance.put("43", 2);
        manhattanDistance.put("44", 3);
        manhattanDistance.put("45", 4);
        manhattanDistance.put("46", 5);
        manhattanDistance.put("51", 5);
        manhattanDistance.put("52", 4);
        manhattanDistance.put("53", 3);
        manhattanDistance.put("54", 4);
        manhattanDistance.put("55", 5);
        manhattanDistance.put("62", 5);
        manhattanDistance.put("63", 4);
        manhattanDistance.put("64", 5);

    }


}
