package com.mac286.hashTable;

public class OurHashtable<K, T> {
    private class Node<K, T> {
        private K key;
        private T value;

        public Node(K key, T value) {
            this.key = key;
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public String toString(){
            return key + "=" + value;
        }
    }
    private Node<K, T>[] H;

    private int size;
    private float loadFactor;

    public OurHashtable(){
        H = new Node[13];
        loadFactor = 0.75f;
    }
    public OurHashtable(int cap){
        H = new Node[cap];
        loadFactor = 0.75f;
    }
    public OurHashtable(int cap, float loadFactor){
        H = new Node[cap];
        this.loadFactor = loadFactor;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int hashFunction(K k){
        return Math.abs(k.hashCode()) % H.length;
    }

//    public T get(K k){
//        //find the index for k
//        int index = hashFunction(k);  //the old method I wrote is based on that we already know the key exists, which is not accurate enough.
//        while(H[index].getKey() != k){
//            index ++;
//            if(index >= H.length) index %= H.length;
//        }
//
//
//        if(H[index] != null) return H[index].getValue();
//
//        return null;
//    }
//
//    public void put(K k, T val){
//        if(size >= H.length * loadFactor){
//            //resize
//        }
//        int index = hashFunction(k);
//        //you also need to do : if the key is already exist, we should replace the old data.
//
//        Node<K, T> n = new Node<>(k, val);
//        if(H[index] == null){
//            H[index] = n;
//            size ++;
//        }
//        else{
//            while(H[index] != null){
//                index ++;
//                if(index >= H.length) index %= H.length;
//            }
//
//            H[index] = n;
//
//            size ++;
//        }
//
//
//    }
public T get(K k){
    if(this.isEmpty()){
        return null;
    }
    //find the index for k
    int index = hashFunction(k);
    while(H[index] !=null){
        if(H[index].getKey().equals(k)){
            return H[index].getValue();
        }
        //go to the next
        index = (index+1)%H.length;
    }
    return null;
}
    public T put(K k, T val){
        if(size >= H.length*loadFactor){
            //resize
        }
        //create a node
        Node<K, T> n = new Node(k, val);
        int index = hashFunction(k);
        while(H[index] != null){
            if(H[index].getKey().equals(k)){
                //the key is there already replace and return the old
                T save = H[index].getValue();
                H[index] = n;
                return save;
            }
            index = (index+1)%H.length;
        }
        H[index] = n;
        size++;
        return null;
    }

    public T remove(K k){
        //implement the remove algorithm in slides.
        int index = hashFunction(k);
        while(H[index] != null){
            if(H[index].getKey().equals(k)){
                T save = H[index].getValue();
                H[index] = null;
                size --;
                shift(index);
                return save;
            }
            index = (index+1)%H.length;
        }
        return null;
    }

    private void shift(int i){

    }

    public String toString(){
        if(isEmpty()){
            return "{}";
        }

        //find the first item

        int i = 0;
        while(H[i] == null){
            i ++;
        }

        String st = "{" + H[i];
        int counter = 1;
        for(i = i + 1; i < H.length && counter < size; i ++){
            if(H[i] == null) continue;
            st += ", " + H[i];
            counter ++;
        }

        return st + "}";
    }
}
