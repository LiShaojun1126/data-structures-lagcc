package com.mac286.linkedList;

public class Node <T>{
    private T mData;
    private Node<T> next; //reference


    //constructor
    public Node() {
        mData = null;
        next = null;
    }

    public Node(T val){
        mData = val;
        next = null;
    }

    public Node(T val, Node n){
        mData = val;
        next = n;
    }

    //getter and setter
    public T getmData() {
        return this.mData;
    }
    public Node<T> getNext(){
        return next;
    }

    public void setmData(T val) {
        this.mData = val;
    }
    public void setNext(Node n)
    {
        this.next = n;
    }

    //toString
    public String toString() {
        return mData.toString();
    }

}
