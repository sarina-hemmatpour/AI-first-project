package com.example.a8puzzleproblem;

import java.util.ArrayList;

public class UniformCostSearch implements Information{
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
        node.setChildren(generateChildren(node));
        //adding children to the fringe
        fringe.addAll(node.getChildren());

    }

    public Node search()
    {
        //check if it is solvable
        if (false)
        {
            System.out.println("Not solvable");
        }
        else
        {
            addToFringe(initialNode);

            for (int i = 0; i < fringe.size(); i++) {

                Node toExpandNode=checkFringe();

//                showPuzzle(toExpandNode);
                if (isGoal(toExpandNode))
                {
                    System.out.println(savePath(toExpandNode,""));
                    System.out.println("n:"+numberOfExpandedNodes());
                    System.out.println("tc:"+totalCost(toExpandNode));
                    System.out.println("d:"+depth(toExpandNode));
                    showActions(setOfActions(toExpandNode));
                    return toExpandNode;
                }
                else
                {
                    if (!isVisited(toExpandNode))
                    {
                        //expand it
                        expand(toExpandNode);
                        visitedNodes.add(toExpandNode);
                        fringe.remove(toExpandNode);
                        i=0;
                    }
                }
            }
        }

        return null;
    }

    public boolean isVisited(Node node)
    {
        if (visitedNodes.size()==0)
        {
            return false;
        }
        for (int i = 0; i < visitedNodes.size(); i++) {
            for (int j = 0; j < 9; j++) {
                if (node.getState().getTiles().get(j)!= visitedNodes.get(i).getState().getTiles().get(j))
                {
                    return false;
                }
            }

        }

        return true;
    }



    public boolean isVisited(State state)
    {
        if (visitedNodes.size()==0)
        {
            return false;
        }
        for (int i = 0; i < visitedNodes.size(); i++) {
            if (State.compareStates(state , visitedNodes.get(i).getState()))
            {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Node> generateChildren(Node parentNode)
    {
        ArrayList<Node> children=new ArrayList<>();

        int zeroPos=Action.findZeroPosition(parentNode.getState());
        int parentZeroPos=-1;
        if (parentNode.getDepth()!=0)
        {
            parentZeroPos=Action.findZeroPosition(parentNode.getParent().getState());
        }

        //down
        if (zeroPos<6)
        {
            Node downNode=new Node(Action.moveToDown(parentNode.getState()) , parentNode , Action.action.DOWN);
            if (Action.findZeroPosition(downNode.getState()) != parentZeroPos)
            {
                children.add(downNode);
            }
        }
        //up
        if (zeroPos>2)
        {
            Node upNode =new Node(Action.moveToUp(parentNode.getState()) , parentNode , Action.action.UP);
            if (Action.findZeroPosition(upNode.getState()) != parentZeroPos)
            {
                children.add(upNode);
            }
        }
        //left
        if (zeroPos%3!=0)
        {
            Node lestNode =new Node(Action.moveToLeft(parentNode.getState()) , parentNode , Action.action.LEFT);
            if (Action.findZeroPosition(lestNode.getState()) != parentZeroPos)
            {
                children.add(lestNode);
            }
        }
        //right
        if (zeroPos%3!=2)
        {
            Node rightNode =new Node(Action.moveToRight(parentNode.getState()) , parentNode , Action.action.RIGHT);
            if (Action.findZeroPosition(rightNode.getState()) != parentZeroPos)
            {
                children.add(rightNode);
            }
        }

//        System.out.println("node: " + depth(parentNode)+children.size());
//        for (int i = 0; i < children.size(); i++) {
//            System.out.print(children.get(i).getPreAction() +"  ");
//            System.out.println();
//            showPuzzle(children.get(i));
//        }
//        System.out.println();


        return children;

    }



    public Node checkFringe()
    {
        Node lowest=fringe.get(0);
        int index=0;
        for (int i = 1; i < fringe.size(); i++) {
            if (lowest.getTotalPathCost()>fringe.get(i).getTotalPathCost())
            {
                lowest=fringe.get(i);
                index=i;
            }
        }
        return lowest;
    }

    public void addToFringe(Node node)
    {
        fringe.add(node);
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

    public String savePuzzle(Node node)
    {
        String result = "";
        for (int i = 0; i < node.getState().getTiles().size(); i++) {
            result+=(node.getState().getTiles().get(i)+"   ");
            if (i==2 || i==5 || i==8)
            {
                result+="\n";
            }
        }
        return result;
    }

    public void showPuzzle(Node node)
    {
        for (int i = 0; i < node.getState().getTiles().size(); i++) {
            System.out.print(node.getState().getTiles().get(i)+" ");
            if (i==2 || i==5 || i==8)
            {
                System.out.println(" ");
            }
        }
    }

    public String savePath(Node node , String result)
    {
        if (node.getDepth()!=0)
        {
            result+=savePath(node.getParent() , result);
        }
        result+=savePuzzle(node);
        result+="\n";
        return result;
    }

    public void showPath(Node node)
    {
        if (node.getDepth()!=0)
        {
            showPath(node.getParent());
        }
        System.out.println("=========================================");
        showPuzzle(node);
        System.out.println("=========================================");
    }



    @Override
    public boolean isSolvable() {

        return Solve.isSolvable(initialNode);
    }

    @Override
    public ArrayList<Action.action> setOfActions(Node finalNode) {
        ArrayList<Action.action> actions=new ArrayList<>();
        Node temp=finalNode;
        for (int i = finalNode.getDepth(); i>0 ; i--) {
            actions.add(temp.getPreAction());
            temp=temp.getParent();
//            System.out.println("actions:");
//            showPuzzle(finalNode);
        }

        return actions;
    }

    public String saveActions(ArrayList<Action.action> actions)
    {
        String result="";
        for (int i = actions.size()-1; i>=0 ; i--) {
            switch (actions.get(i))
            {
                case NONE:
                    break;
                case UP:
                    result+="UP  ";
                    break;
                case DOWN:
                    result+="DOWN  ";
                    break;
                case LEFT:
                    result+="LEFT  ";
                    break;
                case RIGHT:
                    result+="RIGHT  ";
                    break;
            }
        }

        return result;
    }

    public void showActions(ArrayList<Action.action> actions)
    {
        System.out.println();
        for (int i = actions.size()-1; i>=0 ; i--) {
            switch (actions.get(i))
            {
                case NONE:
                    break;
                case UP:
                    System.out.print("UP  ");
                    break;
                case DOWN:
                    System.out.print("DOWN  ");
                    break;
                case LEFT:
                    System.out.print("LEFT  ");
                    break;
                case RIGHT:
                    System.out.print("RIGHT  ");
                    break;
            }
        }
        System.out.println();
    }

    @Override
    public int totalCost(Node finalNode) {
        return finalNode.getTotalPathCost();
    }

    @Override
    public int numberOfExpandedNodes() {
        return visitedNodes.size();
    }

    @Override
    public int depth(Node finalNode) {
        return finalNode.getDepth();
    }
}
