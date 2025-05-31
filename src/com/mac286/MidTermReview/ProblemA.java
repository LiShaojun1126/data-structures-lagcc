package com.mac286.MidTermReview;

import com.mac286.stacks.OurStack;

import java.util.Random;

public class ProblemA {
    public static void main(String[] args) {
        OurStack<Integer> S = new OurStack<>();

        Random rand = new Random();

        for(int i = 0; i < 20; i ++){
            int randNumber = rand.nextInt(-200,200);
            S.push(randNumber);
        }

        System.out.println("Original stack: " + S);

        OurStack<Integer> negativeStack = new OurStack<>();
        OurStack<Integer> positiveStack = new OurStack<>();
        while(!S.isEmpty()){
            if(S.peek() > 0) positiveStack.push(S.pop());
            else negativeStack.push(S.pop());
        }

        System.out.println("Positive Stack: " + positiveStack);
        System.out.println("Negative Stack: " + negativeStack);

        int len = Math.min(positiveStack.size(), negativeStack.size());  //This method we don't need to care if their size are equal

        for(int i = 0; i < len; i ++){
            S.push(positiveStack.pop());
            S.push(negativeStack.pop());
        }

        while(!positiveStack.isEmpty()){
            S.push(positiveStack.pop());
        }

        while(!negativeStack.isEmpty()){
            S.push(negativeStack.pop());
        }

        System.out.println("Final result: " + S );
    }
}
