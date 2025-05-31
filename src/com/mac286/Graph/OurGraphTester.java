package com.mac286.Graph;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class OurGraphTester {
    public static void main(String[] args) {
        OurGraphs<String> G = new OurGraphs<>();
        //G.addEdge();
        G.addEdge("A", "E");
        G.addEdge("E", "F");
        G.addEdge("E", "G");
        G.addEdge("A", "C");
        G.addEdge("C", "D");
        G.addEdge("A", "B");
        G.addEdge("C", "B");
        System.out.println(G);



        System.out.println(G.DFS("A"));
        System.out.println(G.BFS("C"));
        System.out.println(G.minimumSpanningTreeByDFS("A"));
        System.out.println(G.minimumSpanningTreeByBFS("E"));

    }
}
