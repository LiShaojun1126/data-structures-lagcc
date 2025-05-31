package com.mac286.linkedList;

import com.mac286.Queue.iOurQueue;

import java.util.NoSuchElementException;

public class OurLinkedList <T> implements iOurQueue<T> {
    //reference to the tail and reference to the head

    private Node<T> Head, Tail;
    private int size;

    public OurLinkedList(){
        Head = Tail = null;
        size  = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }
    public void add(T e){
        //create a node with e as data
        Node<T> node = new Node<>(e);

        if(this.isEmpty()){
            Head = Tail = node;
            size = 1;
            return;
        }

        Tail.setNext(node);
        Tail = node;
        size ++;
    }

    public void add(int ind, T e){
        //check if index is valid, if not throw an exception
        if(ind < 0 || ind > size) throw new ArrayIndexOutOfBoundsException();

        //if adding at index size(back) call add
        if(ind == size) {
            add(e);
            return;
        }

        Node<T> n = new Node<>(e);
        //if adding at head(index 0) special case
        if(ind == 0) {
            n.setNext(Head);
            Head = n;
            size ++;

            return;
        }
        Node<T> temp = Head;

        for(int i = 0; i < ind - 1; i ++){
            temp = temp.getNext();
        }
        n.setNext(temp.getNext());
        temp.setNext(n);
        size ++;

    }

    //remove the head and return the date
    public T remove(){
        if(this.isEmpty()) throw new NoSuchElementException();

        T save = Head.getmData();
        Head = Head.getNext();
        size --;

        if(size == 0) {
            Head = Tail = null;
        }

        return save;
    }


    // return the data at the node at index ind
    public T get(int ind){
        if(ind < 0 || ind >= size)
        {
            throw new ArrayIndexOutOfBoundsException();
        }

        Node<T> temp = Head;
        for(int i = 0; i < ind; i ++){
            temp = temp.getNext();
        }

        return temp.getmData();
    }


    public String toString(){
        //if empty return [];

        if(isEmpty()) return "[]";

        String str = "[" + Head.getmData();

        Node<T> temp = Head.getNext();

        while(temp != null){
            str += "," + temp.getmData();
            temp = temp.getNext();
        }

        str += "]";

        return str;
    }

    //remove node at index ind and return its data. 0 is the head, size-1 is the tail
    public T remove(int ind){
        if(ind < 0 || ind >size-1){
            throw new IndexOutOfBoundsException();
        }
        if(ind == 0){
            return this.remove();
        }
        //advance temp ind-1 times
        Node<T> temp = Head;
        for(int i = 0; i < ind-1; i++){
            temp = temp.getNext();
        }
        T save = temp.getNext().getmData();
        temp.setNext(temp.getNext().getNext());
        if(ind == size-1){
            Tail = temp;
        }
        size--;
        return save;
    }

    //peek
    public T peek(){
        if(this.isEmpty()){
            return null;
        }
        return Head.getmData();
    }
}
