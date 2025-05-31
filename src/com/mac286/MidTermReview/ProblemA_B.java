package com.mac286.MidTermReview;

import com.mac286.stacks.OurStack;

import java.util.Random;

public class ProblemA_B {
    public static void main(String[] args) {
        OurStack<Integer> S = new OurStack<>();

        Random rand = new Random();

        for(int i = 0; i < 20; i ++){
            int randNumber = rand.nextInt(-200,200);
            S.push(randNumber);
        }

        System.out.println("Original stack: " + S);

        int positive = 0, negative = 0;

        OurList<Integer> L = new OurList<>();

        while(!S.isEmpty()){
            if(S.peek() > 0) {
                L.insertBack(S.pop());
                positive ++;
            }
            else {
                L.insertFront(S.pop());
                negative ++;
            }
        }

        System.out.println(L);

        int len = Math.min(positive, negative);

        for(int i = 0; i < len; i ++){
            S.push(L.removeBack());
            S.push(L.removeFront());
        }

        while(!L.isEmpty()){
            if(positive > negative){
                S.push(L.removeBack());
            }
            else S.push(L.removeFront());
        }

        System.out.println(S);

    }
}
