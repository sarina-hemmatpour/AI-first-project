package com.example.a8puzzleproblem;

import java.util.ArrayList;

public class Solve {

    public static boolean isSolvable(Node initialNode)
    {
        ArrayList<Integer> numbers=initialNode.getState().getTiles();

        int count=0;
        for (int i = 0; i < 9; i++) {
            int max=numbers.get(i);
            if (max!=0)
            {
                for (int j = 0; j < i; j++) {
                    if (max<numbers.get(j))
                    {
                        count++;
                    }
                }
            }

        }
        System.out.println(count);

        return count%2==0;


    }
}
