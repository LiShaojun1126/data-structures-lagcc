package com.mac286.Queue;

import java.util.NoSuchElementException;

public class CircularQueue <T>{
    T[] Q;
    private int size;
    private int first, last;

    public CircularQueue()
    {
        Q = (T[]) new Object[5];
        size = 0;
        first = last = -1;
    }

    public boolean isEmpty(){
        return (size == 0);
    }

    public int size()
    {
        return size;
    }

    public void add(T e){
        //if full resize *important
        if(size == Q.length)
        {
            //create a bigger array
            T[] temp = (T[]) new Object[Q.length * 2];
            //copy Q into temp, first goes to index 0 and so on,
            //first + i goes to index i
            for(int i = 0; i < size; i ++)
            {
                temp[i] = Q[(first + i) % Q.length];
            }

            //reset first and last;
            first = 0;
            last = size - 1;
            //rename temp as Q
            Q = temp;

        }

        if (this.isEmpty())
        {
            //add e at index 0
            Q[0] = e;
            //set first and last to 0
            first = last = 0;
            // set size to 1 and return
            size = 1;
        }
        else{
            //increase last by 1 and take modulo A.length
            last = (last + 1) % Q.length;
            //add e at index last
            Q[last] = e;
            //increment size
            size ++;
        }


    }

    public T remove(){
        //if empty, throw exception
        if(this.isEmpty()) throw new NoSuchElementException();

        //save the first element at index first
        T var = Q[first];

        //increase first by 1 and take modulo A.length
        first = (first + 1) % Q.length;
        //decrement size
        size --;
        //return the saved

        return var;
    }

    public T peek()
    {
        //if empty throw exception, or return null
        if(this.isEmpty()) return null;
        //return
        return Q[first];
    }

    public String toString()
    {
        //needs to be modified, because the first is not always at index 0

        //You have to loop size times but starting at first and going to last
        //and there may be a loop back to index 0 (always take the modulo A.length)


        if(this.isEmpty()) return "[]";

        String str = "[" + Q[first];

        for(int i = 1; i < size; i ++)
        {
            str += "," + Q[(first + i) % Q.length];
        }

        str += "]";
        return str;
    }

    public static void main(String[] args) {
        CircularQueue<Integer> Q = new CircularQueue<>();
        Q.add(-1);
        Q.add(-3);
        System.out.println("Q.size: " + Q.size() + " Q: " + Q);
        Q.add(-7);
        System.out.println("The front is: " + Q.peek());
        System.out.println("Q: " + Q);

//        int var = Q.remove();
//        System.out.println("Removed: " + var);
//        System.out.println("Q: " + Q);

        Q.add(-9);
        Q.add(-11);

        System.out.println("Q: " + Q);
//        Q.remove();
//        System.out.println(Q);
        Q.remove();
        Q.add(-13);
        System.out.println(Q);
        Q.add(-15);
        System.out.println(Q);


    }
}
