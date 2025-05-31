package com.mac286.linkedList;

/*
Implement Stack and Queue as a wrapper around an OurLinkedList object
 */
public class wQueue <T>{
    private OurLinkedList<T> L;

    public wQueue(){
        L = new OurLinkedList<>();
    }

    public T remove(){
        return L.remove();
    }

    public void add(T e){
        L.add(e);
    }

    public int size(){
        return L.size();
    }

    public boolean isEmpty(){
        return L.isEmpty();
    }

    public String toString(){
        return L.toString();
    }

    public T peek(){
        return L.peek();
    }
}
