package com.mac286.hashTable;

import java.util.Hashtable;

//hash table in java
public class hashTableTester {
    public static void main(String[] args) {
//        Hashtable<String, String> H = new Hashtable<>(10,0.7f) ; //initial capacity, load factor
//        //because it's to complex to rehash the hash table when it is full, the load factor is for how percent full the table should
//        //before resizing (making it bigger) because it is time-consuming.
//
//        H.put("086-88-4001", "John");
//        H.put("011-38-4010","Moe");
//        H.put("012-45-4020","David");
//        H.put("321-28-4010","Mary");
//        System.out.println(H);

        OurHashtable<Integer, String> H1 = new OurHashtable<>(13,0.7f);
        H1.put(18,"18");
        H1.put(41,"41");
        H1.put(22,"22");
        H1.put(44,"44");
        H1.put(59,"59");
        H1.put(32,"32");
        H1.put(31,"31");
        H1.put(73,"73");
        System.out.println(H1);

    }
}
