package src;

import java.util.*;
import java.util.Map;

public class Game {

    private Map<String, Peg> gridPegs;
    private Map<String, Peg> goalPegs;
    private State stateInitial;
    private State stateFinal;

    public Game(){

    }


    public void gameInitializor(int option){

        Node node;
        Strategy strategy;

        if(option == 1){
            createBfsInitialGameState();
            strategy = new BreadthFirstSearch();
        }else if(option == 2){
            createInitialGameState();
            strategy = new DepthFirstSearch();
        }else if(option == 3){
            createInitialGameState();
            strategy = new AstarSearch(new HeuristicByNeighbourNodes());
        }else if(option == 4){
            createInitialGameState();
            strategy = new AstarSearch(new HeuristicByMoves());
        }else if(option == 5){
            createInitialGameState();
            strategy = new AstarSearch(new HeuristicByAverage());
        }else if (option == 6){
            createInitialGameState();
            strategy = new AstarSearch(new HeuristicByManhattanDistance());
        } else{
            createInitialGameState();
            strategy = new AstarSearch(new HeuristicByManhattanDistance());
        }
        createGoalState();
        stateInitial = new State(getGridPegs());
        stateFinal = new State(getGoalPegs());
        //stateInitial.print();
        //stateFinal.print();

        node = strategy.search(stateInitial, stateFinal);

        List<Node> paths = new ArrayList<>();

        if(node != null) {
            Node currentNode = node;
            while(currentNode != null) {
                paths.add(currentNode);
                currentNode = currentNode.getParent();
            }

            Collections.reverse(paths);
        }

        for (Node n : paths) {
            n.getState().print();
        }

        System.out.print("Number of moves needed: " + paths.size());
    }

    public void createGoalState() {

        goalPegs = new HashMap<String, Peg>();

        goalPegs.put("13", new Peg(1, 3));
    }

    public Map<String, Peg> getGoalPegs() {
        return goalPegs;
    }

    public void setGoalPegs(Map<String, Peg> goalPegs) {
        this.goalPegs = goalPegs;
    }

    public void createBfsInitialGameState(){

        gridPegs = new HashMap<String, Peg>();

       gridPegs.put("15", new Peg(1, 5));
       gridPegs.put("20", new Peg(2, 0));
       gridPegs.put("21", new Peg(2, 1));
       gridPegs.put("24", new Peg(2, 4));
       gridPegs.put("30", new Peg(3, 0));
       gridPegs.put("31", new Peg(3, 1));
       gridPegs.put("32", new Peg(3, 2));
       gridPegs.put("34", new Peg(3, 4));
       gridPegs.put("40", new Peg(4, 0));
       gridPegs.put("43", new Peg(4, 3));
       gridPegs.put("44", new Peg(4, 4));
       gridPegs.put("54", new Peg(5, 4));
       gridPegs.put("55", new Peg(5, 5));
       gridPegs.put("64", new Peg(6, 4));
    }

    public void createInitialGameState(){

        gridPegs = new HashMap<String, Peg>();

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if(isGridWithinBound(i, j) && isInitialPositionEmpty(i,j)){
                    String key = "" + i + j;
                    gridPegs.put(key, new Peg(i, j));
                }
            }
        }
    }

    public boolean isGridWithinBound(int i, int j) {

        if (((i == 0 || i == 1 || i == 5 || i == 6) && (j == 0 || j == 6)) || ((i == 0 || i == 6) && (j == 1 || j == 5))) {
            return false;

        } else {
            return true;
        }
    }

    public boolean isInitialPositionEmpty(int i, int j) {
        if (i == 2 && j == 3) {
            return false;
        } else {
            return true;
        }
    }

    public Map<String, Peg> getGridPegs() {
        return gridPegs;
    }

    public void setGridPegs(Map<String, Peg> gridPegs) {
        this.gridPegs = gridPegs;
    }

    public static void main(String[] args) {

        Game g = new Game();
        boolean running = true;
        int option = 0;

            System.out.println("Welcome to European Peg Solitaire! Enter option!");
            System.out.println("[1]: Breadth First Search");
            System.out.println("[2]: Depth First Search");
            System.out.println("[3]: A* Search: By neighbouring nodes");
            System.out.println("[4]: A* Search: By possible moves");
            System.out.println("[5]: A* Search: By average");
            System.out.println("[6]: A* Search: By manhattan distance");
            System.out.println("Press any other value to Exit!");
            Scanner in = new Scanner(System.in);
            System.out.print("Enter Option: ");
            option = in.nextInt();

            if (option >= 1 && option <= 6) g.gameInitializor(option);
            else{
                System.exit(0);
            }
    }
}
