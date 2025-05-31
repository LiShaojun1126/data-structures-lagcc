package com.mac286.Queue;

import javax.imageio.plugins.tiff.TIFFTagSet;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class OurQueue <T>{
    private T[] Q;
    private int size;

    //default constructor
    public OurQueue()
    {
        size = 0;
        Q = (T[]) new Object[5];
    }

    //isEmpty
    public boolean isEmpty(){
        return (size == 0);
    }

    //size()
    public int size(){
        return size;
    }

    //void add(T e)
    public void add(T e)
    {
        if(size == Q.length)
        {
            Q = Arrays.copyOf(Q,Q.length * 2);
        }
        Q[size] = e;
        size ++;  // or Q[size ++] = e; post-increment
    }
    //T remove()

    public T remove(){
        if(this.isEmpty()) throw new NoSuchElementException();

        T var = Q[0];

        for(int i = 1; i < size; i ++)
        {
            Q[i - 1] = Q[i];
        }

        size --;

        return var;
    }

    //T peek
    public T peek(){
        if(this.isEmpty()) throw new NoSuchElementException();

        return Q[0];
    }
    //toString
    public String toString()
    {
        if(this.isEmpty()) return "[]";

        String str = "[";
        for(int i = 0; i < size - 1; i ++)
        {
            str += Q[i] + ", ";
        }

        str += Q[size - 1] + "]";

        return str;
    }

    public static void main(String[] args) {
        OurQueue<Integer> Q = new OurQueue<>();

        Q.add(-1);
        Q.add(-3);
        System.out.println("Q.size: " + Q.size() + " Q: " + Q);
        Q.add(-7);
        System.out.println("The front is: " + Q.peek());
        System.out.println("Q: " + Q);

        int var = Q.remove();
        System.out.println("Removed: " + var);
        System.out.println("Q.size: " + Q.size() + " Q: " + Q);
    }
}
