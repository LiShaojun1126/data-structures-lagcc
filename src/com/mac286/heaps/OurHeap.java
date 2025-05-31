package com.mac286.heaps;

import com.mac286.Queue.OurQueue;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class OurHeap <T extends Comparable<T>>{

    private T[] H;
    private int size;

    public OurHeap(){
        H = (T[]) new Comparable[10];
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void add(T e){
        //add e at index size
        H[size] = e;
        //heapify size
        heapify(size);
        //increment size

        size ++;
    }

    public void heapify(int ind){
    int parent = (ind - 1) / 2;

    if(H[parent] == null) return;

    if(H[ind].compareTo(H[parent]) >= 0) return;

    else { //swap element at ind with element at parent
        T save = H[ind];
        H[ind] = H[parent];
        H[parent] = save;
        heapify(parent);
    }
    }


    public T poll(){
        if(isEmpty()) throw new NoSuchElementException();

        T save = H[0];

        H[0] = H[size - 1];  //swap the first and the last!!s

        size --;

        rehepify(0);

        return save;
    }


    public void rehepify(int ind){
        //if no left child return;
        if(ind * 2 + 1 > size - 1) { //size - 1 is the index of the last
            return;
        }
        //find index of smallest child
        int smallest = smallestInd(ind);

        //smallest > H[ind] return;
        if(H[smallest].compareTo(H[ind]) >= 0) {
            return;
        }
        //swap H[smallest] with H[ind]
        T temp = H[smallest];
        H[smallest] = H[ind];
        H[ind] = temp;

        //Reheapify(smallest)
        rehepify(smallest);
    }

    private int smallestInd(int ind){
        if(H[ind * 2 + 1] != null && H[ind * 2 + 2] != null && H[ind * 2 + 1].compareTo(H[ind * 2 + 2]) >= 0) return ind * 2 + 2;
        else if (H[ind * 2 + 1] != null && H[ind * 2 + 2] != null && H[ind * 2 + 1].compareTo(H[ind * 2 + 2]) <= 0) {
             return ind * 2 + 1;
        }

        else if(H[ind * 2 + 2] == null && H[ind * 2 + 1] != null) return ind * 2 + 1;
        else throw new NoSuchElementException();
    }

    @Override
    public String toString(){
        if(this.isEmpty())
            return "[]";
        String st = "[" + H[0];
        for(int i =1; i < size; i++){
            st += ", " + H[i];
        }
        st += "]";
        return st;
    }
}
