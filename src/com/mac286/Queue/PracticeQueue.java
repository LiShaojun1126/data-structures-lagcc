package com.mac286.Queue;

import com.mac286.stacks.OurStack;

import java.util.Random;

public class PracticeQueue {

    //this method generates a stack of howMany integers randomly between -maxNum and +maxNum
    public static OurStack<Integer> generateStack(int howMany, int maxNum)
    {
        //create a stack
        OurStack<Integer> S = new OurStack<>();

        Random rand = new Random();
        //loop howMany times

        //use a random generator to generate an integer between
        //-maxNum and +maxNum
        //push it to the stack
        for(int i = 0; i < howMany; i ++)
        {
            int ranInteger = rand.nextInt(-maxNum, maxNum);
            S.push(ranInteger);

        }

        // return the stack

        return S;
    }
    public static void main(String[] args) {
        //generate a stack of 20 integers between -300 and 300
        OurStack<Integer> S = generateStack(20,300);
        System.out.println(S);
        //create two queues one for negative numbers and one for positive numbers
        OurQueue<Integer> negativeNum = new OurQueue<>();
        OurQueue<Integer> positiveNum = new OurQueue<>();


        //while the stack is not empty, empty the negative numbers into the
        //queue of negative numbers and positives into the queue of positives.
        while(!S.isEmpty())
        {
            if(S.peek() >= 0) positiveNum.add(S.pop());
            else negativeNum.add(S.pop());
        }


        System.out.println(negativeNum);
        System.out.println(positiveNum);

//        int negativeSize = negativeNum.size();
//        for(int i = 0; i < negativeSize; i ++)
//        {
//            int a = negativeNum.remove();
//            negativeNum.add(a);   //we cannot use this kind of method to revise the queue, we need to use stack to revise it.
//        }
//
//        for(int i = 0; i < positiveNum.size(); i ++)
//        {
//            positiveNum.add(positiveNum.remove());
//        }
//
//        System.out.println(negativeNum);
//        System.out.println(positiveNum);

        //empty back the negative queue into the stack
        while(!negativeNum.isEmpty())
        {
            S.push(negativeNum.remove());
        }

        while(!S.isEmpty())
        {
            negativeNum.add(S.pop());  //revise the queue to put all elements in right order
        }
        //empty back the positive queue into the stack.
        while(!positiveNum.isEmpty())
        {
            S.push(positiveNum.remove());
        }

        while(!S.isEmpty())
        {
            positiveNum.add(S.pop());
        }



        while(!negativeNum.isEmpty())  //stack every element in original order
        {
            S.push(negativeNum.remove());
        }
        while(!positiveNum.isEmpty())
        {
            S.push(positiveNum.remove());
        }
        //display the stack.
        System.out.println(S);

        //revise each queue

    }
}
