package com.example.a8puzzleproblem;

import java.util.ArrayList;

public class State {

    private ArrayList<Integer> tiles;

    public State(ArrayList<Integer> tiles) {
        this.tiles = tiles;
    }

    public ArrayList<Integer> getTiles() {
        return tiles;
    }

    public void setTiles(ArrayList<Integer> tiles) {
        this.tiles = tiles;
    }

    public static boolean compareStates(State state1, State state2)
    {
        for (int i = 0; i < state1.getTiles().size(); i++) {
            if (state1.getTiles().get(i)!=state2.getTiles().get(i))
            {
                return false;
            }
        }
        return true;
    }
}
