package com.mac286.stacks;

import java.util.Stack;

public class PracticeStack {
    public static void main(String[] args) {
        //Solve the same practice problem as vector using two stacks for help

        //define an array of 8 doubles
        double[] A = {-1, -3, 4, 4.5, 6, -3.2, 5, -1.2};
        OurStack<Double> S1 = new OurStack<>();
        OurStack<Double> S2 = new OurStack<>();
        //reorganize the array in a way negative numbers on the right
        //and positive numbers on the left, while keeping the order in which they were

        for(int i =0; i < A.length; i ++)
        {
            if(A[i] < 0) S1.push(A[i]);
            else S2.push(A[i]);
        }
        int index = A.length - 1;
        while(!S1.isEmpty())
        {
            A[index] = S2.pop();
            index --;
        }

        while(!S2.isEmpty())
        {
            A[index] = S1.pop();
            index --;
        }


        System.out.println(A);
    }
}

// If you want to challenge yourself, use only one stack
