package com.mac286.stacks;

import java.util.Scanner;

public class HW4 {
    public static void main(String[] args) {
        //write a program that creates a stack and reads 10 numbers from the user into the stack

        //Once all the numbers are in the stack, Use an additional stack
        //as help to reorganize the original stack so that the smallest number
        //goes to the bottom and the largest to the top, order does not matter
        //as long as all numbers are in the stack

        /*
        [6, 4, -3, 2, -1]
        //First deal with the smallest, then with the largest
        //pop one number into smallest (smallest = -1)
        //loop and pop a number (2) compare it to smallest, if smaller, then
        push smallest to the help stack and set smallest to that number
        (in this case false) else push the number into help stack
        help [2]
        pop -3, compare it to smallest = -1, it is smaller, push -1 into help
        and set smallest to -3 help: [2, -1]
        pop 4, is it smaller than smallest? no push to help: [2, -1, 4]
        pop 6, is it smaller than smallest? no, push into help [2, -1, 4, 6]

        Stack is empty.
        push smallest into stack, then as long as helpStack not empty pop
        and push into stack : [-3, 6, 4, -1, 2]
         */
        OurStack<Double> stack = new OurStack<>();
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i < 10; i ++)
        {
            stack.push(scanner.nextDouble());
        }
        OurStack<Double> helpStack = new OurStack<>();
        System.out.println(stack);

        double smallest = stack.pop();
        double a;
        while(!stack.isEmpty())
        {
            a = stack.pop();
            if (a < smallest) {
                helpStack.push(smallest);
                smallest = a;
            }
            else helpStack.push(a);
        }

        stack.push(smallest);
        while(!helpStack.isEmpty())
        {
            stack.push(helpStack.pop());
        }
        //System.out.println(stack);

        double largest = stack.pop();
        double b;
        int size = stack.size() - 1;
        for(int i = 0; i < size; i ++)
        {
            b = stack.pop();
            if(b >= largest) {
                helpStack.push(largest);
                largest = b;
            }
            else helpStack.push(b);
        }

        while(!helpStack.isEmpty())
        {
            stack.push(helpStack.pop());
        }

        stack.push(largest);
        System.out.println(stack);


        //deal with the smallest
    }
}
