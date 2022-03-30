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
}
