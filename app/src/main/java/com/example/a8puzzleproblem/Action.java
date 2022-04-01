package com.example.a8puzzleproblem;

import java.util.ArrayList;

public class Action {

    enum action{NONE ,UP , DOWN , LEFT , RIGHT}

    public static int findZeroPosition(State state)
    {
        for (int i = 0; i < state.getTiles().size(); i++) {
            if (state.getTiles().get(i)==0)
            {
                return i;
            }
        }
        return -1;
    }
    public static void swap(int firstIndex , int secondIndex , State state)
    {
        int temp=state.getTiles().get(firstIndex);
        state.getTiles().set(firstIndex , state.getTiles().get(secondIndex));
        state.getTiles().set(secondIndex , temp);
    }

    public static State creatState(State state)
    {
        ArrayList<Integer> tiles=new ArrayList<>();
        for (int i = 0; i < state.getTiles().size(); i++) {
            tiles.add(state.getTiles().get(i));
        }

        State newState=new State(tiles);
        return newState;

    }

    public static State moveToLeft(State state)
    {
        int zeroPosition=findZeroPosition(state);

        if (zeroPosition%3==0)
        {
            //can not move to left
            return null;
        }
        else
        {
            State finalState=creatState(state);
            swap(zeroPosition , zeroPosition-1 , finalState);
            return finalState;
        }
    }

    public static State moveToRight(State state)
    {
        int zeroPosition=findZeroPosition(state);

        if (zeroPosition%3==2)
        {
            //can not move to right
            return null;
        }
        else
        {
            State finalState=creatState(state);
            swap(zeroPosition , zeroPosition+1 , finalState);
            return finalState;
        }
    }
    public static State moveToUp(State state)
    {
        int zeroPosition=findZeroPosition(state);

        if (zeroPosition<3)
        {
            //can not move to up
            return null;
        }
        else
        {
            State finalState=creatState(state);
            swap(zeroPosition , zeroPosition-3 , finalState);
            return finalState;
        }
    }
    public static State moveToDown(State state)
    {
        int zeroPosition=findZeroPosition(state);

        if (zeroPosition>5)
        {
            //can not move to up
            return null;
        }
        else
        {
            State finalState=creatState(state);
            swap(zeroPosition , zeroPosition+3 , finalState);
            return finalState;
        }
    }

}
