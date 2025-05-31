package com.mac286.stacks;
/*
A stack is a data structure in which if you add something to it(we call it push) it goes to the top
And when you remove an item(pop), the top is removed and returned.
The interface of the stack is the following:
-onlyDefaultConstructor
-isEmpty()  return true or false if stack empty and false if not
-size() returns the size of the stack
-push(T e) adds e to the top of the stack
-T pop() removes teh top and returns it
-T peek() returns the top without removing it
-toString of course
 */

import java.sql.SQLOutput;
import java.util.Stack;

public class IntroStacks {
    public static void main(String[] args){
        Stack<Integer> S = new Stack<>();

        //To add element, we use push
        S.push(-1);
        S.push(-3);
        System.out.println("S.size: " + S.size() + "S" + S);
        S.push(-5);

        int var = S.pop();
        System.out.println("var: " + var);
        System.out.println("S.size: " + S.size() + "S" + S);
    }
}
