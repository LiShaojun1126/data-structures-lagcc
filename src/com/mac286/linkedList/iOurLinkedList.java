package com.mac286.linkedList;

public interface iOurLinkedList <T>{
    void push(T e);

    void pop();

    boolean isEmpty();

    int size();

    T peek();
}
