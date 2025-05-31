package com.mac286.linkedList;

public class wStack <T>{
    private OurLinkedList<T> L;

    public wStack(){
        L = new OurLinkedList<>();
    }

    public boolean isEmpty(){
        return L.isEmpty();
    }
    public int size(){
        return L.size();
    }

    public void push(T e){
        L.add(e);
    }

    public T pop(){
        return L.remove(this.size() - 1);
    }

    public T peek(){
        return L.peek();
    }

    public String toString(){
        return L.toString();
    }
}
