package com.mac286.Queue;

import java.util.Arrays;
import java.util.NoSuchElementException;
// anything in interface must be public
public interface iOurQueue <T>{


        //isEmpty
        boolean isEmpty();

        //size()
        int size();

        //void add(T e)
        void add(T e);
        //T remove()

        T remove();
        //T peek
        T peek();

        String toString();


}
