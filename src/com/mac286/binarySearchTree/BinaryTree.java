package com.mac286.binarySearchTree;

public class BinaryTree<K extends Comparable, T> {
    private class Node<K extends Comparable, T>{
        private K key;
        private T mData;
        private Node<K, T> left, right;

        //default constructor
        public Node(){
            key = null;
            mData = null;
        }

        public Node(K k, T data){
            key = k;
            mData = data;
            left = right = null;

        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public T getmData() {
            return mData;
        }

        public void setmData(T mData) {
            this.mData = mData;
        }

        public Node<K, T> getLeft() {
            return left;
        }

        public void setLeft(Node<K, T> left) {
            this.left = left;
        }

        public Node<K, T> getRight() {
            return right;
        }

        public void setRight(Node<K, T> right) {
            this.right = right;
        }

        @Override
        public String toString() {
            return "[" +
                     key +
                    "," + mData +
                    ']';
        }
    }

    private Node<K, T> root;

    private int size = 0;

    public boolean isEmpty(){
        return (size == 0);
    }

    public void insert(K k, T d) {
        //create a new node with k and d
        Node<K, T> n = new Node<>(k, d);
        //if tree is empty, set root to node, size to 1 and return
        if (this.isEmpty()) {
            root = n;
            size++;
            return;
        }
        //find where to insert the node and insert it
        //have a temporary reference temp starting at root
        Node<K, T> temp = root;
        while (true) {
            //if key of the node is smaller than the key at temp

            // if there is a left go to the left fo temp
            // temp = temp.getLeft(), loop again
            // if there is no left, we find the place to insert it. Insert the node at left of temp.
            // increase size by 1 and get out

            if (n.getKey().compareTo(temp.getKey()) < 0) {
                if (temp.getLeft() != null) {
                    temp = temp.getLeft();
                    continue;
                } else {
                    temp.setLeft(n);
                    size ++;
                    //temp = root;
                    return;
                }
            }

            //else the key is larger
            // if there is a right to go to the right of temp
            // temp = temp.getRight()
            // if there is no right, insert and get out.
            else {
                if (temp.getRight() != null) {
                    temp = temp.getRight();
                    continue;
                } else {
                    temp.setRight(n);
                    size ++;
                    //temp = root;
                    return;
                }
            }


        }
    }

    public void inOrder(){
        System.out.print("[");
        inOrderTraversal(root);
        System.out.println("]");

    }


    private void inOrderTraversal(Node<K, T> n){
        if(n == null) return;

        inOrderTraversal(n.getLeft());
        System.out.println(" " + n + " ");
        inOrderTraversal(n.getRight());
    }

    public void preOrder(){
        System.out.print("[");
        preOrderTraversal(root);
        System.out.println("]");

    }


    private void preOrderTraversal(Node<K, T> n){
        if(n == null) return;

        System.out.println(" " + n + " ");
        preOrderTraversal(n.getLeft());
        preOrderTraversal(n.getRight());
    }

    public void postOrder(){
        System.out.print("[");
        postOrderTraversal(root);
        System.out.println("]");
    }


    private void postOrderTraversal(Node<K, T> n){
        if(n == null) return;
        postOrderTraversal(n.getLeft());
        postOrderTraversal(n.getRight());
        System.out.println(" " + n + " ");
    }

    //find  node with key k, returns null if it does not exist
    private Node<K, T> find(K k){
        Node<K, T> temp = root;
//        if(n.getKey() == k) return n;
//        while(n.getKey() != k){
//            find(n.getLeft().getKey());
//            find(n.getRight().getKey());
//        }
//
//        if(n == root) return null;
//        else return n;

        while(temp != null){
            if (temp.getKey().compareTo(k) == 0){
                return temp;
            }
            else if(temp.getKey().compareTo(k) < 0) {
                //go to left
                temp = temp.getLeft();
            }else temp = temp.getRight();
        }

        //did not find it.
        return null;
    }

    //You can also do this recursively
    

    private Node<K, T> parentOf(K k){
        //returns the parent of the node with key, null if none
        if(root.getKey().compareTo(k) == 0) return null;

        //start at root
        Node<K, T> temp = root;
        while(temp != null){
            if(temp.getLeft() != null && k.compareTo(temp.getLeft().getKey()) == 0 || temp.getRight() != null && k.compareTo(temp.getRight().getKey()) == 0)
            return temp;


        }

        return null; //noting found
    }

    //returns reference to the smallest node on the right
    private Node<K, T> smallestOnRight(Node<K, T> n){
        if(n.getRight() == null) {
            return null;
        }
        Node<K, T> temp = n.getRight();
        while(temp.getLeft() != null){
            temp = temp.getLeft();
        }

        return temp;
    }

    //returns re
//    private Node<K, T> largestOnLeft(Node<K, T> n){
//        if(n.getLeft() == null) {
//            return null;
//        }
//        Node<K, T> temp = n.getLeft();
//        while(temp.getRight() != null){
//            temp = temp.getRight();
//        }
//
//        return temp;
//    }
//
//    public T delete(K k){
//        //find the node to delete nodeToDelete
//        Node<K, T> nodeToDelete = find(k);
//        //if null, it does not exist get out
//        if (nodeToDelete == null) {
//            System.out.println("The key does not exist.");
//            return null;
//        }
//        // if it's the root and there is only on node, then, save data, set root to null, size to 0 and return the data
//        if(nodeToDelete == root && size == 1){
//            T save = nodeToDelete.getmData();
//            root = null;
//            size = 0;
//        }
//        //if no left and right of noToDelete(it's a leaf)
//            //find the parent of nodeToDelete
//            //if the parent is connected through left, then prune the left
//        if(nodeToDelete.getRight() == null && nodeToDelete.getLeft() == null){
//            Node<K, T> parentOfNodeToDelete = parentOf(k);
//            if(parentOfNodeToDelete == null) {
//                System.out.println("Something is wrong. The parent does not exist.");
//                System.exit(1);
//            }
//
//            T save = parentOfNodeToDelete.getmData();
//
//            if(parentOfNodeToDelete.getLeft() != null && parentOfNodeToDelete.getLeft().getKey().compareTo(k) == 0) {
//               parentOfNodeToDelete.setLeft(null);
//            }else {
//                parentOfNodeToDelete.setRight(null);
//            }
//
//            size --;
//            return save;
//        }
//
//
//        //if nodeToDelete has left, then, find the largest on the left of nodeToDelete, call it replacement.
//            //find parent of replacement
//            //save data of nodeToDelete
//            //copy replacement to nodeToDelete<copy key and data)
//            //connect parentReplacement to left of replacement node.
//            //decrement size and return saved data.
//
//        if(nodeToDelete.getLeft() != null){
//            Node<K, T> replacement = largestOnLeft(nodeToDelete);
//            T save = nodeToDelete.getmData();
//
//            if(replacement == null){
//                System.out.println("This should not happen.");
//                System.exit(1);
//            }
//
//            Node<K, T> parentReplacement = parentOf(replacement.getKey());
//
//            if(parentReplacement == null){
//                System.out.println("It shouldn't happen");
//                System.exit(1);
//            }
//            parentReplacement.setLeft(replacement);
//
//            size --;
//            return save;
//        }
//
//
//
//        //if no left,
//    }
}
