package src;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

import src.Node;
import src.ProductionSystem;
import src.State;

public class BreadthFirstSearch implements Strategy{

    private ProductionSystem prodSystem;
    private Queue<Node> nodeList = new ConcurrentLinkedQueue<>();
    private Map<String, Node> visitedStates = new LinkedHashMap<>();
    private Map<Node, Set<Node>> parentMap = new HashMap<Node, Set<Node>>();
    List<Node> parents = new ArrayList<Node>();
    List<Node> path = new ArrayList<Node>();


    public Node search(State stateInitial, State stateFinal) {
        // TODO Auto-generated method stub

        if (stateInitial != null) {

            prodSystem = new ProductionSystem();

            Node node = new Node(stateInitial);
            nodeList.add(node);

            return treeSearch(stateFinal);
        }
        return null;
    }

    public Node treeSearch(State stateFinal) {

        while (!nodeList.isEmpty()) {
            Node node = nodeList.poll();  //poll to pop and remove

            if (visitedStates.get(node.getState().toString()) == null) {
                visitedStates.put(node.getState().toString(), node);

                if (node.getState().toString().equals(stateFinal.toString())){
                    //node.getState().print();
                    System.out.println("Number of Nodes created: " + (node.getIndex()));
                    System.out.println("Reached Goal State!");
                return node;
            }
                nodeList.addAll(prodSystem.expand(node, visitedStates));
            }
            }

        return null;
    }

    public static void main(String[] args) {
    }


}