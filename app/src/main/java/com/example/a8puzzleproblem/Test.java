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
//        integers.add(3);
//        integers.add(1);
//        integers.add(2);
//        integers.add(6);
//        integers.add(4);
//        integers.add(5);
//        integers.add(7);
//        integers.add(8);
//        integers.add(0);


//        Node startNode=new Node(new State(integers) , 0 ,0 ,0 ,null );
//


        System.out.println("**********************************");

        ArrayList<Integer> integers2=new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(5);
        integers.add(0);
        integers.add(3);
        integers.add(4);
        integers.add(6);
        integers.add(7);
        integers.add(8);
        Node startNode=new Node(new State(integers) , 0 ,0 ,0 ,null );

//        integers2.add(3);
//        integers2.add(1);
//        integers2.add(2);
//        integers2.add(0);
//        integers2.add(4);
//        integers2.add(5);
//        integers2.add(6);
//        integers2.add(7);
//        integers2.add(8);
//        IterativeDeepeningSearch iterativeDeepeningSearch=new IterativeDeepeningSearch(startNode);
//        iterativeDeepeningSearch.search();

//        AStarSearch aStarSearch=new AStarSearch(startNode);
//        aStarSearch.search(2);

//
//        System.out.println(RandomNumbers.randomPuzzle());
        UniformCostSearch uniformCostSearch=new UniformCostSearch(startNode);
        uniformCostSearch.search();


    }
}
