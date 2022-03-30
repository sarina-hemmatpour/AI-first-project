package com.example.a8puzzleproblem;

import java.util.ArrayList;

public class UniformCostSearch {
    private ArrayList<Node> fringe;
    private ArrayList<Node> visitedNodes;
    private Node initialNode;


    public UniformCostSearch(Node initialNode) {
        this.initialNode = initialNode;
        fringe=new ArrayList<>();
        visitedNodes=new ArrayList<>();
    }

    public ArrayList<Node> getFringe() {
        return fringe;
    }

    public void setFringe(ArrayList<Node> fringe) {
        this.fringe = fringe;
    }

    public ArrayList<Node> getVisitedNodes() {
        return visitedNodes;
    }

    public void setVisitedNodes(ArrayList<Node> visitedNodes) {
        this.visitedNodes = visitedNodes;
    }

    public Node getInitialNode() {
        return initialNode;
    }

    public void setInitialNode(Node initialNode) {
        this.initialNode = initialNode;
    }

    //expand a node: adds it in visited nodes and remove it from fringe and also adds children
    public void expand(Node node)
    {
        //check zero position to find children
        //if isGoal do not expand
        //if it is visited do not expand and also do not add it to the children
    }

    public boolean search()
    {

    }

    //if a node is goal state returns true : 0 1 2 3 4 5 6 7 8
    public static boolean isGoal(Node node)
    {
        int test=node.getState().getTiles().get(0);
        for (int i = 1; i < node.getState().getTiles().size(); i++) {
            if (test>node.getState().getTiles().get(i))
            {
                return false;
            }
            test=node.getState().getTiles().get(i);
        }

        return true;
    }



}
