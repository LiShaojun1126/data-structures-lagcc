package com.mac286.linkedList;

public class NodeTest {

    public static void main(String[] args) {

        Node<Integer> n1 = new Node<>(-3);
        Node<Integer> n2 = new Node<>(-7);
        Node<Integer> n3 = new Node<>(-5);

        n1.setNext(n3);
        n3.setNext(n2);

        //using only n1, show all n1, n2, and n3
        System.out.println(n1);
        System.out.println(n1.getNext().getNext()); //n2
        System.out.println(n1.getNext()); //n3

        //you can write the above in a more flexible way using a temporary reference
        Node<Integer> temp = n1;
        System.out.println("N1: " + n1.getmData());
        //go to the next node
        temp = temp.getNext();  //temp = n3
        System.out.println("N3: " + temp.getmData());

        //using loop while temp is not null
        temp = n1;
        while(temp != null)
        {
            System.out.println("Data: " + temp.getmData());
            //go to next
            temp = temp.getNext();
        }


        //create a node n4 with -9 value insert it between n3 and n2
        //using only n1 or temp

        Node<Integer> n4 = new Node<>(-9);

        //when you insert a new node, always change the next for the new node first, because it will not affect the list
        n4.setNext(n1.getNext().getNext()); //set next of n4 to n2
        n1.getNext().setNext(n4); //set next of n3 to n4


        temp = n1;
        while(temp != null)
        {
            System.out.println("Data: " + temp.getmData());

            temp = temp.getNext();
        }


        //create a node newNode with value -11, insert it at the end of the list
        //knowing only n1 is the head of the list
        Node<Integer> n5 = new Node<>(-11);
        System.out.println("------- After adding -11 -----------");
        temp = n1;
        while(temp.getNext() != null){
            temp = temp.getNext();
        }
        //temp now refers to the last node, set it to the new Node
        temp.setNext(n5);


        temp = n1;
        while(temp != null){
            System.out.println("Data: " + temp.getmData());
            temp = temp.getNext();
        }

        //create a new node n6 with value -13, make it to the front
        //knowing only n1 the head of the list
        Node<Integer> n6 = new Node<>(-13);
        System.out.println("------- After adding -13 -----------");
        n6.setNext(n1);
        temp = n6;
        while(temp != null){
            System.out.println("Data: " + temp.getmData());
            temp = temp.getNext();
        }

        Node<Integer> Head = n6;
        temp = Head;
        while(temp.getNext() != null){
            temp = temp.getNext();
        }
        Node<Integer> Tail = temp;

        //How to delete the first and last
        System.out.println("------- After removing the head and tail -----------");

        int saveHead, saveTail;
        //delete the head
        saveHead = Head.getmData();
        Head = Head.getNext();

        //delete the tail
        temp = Head;
        while(temp.getNext().getNext() != null){  //go to the one before last

            temp = temp.getNext();
        }

        saveTail = temp.getNext().getmData();
        temp.setNext(null);  //cut the next

        temp = Head;
        while(temp != null){
            System.out.println("Data: " + temp.getmData());
            temp = temp.getNext();
        }
        System.out.println("Original head: " + saveHead + " Original tail: " + saveTail);

    }
}
