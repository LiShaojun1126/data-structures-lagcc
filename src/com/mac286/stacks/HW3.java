package com.mac286.stacks;

import java.util.Scanner;

public class HW3 {

    public static void main(String[] args) {
        //write a program that creates a stack and reads 10 numbers from the user into the stack

        //Once all the numbers are in the stack, Use an additional stack to find the smallest and largest number in the stack
        //in one loop

        //Very challenging problem:
        // With the help of one stack only, reorganize the content of the original stack
        //so that all negative numbers go to the bottom and all positive numbers on the top of the stack,
        //order does not matter. Use as many loops as you can
        OurStack<Double> origin = new OurStack<>();
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            origin.push(sc.nextDouble());
        }

        System.out.println("Original stack: " + origin);

        OurStack<Double> small= new OurStack<>();

        double init = origin.peek();
        double topOfOrigin = init;  // to deal with the problem that the top of the original stack is the biggest

        double bigger = 0, largest = bigger;
        int countBig = 0;


        for (int i = 0; i < 10; i++) {

            if (origin.peek() <= init) {
                small.push(origin.peek());
                init = origin.pop();  // put every number smaller than top to the other stack
            }

            else {
                bigger = origin.pop(); //collect the closest bigger number to the top
                countBig ++;  //use countBig to judge if top is the largest number
                if (bigger >= largest) largest = bigger; //collect the largest number
            }

        }

        System.out.println("The smallest number is: " + small.pop());

        if(countBig == 0) largest = topOfOrigin;
        System.out.println("The largest number is " + largest);
    }
}
