package com.mac286.Queue;

import com.mac286.stacks.OurStack;

import java.util.Scanner;
import java.util.Stack;

public class HW6 {
    /*assume you have a stack of 10 integers(read them from the user)
    Write code so that the stack is reorganized in a way all negative numbers are
    in the bottom of the stack and all positive numbers are on the top, while respecting the original order in which
    negative/positive numbers were. Solve the problem using One additional stack adn one additional queue as help/
    Then solve the problem using one single queue as help (hint: if you remove a item from a queue and add it, it
    will be removed from the front and put it in the back of the queue
    */
    public static void main(String[] args) {
        OurStack<Integer> stack = new OurStack<>();
        OurStack<Integer> stack2 = new OurStack<>();
        OurStack<Integer> helpStack = new OurStack<>();
        OurQueue<Integer> helpQueue = new OurQueue<>();

        Scanner scanner = new Scanner(System.in);

        for(int i = 0; i < 10; i ++){
            stack.push(scanner.nextInt());
        }

        //System.out.println(stack);
        while(!stack.isEmpty()){
            if(stack.peek() < 0) helpStack.push(stack.pop());
            else helpQueue.add(stack.pop());
        }
//        System.out.println(helpStack);
//        System.out.println(helpQueue);

        while(!helpStack.isEmpty()) stack.push(helpStack.pop());
        while(!helpQueue.isEmpty()) helpStack.push(helpQueue.remove());
        while(!helpStack.isEmpty()) stack.push(helpStack.pop());
        System.out.println(stack);

        for(int i = 0; i < 10; i ++){
            stack2.push(scanner.nextInt());
        }
        while(!stack.isEmpty()){
            helpQueue.add(stack2.pop());
        }
        int queueLength = helpQueue.size();
        for(int i = 0; i < queueLength; i ++){
            if(helpQueue.peek() < 0) stack2.push(helpQueue.remove());
            else helpQueue.add(helpQueue.remove());
        }

        stack2.push(helpQueue.remove());
        System.out.println(stack2);
    }


}
