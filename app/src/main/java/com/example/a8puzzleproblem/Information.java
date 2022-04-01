package com.example.a8puzzleproblem;

import java.util.ArrayList;

public interface Information {
    boolean isSolvable();
    ArrayList<Action.action> setOfActions(Node finalNode);
    int totalCost(Node finalNode);
    int numberOfExpandedNodes();
    int depth(Node finalNode);
}
