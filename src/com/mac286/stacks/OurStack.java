package com.mac286.stacks;

import java.util.Arrays;
import java.util.EmptyStackException;

public class OurStack<T>{
    private T[] S;
    private int size;

    //defaultConstructor
    public OurStack()
    {
        size = 0;

        S = (T[]) new Object[10];
    }

//    public OurStack(int cap, int inc)
//    {
//        size = 0;
//        capacity = cap;
//        increment = inc;
//        S = (T[]) new Object[10];
//    }


    //getter for size
    public int size()
    {
        return size;
    }
    // isEmpty
    public boolean isEmpty()
    {
        return (size == 0);
    }


    //push
    public void push(T e)
    {
        //if array is full, make it bigger as you wish
        if (size == S.length)
        {
            S = Arrays.copyOf(S, S.length * 2);

        }
        // add e to index size
        S[size] = e;
        //increase the size
        size ++;
    }


    //pop removes the top and returns it
    public  T pop()
    {
        //if empty throw EmptyStackException
        if(isEmpty()) throw new EmptyStackException();
        //save the top
        T top = S[size - 1];
        //decrease size
        size --;
        // return the saved
        return top;
    }
    //peek returns the top but not removing it
    public T peek()
    {
        //if empty throw EmptyStackException
        if(isEmpty()) throw new EmptyStackException();

        //return the top
        return S[size - 1];
    }


    public String toString(){
        //if empty return "[]"
        if(this.isEmpty()){
            return "[]";
        }
        //create a string with [
        String str = "[";
        //go through the array and add each element to the string and a comma
        for(int i=0; i < size-1; i++){
            str += S[i] + ", ";
        }
        //add ] to the string
        str += S[size-1] + "]";
        //return the string.
        return str;
    }

    public static void main(String[] args)  //test OurStack
    {
        OurStack<Integer> S = new OurStack<>();

        S.push(-1);
        S.push(-3);
        System.out.println("S.size: " + S.size() + " S" + S);
        S.push(-5);
        System.out.println("S.size: " + S.size() + " S" + S);
        int var = S.pop();
        System.out.println("var: " + var);
        System.out.println("S.size: " + S.size() + " S" + S);

    }

}
