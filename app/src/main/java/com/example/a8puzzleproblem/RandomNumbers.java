package com.example.a8puzzleproblem;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class RandomNumbers {

//    public static int getRandomNumber(int min, int max) {
//        return (int) ((Math.random() * (max - min)) + min);
//    }

//    public static ArrayList<Integer> randomPuzzle()
//    {
//        ArrayList<Integer> numbers=new ArrayList<>();
//
//        while (numbers.size()<9)
//        {
//            boolean flag=true;
//            int random=getRandomNumber(0 , 8);
//            for (int i = 0; i < numbers.size(); i++) {
//                if (random==numbers.get(i))
//                {
//                    flag=false;
//                    break;
//                }
//            }
//            if (flag)
//            {
//                numbers.add(random);
//            }
//        }
//
//        return numbers;
//
//    }

    public static ArrayList<Integer> randomPuzzle()
    {
        ArrayList<Integer> numbers=new ArrayList<>();
        numbers.add(0);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        numbers.add(7);
        numbers.add(8);

        Collections.shuffle(numbers);

        return numbers;
    }


}
