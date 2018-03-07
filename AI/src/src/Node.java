package src;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Node {

    private State state;
    private int index;
    private Position movePosition;
    public static int nodeCount = 0;
    private Node parent;
    private int exactCost;
    private int estimateCost;
    private Set<String> action;
    private int parentIndex;

    public Node(State state) {
        this.state = state;
        this.action = new LinkedHashSet<>();
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Set<String> getAction() {
        return action;
    }

    public void setAction(Set<String> actions) {
        this.action = actions;
    }

    public void setAction(String s) {
        this.action.add(s);
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public int getParentIndex() {
        return parentIndex;
    }

    public void setParentIndex(int parentIndex) {
        this.parentIndex = parentIndex;
    }



    public Position getMovePosition() {
        return movePosition;
    }

    public void setMovePosition(Position movePosition) {
        this.movePosition = movePosition;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public static void increaseNodeCount() {
        nodeCount++;
    }

    public static int getNodeCount() {
        return nodeCount;
    }

    public int getExactCost() {
        return exactCost;
    }

    public int getTotalCost() {
        return exactCost + estimateCost;
    }

    public void setExactCost(int exactCost) {
        this.exactCost = exactCost;
    }

    public int getEstimateCost() {
        return estimateCost;
    }

    public void setEstimateCost(int estimateCost) {
        this.estimateCost = estimateCost;
    }

    public void clearActions () {
        action.clear();
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        else if (obj == null || obj.getClass() != this.getClass())
            return false;

        Node node = (Node) obj;

        return (this.state.equals(node.state)) && (this.action.equals(node.action)) && (this.movePosition == node.movePosition) && (this.parent.equals(node.parent))
                && (this.index == node.index) && (this.exactCost == node.exactCost) && (this.estimateCost == node.estimateCost);
    }

    }
