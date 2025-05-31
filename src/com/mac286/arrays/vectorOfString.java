package com.mac286.arrays;

import java.util.Arrays;

public class vectorOfString{
    private String[] V;
    private int size;
    private int capacity; //You could use .length
    private int increment;

    //default constructor
    public vectorOfString(){
        //default capacity 10 increment 10
        capacity = increment = 10;
        //you cannot create an array of generics. So you create an array of
        //Object type, then you cast it into T
        V =  new String[capacity];
        size = 0;
    }
    public vectorOfString(int cap){
        //default capacity 10 increment 10
        capacity = cap;
        increment = 10;
        V = new String[capacity];
        size = 0;
    }
    public vectorOfString(int cap, int inc){
        //default capacity 10 increment 10
        capacity = cap;
        increment = inc;
        V =  new String[capacity];
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
    public void add(String e){
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
    public void add(int ind, String e) {
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
    public String remove(int ind){
        //if the array is empty or the index is not valid
        // throw an exception IndexOutOfBoundsException
        if(this.isEmpty()){
            throw new ArrayIndexOutOfBoundsException("Array empty!");
        }
        //save element at index ind.
        String save = V[ind];
        //Starting at index ind+1 up to size-1, bring every element down by 1.
        for(int i = ind+1; i < size; i++){
            V[i-1] = V[i];
        }
        //decrement size
        size--;
        //return the saved element.
        return save;
    }
    public String get(int ind){
        //if ind is not valid throw an exception
        if(ind < 0 || ind >= size) {
            throw new ArrayIndexOutOfBoundsException("Invalid index");
        }
        //return element at index ind
        return V[ind];
    }
    public String removeFirst(){
        return this.remove(0);
    }
    public String removeLast(){
        return this.remove(this.size-1);
    }
    public void addFront(String e){
        this.add(0, e);
    }
    public void addBack(String e){
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
        //go through the array and add each element to the string and a comma
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
        //go through the array and add each element to the string and a comma
        for(int i=1; i < size; i++){
                st +=  ", " + V[i];
        }
        //add ] to the string
        st += "]";
        //return the string.
        return st;
    }
     */

//    public void swapString(int ind1, int ind2)
//    {
//        String str = V[ind1];
//        V[ind1] = V[ind2];
//        V[ind2] = str;
//    }


    public static void main(String[] args)
    {
        vectorOfString V = new vectorOfString(5,10);
        V.add("Hi");
        V.add("Hello");
        V.add("Bye");
        System.out.println(V);

        V.add(2,"How");

//        V.add(1,"Bye");
//        V.remove(V.size() - 1);
        V.add(1,V.removeLast()); //in one line of code move "Bye" to the second position


        System.out.println(V);
    }


}


