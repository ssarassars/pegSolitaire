package src;
import java.util.HashMap;
import java.util.Map;
public class HeuristicByNeighbourNodes extends Heuristic {

    public HeuristicByNeighbourNodes() {
        createCostValueGrid();

    }

    @Override
    public int evaluate(State initialState, State finalState) {

        int estimate = 0;
        for (int i = 0; i < initialState.getGrid().length; i++) {
            for (int j = 0; j < initialState.getGrid().length; j++) {
                if (initialState.isGridWithinBound(i, j) && initialState.getGrid()[i][j] != null) {
                    String key = "" + i + j;
                    estimate = estimate + costValues.get(key);
                }
            }
        }

        return estimate;
    }

    public void createCostValueGrid() {

        costValues = new HashMap<String, Integer>();

        costValues.put("02", 4);
        costValues.put("03", 2);
        costValues.put("04", 4);
        costValues.put("11", 1);
        costValues.put("12", 0);
        costValues.put("13", 1);
        costValues.put("14", 0);
        costValues.put("15", 1);
        costValues.put("20", 4);
        costValues.put("21", 1);
        costValues.put("22", 2);
        costValues.put("23", 0);
        costValues.put("24", 2);
        costValues.put("25", 1);
        costValues.put("26", 4);
        costValues.put("30", 1);
        costValues.put("31", 1);
        costValues.put("32", 2);
        costValues.put("33", 1);
        costValues.put("34", 2);
        costValues.put("35", 1);
        costValues.put("36", 1);
        costValues.put("40", 4);
        costValues.put("41", 1);
        costValues.put("42", 2);
        costValues.put("43", 2);
        costValues.put("44", 2);
        costValues.put("45", 1);
        costValues.put("46", 4);
        costValues.put("51", 4);
        costValues.put("52", 1);
        costValues.put("53", 1);
        costValues.put("54", 1);
        costValues.put("55", 4);
        costValues.put("62", 4);
        costValues.put("63", 1);
        costValues.put("64", 4);

    }
}

