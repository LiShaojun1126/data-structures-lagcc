package com.mac286.heaps;

import com.mac286.Queue.OurQueue;
import com.mac286.stacks.OurStack;

public class HeapTester {
    public static void main(String[] args) {
        OurHeap<Integer> h = new OurHeap<>();
//        h.add(6);
//        h.add(16);
//        h.add(20);
//        h.add(8);
//        h.add(9);
//        h.add(11);
//        h.add(14);
//        System.out.println(h);
//        h.add(3);
//
//        System.out.println(h);
//        System.out.println("polling: " + h.poll());
//        System.out.println(h);
//        System.out.println("polling: " + h.poll());
//        System.out.println("polling: " + h.poll());
//        System.out.println(h);
//        System.out.println("polling: " + h.poll());
//        System.out.println("polling: " + h.poll());
//        System.out.println("polling: " + h.poll());
//        System.out.println("polling: " + h.poll());
//        System.out.println("polling: " + h.poll());
//        System.out.println(h);

        OurStack<Integer> S = new OurStack<>();
        OurQueue<Integer> Q = new OurQueue<>();
        h.add(13);
        h.add(10);
        h.add(12);
        h.add(7);
        h.add(8);
        h.add(9);
        h.add(4);

        h.add(16);
        h.add(6);
        h.add(2);
        System.out.println(h);
        while(!h.isEmpty()){
            S.push(h.poll());
        }
        while(!S.isEmpty()){
            Q.add(S.pop());
        }
        System.out.println(Q);


    }
}
