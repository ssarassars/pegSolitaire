package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import src.Node;
import src.ProductionSystem;
import src.State;
import src.Strategy;

public class DepthFirstSearch implements Strategy {
    private Stack<Node> nodeList = new Stack<>();
    private Map<String, Node> visitedStates = new LinkedHashMap<>();
    private ProductionSystem prodSystem;


    @Override
    public Node search(State stateInitial, State stateFinal) {
        // TODO Auto-generated method stub
        if (stateInitial != null) {

            prodSystem = new ProductionSystem();

            Node node = new Node(stateInitial);
            nodeList.push(node);

            return treeSearch(stateFinal);
        }
        return null;
    }

    private Node treeSearch(State stateFinal) {
        // TODO Auto-generated method stub
        while (!nodeList.isEmpty()) {
            Node node = nodeList.pop();

            if (visitedStates.get(node.getState().toString()) == null) {
                visitedStates.put(node.getState().toString(), node);


                if (node.getState().toString().equals(stateFinal.toString())) {
                    //node.getState().print();
                    System.out.println("Number of Nodes created: " + (node.getIndex()));
                    System.out.println("Reached Goal State!");
                    return node;
                }else {

                    for (Node n : prodSystem.expand(node, visitedStates)) nodeList.push(n);
                }

                }
            }
            return null;
    }
}