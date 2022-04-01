package com.example.a8puzzleproblem;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args)
    {
        System.out.println("hey");

        ArrayList<Integer> integers=new ArrayList<>();
//        integers.add(3);
//        integers.add(1);
//        integers.add(2);
//        integers.add(6);
//        integers.add(4);
//        integers.add(5);
//        integers.add(7);
//        integers.add(0);
//        integers.add(8);
        integers.add(3);
        integers.add(1);
        integers.add(2);
        integers.add(6);
        integers.add(4);
        integers.add(0);
        integers.add(7);
        integers.add(8);
        integers.add(5);


        Node startNode=new Node(new State(integers) , 0 ,0 ,0 ,null );

        UniformCostSearch uniformCostSearch=new UniformCostSearch(startNode);
        uniformCostSearch.search();


    }
}
