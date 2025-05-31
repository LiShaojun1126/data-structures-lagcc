package com.mac286.Queue;

import java.util.LinkedList;
import java.util.Queue;

/*
A queue is data structure in which when you add element it goes to the back and when remove the first is removed from the queue.
Like teh queue in the post office, first in first out

In Java, the queue is implemented as an interface not a class, you cannot make and object out of it.
You need and implementing class to create and object.
 */
public class introQueue {
    public static void main(String[] args) {
        Queue<Integer> Q = new LinkedList<Integer>();

        Q.add(-1);
        Q.add(-3);
        System.out.println("Q.size: " + Q.size() + "Q: " + Q);
        Q.add(-7);
        System.out.println("The front is: " + Q.peek());
        System.out.println("Q: " + Q);

        int var = Q.remove();
        System.out.println("Removed: " + var);
        System.out.println("Q: " + Q);

    }

}
