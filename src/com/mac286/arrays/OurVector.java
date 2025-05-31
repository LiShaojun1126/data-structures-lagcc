package com.mac286.arrays;

public class OurVector{    //public class OurVector <T>{ generics
    private int[] V;
    private int size; //how many you add
    private int capacity; // You could use .length
    private int increment;

    //default constructor
    public OurVector()
    {
        capacity = increment = 10;

        //you can't create an array of generics.
        V = new int[capacity];
        size = 0;
    }
    public OurVector(int cap, int inc)
    {
        capacity = cap;
        increment = inc;
        V = new int[cap];
        size = 0;
    }

    //getter for size and capacity
    public int getSize()
    {
        return size;
    }

    public int getCapacity()
    {
        return capacity;
    }

    //isEmpty()
    public boolean isEmpty()
    {
        return (size == 0);
    }

    //method void add(int e) //adds a variable
    public void add(int e)
    {
        //check if the array is full, make it bigger(increase the size by increment
        if(size == capacity)
        {
            capacity += increment;
            int[] newV = new int[capacity];  // create a new array to replace old one

            for(int i = 0; i < size; i ++) newV[i] = V[i];

            V = newV;

            /*
            if (size == capacity)
            {
            V = Arrays.copyOf(V, V.length + increment);  //This one is better and safer
            capacity += increment;
            }

             */

        }

        //add e to index size
        V[size] = e;

        //increment size
        size += 1;
    }

    //add an element to a specific index
    public void add(int ind, int e)
    {
        //if the index is not valid(creates empty cell), throw an exception
        if (ind < 0 || ind > size) throw new IllegalArgumentException("This index is not valid");
        //throw new ArrayIndexOutOfBoundException("Invalid index");

        //check if the array is full, make it bigger(increase the size by increment
        if(size == capacity)
        {
            capacity += increment;
            int[] newV = new int[capacity];  // create a new array to replace old one

            for(int i = 0; i < size; i ++) newV[i] = V[i];

            V = newV;

        }

        //start form the top(size - 1) going down to index, push every element up by one
            for (int i = size - 1; i >= ind; i --)
            {
                V[i + 1] = V[i];
            }

        //add e to index ind
        V[ind] = e;

        //increment size
        size += 1;
    }

    //remove
    public int remove(int ind)
    {
        //if the array is empty or index is not valid throw an exception
        if (isEmpty() || ind < 0 || ind >= size) throw new IllegalArgumentException("This index is not valid");
        //throw new ArrayIndexOutOfBoundException("Invalid index");

        // go to index, save that index at ind
        int res = V[ind];

        //starting at index ind + 1 up to size - 1, bring every element down by one
        for(int i = ind + 1; i < size; i ++)  //always check the boundary
        {
            V[i - 1] = V[i];
        }
        //decrement size
        size -= 1;
        //return the saved element.
        return res;
    }

    public int getValue(int ind)
    {
        //if ind is not valid throw an exception
        if(ind < 0 || ind >= size) throw new IllegalArgumentException("This index is not valid");

        //return element at index ind
        return V[ind];
    }

    public String toString()
    {
        //if empty, return [];
        if(size == 0) return "[]";

        //create a string with [
        String str = "[";

        //go through the array and add each element to the string and comma
        for(int i = 0; i < size; i ++)
        {
            str += V[i];
            if(i != size - 1) str += ",";  //when accessing last number, no need to add comma
        }

        // better solution
//        for(int i = 0; i < size - 1; i ++)
//        {
//            str += V[i] + ",";
//        }
//        str += V[size - 1] + "]";   it's number + comma

        // other pattern : comma number:
        /*

         */


        //add "]" to the string
        str += "]";

        //return the string.
        return str;
    }

    // new methods

    public int removeFirst()
    {
        return this.remove(0);
    }

    public int removeLast()
    {
        return this.remove(this.size - 1);
    }

    public void addFront(int e)
    {
        this.add(0,e);
    }

    public void addBack(int e)
    {
        this.add(e);

        //or just call add
    }


    public static void main(String[] args)
    {
        OurVector V = new OurVector(5,10);
        V.add(3);
        V.add(5);
        V.add(2,6);
        V.add(1,10);
        V.add(4);
        V.add(4,10);
        V.add(5,12);

        System.out.println("V.size:" + V.getSize() + " capacity:" +V.getCapacity());
        System.out.println("V: " + V);
        System.out.println(V.getValue(6)); //test getValue

        //test remove
        System.out.println("You delete: " + V.remove(5));
        System.out.println("V: " + V);
    }
}
