package com.mac286.linkedList;

public class OurLinkedListTest {
    public static void main(String[] args) {
        OurLinkedList<String> list = new OurLinkedList<>();

        list.add("Hello");
        list.add("How");
        System.out.println(list);
        list.add(2,"are");
        System.out.println(list);
    }
}
