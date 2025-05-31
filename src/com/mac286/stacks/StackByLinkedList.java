package com.mac286.stacks;

import com.mac286.linkedList.Node;
import com.mac286.linkedList.iOurLinkedList;

public class StackByLinkedList<T> implements iOurLinkedList {
    private int size;
    private Node<T> head;

//Use head as the last element, adding to the front;

    @Override
    public void push(Object e) {
        if(isEmpty()) {
            head.setNext((Node) e);
            return;
        }
        Node<T> temp = head;
        while(temp.getNext() != null){
            temp = temp.getNext();
        }
        temp.setNext((Node) e);

    }



    @Override
    public void pop() {
        if(isEmpty()) throw new ArrayIndexOutOfBoundsException();

        Node<T> temp = head;
        while(temp.getNext().getNext() != null){
            temp = temp.getNext();
        }

        temp.setNext(null);
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object peek() {
        Node<T> temp = head;
        while(temp.getNext() != null){
            temp = temp.getNext();
        }

        return temp;
    }

    //toString
    /*
    use queue to reverse the stack

    output the string from right to left
     */
}
