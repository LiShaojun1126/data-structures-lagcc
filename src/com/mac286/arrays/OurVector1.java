package com.mac286.arrays;

import java.util.Arrays;

public class OurVector1 <T>{
    private T[] V;
    private int size;
    private int capacity; //You could use .length
    private int increment;

    //default constructor
    public OurVector1(){
        //default capacity 10 increment 10
        capacity = increment = 10;
        //you cannot create an array of generics. So you create an array of
        //Object type, then you cast it into T
        V = (T[]) new Object[capacity];
        size = 0;
    }
    public OurVector1(int cap){
        //default capacity 10 increment 10
        capacity = cap;
        increment = 10;
        V = (T[]) new Object[capacity];
        size = 0;
    }
    public OurVector1(int cap, int inc){
        //default capacity 10 increment 10
        capacity = cap;
        increment = inc;
        V = (T[]) new Object[capacity];
        size = 0;
    }
    //getters for size and capacity

    //isEmpty()
    public boolean isEmpty(){
        return (size == 0);
    }
    public int size(){
        return size;
    }
    public int capacity(){
        return capacity;
    }

    //method void add(int e) //adds e to the back of the vector.
    public void add(T e){
        //check if the array if full, make it bigger (increase the capacity by increment)
        if(size == capacity){
            V = Arrays.copyOf(V, V.length + increment);
            capacity += increment;
        }
        //add e to index size
        V[size] = e;
        //increment size
        size++;
    }
    //add an element to a specific index.
    public void add(int ind, T e) {
        //if the index is not valid, (creates empty cells), throw an exception
        if(ind < 0 || ind > size){
            throw new ArrayIndexOutOfBoundsException("Invalid index");
        }
        //check if array is full increase capacity by increment
        if(size == capacity){
            V = Arrays.copyOf(V, V.length + increment);
            capacity += increment;
        }
        //start from the top (size-1) going down to index ind, push every element
        //up by one.
        for(int i = size-1; i >= ind; i--){
            V[i+1] = V[i];
        }
        //add e to index ind
        V[ind] = e;
        //increment size
        size++;
    }

    //remove
    public T remove(int ind){
        //if the array is empty or the index is not valid
        // throw an exception IndexOutOfBoundsException
        if(this.isEmpty()){
            throw new ArrayIndexOutOfBoundsException("Array empty!");
        }
        //save element at index ind.
        T save = V[ind];
        //Starting at index ind+1 up to size-1, bring every element down by 1.
        for(int i = ind+1; i < size; i++){
            V[i-1] = V[i];
        }
        //decrement size
        size--;
        //return the saved element.
        return save;
    }
    public T get(int ind){
        //if ind is not valid throw an exception
        if(ind < 0 || ind >= size) {
            throw new ArrayIndexOutOfBoundsException("Invlid index");
        }
        //return element at index ind
        return V[ind];
    }
    public T removeFirst(){
        return this.remove(0);
    }
    public T removeLast(){
        return this.remove(this.size-1);
    }
    public void addFront(T e){
        this.add(0, e);
    }
    public void addBack(T e){
        this.add(this.size, e);
        //or just call add
        //this.add(e);
    }
    public String toString(){
        //if empty return "[]"
        if(this.isEmpty()){
            return "[]";
        }
        //create a string with [
        String st = "[";
        //go throuhg the array and add each element to the string and a comma
        for(int i=0; i < size-1; i++){
            st += V[i] + ", ";
        }
        //add ] to the string
        st += V[size-1] + "]";
        //return the string.
        return st;
    }
    /*
     public String toString(){
        //if empty return "[]"
        if(this.isEmpty()){
            return "[]";
        }
        //create a string with [
        String st = "[" + V[0];
        //go throuhg the array and add each element to the string and a comma
        for(int i=1; i < size; i++){
                st +=  ", " + V[i];
        }
        //add ] to the string
        st += "]";
        //return the string.
        return st;
    }
     */
}