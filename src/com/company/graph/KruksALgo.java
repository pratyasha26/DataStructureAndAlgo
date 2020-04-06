package com.company.graph;

public class KruksALgo {

    public static void main(String args[]){
        KruksALgo ka=new KruksALgo();
        int graph[][] = new int[][] { { 0, 2, 1, 6, 0 },
                { 2, 0, 3, 8, 5 },
                { 1, 3, 0, 0, 7 },
                { 6, 8, 0, 0, 9 },
                { 0, 5, 7, 9, 0 } };
        int vertex=5;
        getMinSpanningTree(graph,vertex);

    }

    private static void getMinSpanningTree(int[][] graph, int vertex) {

    }
}
