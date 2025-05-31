package com.mac286.Graph;

import com.mac286.Queue.OurQueue;
import com.mac286.stacks.OurStack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

public class OurGraphs <T>{
    private Hashtable<T, ArrayList<T>> G;
    private int size;

    public OurGraphs(){
        G = new Hashtable<>();
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void addEdge(T src, T dst){
        if(src == null) return;
        //get the adjacency list of the src. Call it srcList
        ArrayList<T> srcList = G.get(src);
        //if srcList is null, src has never been discovered, this is the first time we know about its existence
        if (srcList == null) {
            //create an adjacency list. If dst is not null, add dst to the list
            srcList = new ArrayList<>();
            if(dst != null){
                srcList.add(dst);
            }
            //add the list to hashtable
            G.put(src, srcList);
            //increase the size.
            size ++;
        }
        //if the srcList exists, then
        else{
            //if dst is null, all already contains dst, return
            if(dst == null || srcList.contains(dst)) return;
            //else, add dst to the list
            else {
                srcList.add(dst);
            }
        }
        //do exactly for dst, because dst to src edge

        if(dst == null) return;

        ArrayList<T> dstList = G.get(dst);
        if (dstList == null) {

            dstList = new ArrayList<>();
            dstList.add(src);
            G.put(dst,dstList);
            size ++;
        }

        else{

            if(dstList.contains(src)) return;

            else {
                dstList.add(src);
            }
        }
    }

    public boolean removeEdge(T src, T dst){
        //Remove the edge (src, dst) in both adjacency lists of src and dst
        ArrayList<T> srcList = G.get(src);
        ArrayList<T> dstList = G.get(dst);
        if(srcList != null && dstList != null){
            return srcList.remove(dst) && dstList.remove(src);
        }
        //if dst is null and the adjacency list of src is empty
        if(dst == null && srcList.isEmpty()){
             G.remove(src);
             return true;
        }
        //remove the node src as well.


        return false;
    }

    public String DFS(T src){
        if(src == null) return "[]";
        OurStack<T> s = new OurStack<>();
        Set<T> visited = new HashSet<>();
        StringBuilder st = new StringBuilder("[");
        s.push(src);
        while(!s.isEmpty()){
            T n = s.pop();
            if(!visited.contains(n)){
                visited.add(n);
                st.append(n.toString()).append(" ");
                ArrayList<T> neighbors = G.get(n);//get adjacency list of n to get its neighbors
                if(neighbors == null){
                    return "something is wrong";
                }

                    for(T neighbor : neighbors){
                        if(!visited.contains(neighbor)){
                            s.push(neighbor);
                        }
                    }
            }

        }
        
        return st.toString() + "]";
    }

    public String BFS(T src){
        if(src == null) return "[]";
        OurQueue<T> q = new OurQueue<>();
        Set<T> visited = new HashSet<>();
        StringBuilder st = new StringBuilder("[");
        visited.add(src);
        q.add(src);
        while(!q.isEmpty()){
            T n = q.remove();
            st.append(n.toString()).append(" ");
            ArrayList<T> neighbors = G.get(n);//get adjacency list of n to get its neighbors
            if(neighbors == null){
                return "something is wrong";
            }

            for(T neighbor : neighbors){
                if(visited.contains(neighbor)){
                    visited.add(neighbor);
                    q.add(neighbor);
                }
            }
        }

        return st.toString() + "]";
    }


    //minimum spanning tree using dfs
    /*
    put src into stack visited
    loop: consider top of stack, put one of neighbors of the top that is not visited
    if there is no neighbors not visited, we pop from stack
     */
    public String minimumSpanningTreeByDFS(T src){
        if(src == null) return "[]";
        OurStack<T> s = new OurStack<>();
        Set<T> visited = new HashSet<>();
        StringBuilder st = new StringBuilder("[");
        s.push(src);
        //visit the src
        visited.add(src);
        while(!s.isEmpty()){
            //consider the top of the stack
            T n = s.peek();
            boolean allVisited = true;

            ArrayList<T> neighbors = G.get(n);//get adjacency list of n to get its neighbors
            for(T neighbor : neighbors){
                if(neighbor != null && !visited.contains(neighbor)){
                    allVisited = false;
                    visited.add(neighbor);
                    s.push(neighbor);
                    st.append("(" + n.toString() + ", " + neighbor.toString() + ") ");
                    //get out of the loop
                    break;
                }
            }

            //if the loop ended because no visited found?
            if(allVisited){
                //pop the top of the stack
                s.pop();
            }
        }

        return st.toString() + "]";
    }

    /*
    minimum spanning true using bfs
    1. add src to queue, visit src
    2.loop
        remove from queue temp
        go thru neighbors of temp, call it n
        if n is not visited,
            visit it
            add to queue
            add edge (temp, n) to sequence

     */
    public String minimumSpanningTreeByBFS(T src){
        if(src == null) return "[]";
        OurQueue<T> q = new OurQueue<>();
        Set<T> visited = new HashSet<>();
        StringBuilder st = new StringBuilder("[");
        visited.add(src);
        q.add(src);
        while(!q.isEmpty()){
            T temp = q.remove();
            ArrayList<T> neighbors = G.get(temp);//get adjacency list of n to get its neighbors
            if(neighbors == null){
                return "something is wrong";
            }

            for(T neighbor : neighbors){
                if(!visited.contains(neighbor)){
                    visited.add(neighbor);
                    q.add(neighbor);
                    st.append("(" + temp.toString() + ", " + neighbor.toString() + ") ");
                }
            }

        }

        return st.toString() + "]";
    }
    public String toString(){
        //get the set of the keys
        Set<T> keys = G.keySet();
        String st = "";
        for(T k:keys){
            ArrayList<T> adjList = G.get(k);
            st += k +": " + adjList.toString() + "\n";
        }
        return st;
    }
}
