package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class AstarSearch implements Strategy {

    private Map<String, Node> open;
    private Map<String, Node> closed;
    private Heuristic heuristic;
    private ProductionSystem prodSystem;

    public AstarSearch(Heuristic heuristic) {
        this.heuristic = heuristic;
        this.prodSystem = new ProductionSystem();
        this.open = new LinkedHashMap<>();
        this.closed = new LinkedHashMap<>();
    }

    public Heuristic getHeuristic() {
        return heuristic;
    }

    public void setHeuristic(Heuristic heuristic) {
        this.heuristic = heuristic;
    }

    @Override
    public Node search(State stateInitial, State stateFinal) {


        if (stateInitial != null) {
            prodSystem = new ProductionSystem();
            Node node = new Node(stateInitial);

            node.setEstimateCost(heuristic.evaluate(stateInitial, stateFinal));
            open.put(stateInitial.toString(), node);
            //System.out.println("It gets here!");
            return treeSearch(stateFinal);
        }
        return null;
    }

    private Node treeSearch(State stateFinal) {
        // TODO Auto-generated method stub
        while (!open.isEmpty()) {
            Node node = open.entrySet().iterator().next().getValue();
            //System.out.println("It gets here!");

            if (node.getState().toString().equals(stateFinal.toString())) {
                System.out.println("Number of Nodes created: " + (node.getIndex()));
                System.out.println("Reached Goal State!");
                return node;
            }

            Set<Node> successors = prodSystem.expand(node, closed);
            open.remove(node.getState().toString());
            closed.put(node.getState().toString(), node);
            //System.out.println("It gets here!");

            for (Node n : successors) {
                n.setEstimateCost(heuristic.evaluate(n.getState(),
                        stateFinal));
                n.setExactCost(node.getExactCost() + 1);
                //n.getState().print();
                if (open.get(n.getState().toString()) != null) {
                    open = updateNodeInMap(n, open);
                } else if (closed.get(n.getState().toString()) != null) {
                    closed = updateNodeInMap(n, closed);
                } else {
                    open.put(n.getState().toString(), n);
                }
            }

            open = sortMap(open);
            closed = sortMap(closed);
        }
        return null;
    }


    public Map<String, Node> updateNodeInMap(Node n, Map<String, Node> map) {
        Node nodeFromMap = map.get(n.getState().toString());

        if (nodeFromMap.getTotalCost() > n.getTotalCost()) {
            //System.out.println("Cost : " + n.getTotalCost());
            map.remove(nodeFromMap.getState().toString());
            map.put(n.getState().toString(), n);
        }

        return map;
    }

    private Map<String, Node> sortMap(Map<String, Node> map) {
        List<Map.Entry<String, Node>> entryList = new ArrayList<>(
                map.entrySet());

        Collections.sort(entryList, new Comparator<Map.Entry<String, Node>>() {
            @Override
            public int compare(Map.Entry<String, Node> node,
                               Map.Entry<String, Node> node1) {
                return Integer.compare(node.getValue().getTotalCost(), node1
                        .getValue().getTotalCost());
            }
        });

        Map<String, Node> newMap = new LinkedHashMap<>();
        for (Entry<String, Node> e : entryList) {
            newMap.put(e.getKey(),  e.getValue());

        }

        return newMap;
    }
}
