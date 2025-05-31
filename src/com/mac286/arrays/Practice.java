package com.mac286.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Practice {
    public static void main(String[] args)
    {
        //Define an array of 10 doubles
        Double[] ar = new Double[10];
        //Read values from the user
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 10; i ++)
        {
            ar[i] = sc.nextDouble();
        }

        OurVector1<Double> vec = new OurVector1<>();
        int cnt = 0;  //I try to not use 2 for loop to finish this problem
        //This cnt is like size in vector, but only for negative numbers, how many negative you've stored

        for(int i = 0; i < ar.length; i ++)  //size == i + 1
        {

            if (ar[i] <= 0) {
                vec.add(cnt, ar[i]);
                cnt ++;
            }
            else vec.addBack(ar[i]);

        }

        //Using OurVector Object as help, sort the array in a way positive numbers are one side of the array
        //and negative numbers on the other
        //Example [-1, -3, 4, 4.5, 6, -3.2, 5, -1.2]
        //result [-1, -3, -3.2, -1.2, 4, 4.5, 6, 5]

        //Display the array

        System.out.println("Vec: " + vec);
    }
}
