package com.mac286.arrays;

import java.util.Vector;

/*
A vector in java is a class that has an array within (wraps an array)
It provides methods to add elements to the array or remove and access elements of the array.
 */
public class introVector {
    public static void main(String[] args)
    {
        //To create a vector. You have to specify what type of data you are saving
        Vector<Integer> V  =  new Vector<Integer>(5,10);
        //The first argument i the initial capacity, the second is the increment.
        //the increment is the amount by which vector grows each time it's full
        //To add and element to the vector, we add method
        V.add(-3);
        V.add(-5); //every time you add one ,size increase 1
        System.out.println("V.size:" + V.size() + " capacity:" +V.capacity());
        System.out.println("V: " + V);
        V.add(1,-9);//add works as insert,push up
        System.out.println("V.size:" + V.size() + " capacity:" +V.capacity());
        System.out.println("V: " + V);
        //V.add(4,-11); // You cannot have empty cells. Adding a value at index 4 will make index 3 empty
        //That's not allowed. You will have an exception:ArrayIndexOutOfBoundsException
        //exception will be triggered here
        //System.out.println("V.size:" + V.size() + " capacity:" +V.capacity());
        //System.out.println("V: " + V);
        V.add(0, -11);
        V.add(-13); //add to the back
        System.out.println("V.size:" + V.size() + " capacity:" +V.capacity());
        System.out.println("V: " + V);

        V.add(3,-17); //capacity increase by 10 once you pass the initial capacity
        System.out.println("V.size:" + V.size() + " capacity:" +V.capacity());
        System.out.println("V: " + V);

        System.out.println("The value at index 5 is: " + V.get(5)); //output specific value

        System.out.println("removing element at 2:" + V.remove(2)); //remove at index
        System.out.println("V.size:" + V.size() + " capacity:" +V.capacity());
        System.out.println("V: " + V);






    }
}
