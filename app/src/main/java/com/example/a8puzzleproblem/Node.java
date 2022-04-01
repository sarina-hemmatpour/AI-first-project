package com.example.a8puzzleproblem;

import java.util.ArrayList;

public class Node {

    private State state;
    private int pathCost;
    private int totalPathCost;
    private int depth;
    private Node parent;
    private ArrayList<Node> children;
    private Action.action preAction;

    public Node(State state, Node parent , Action.action pAction) {
        this.state = state;
        this.parent = parent;
        pathCost=1;
        totalPathCost=parent.getTotalPathCost()+pathCost;
        children=new ArrayList<>();
        depth=parent.getDepth()+1;
        preAction=pAction;
    }

    public Node(State state, int pathCost, int totalPathCost, int depth, Node parent) {
        this.state = state;
        this.pathCost = pathCost;
        this.totalPathCost = totalPathCost;
        this.depth = depth;
        this.parent = parent;
        preAction= Action.action.NONE;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getPathCost() {
        return pathCost;
    }

    public void setPathCost(int pathCost) {
        this.pathCost = pathCost;
    }

    public int getTotalPathCost() {
        return totalPathCost;
    }

    public void setTotalPathCost(int totalPathCost) {
        this.totalPathCost = totalPathCost;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public ArrayList<Node> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<Node> children) {
        this.children = children;
    }

    public Action.action getPreAction() {
        return preAction;
    }

    public void setPreAction(Action.action preAction) {
        this.preAction = preAction;
    }
}
