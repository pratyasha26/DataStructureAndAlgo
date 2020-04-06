package com.company.graph;

public class PrimsALgo {


    public static void main(String args[]){
        PrimsALgo primsALgo=new PrimsALgo();
        int vertex=5;
        int graph[][] = new int[][] { { 0, 2, 0, 6, 0 },
                { 2, 0, 3, 8, 5 },
                { 0, 3, 0, 0, 7 },
                { 6, 8, 0, 0, 9 },
                { 0, 5, 7, 9, 0 } };
        getSpanningTree(graph,vertex);
    }

    private static void getSpanningTree(int[][] graph, int vertex) {
        //initialize all required fields
        //key array that contains all the vertex's corresponding weights whihc is max weight initially
        //a boolean array that tracks which vertex has been visited
        //a parent array that contains parents of each vertex
        int key[]=new int [vertex];
        int parent[]=new int[vertex];
        boolean visited[]=new boolean[vertex];
        for(int i=0;i<vertex;i++){
            key[i]=Integer.MAX_VALUE;
            visited[i]=false;
        }
        key[0]=0;
        parent[0]=-1;

      for(int count=0;count<vertex-1;count++){
          int index= extractMinVertexIndex(key,graph,vertex,visited);
          for (int v = 0; v < vertex; v++) {
              if (visited[v] != true && graph[index][v] != 0 && graph[index][v] < key[v]) {
                  parent[v] = index;
                  key[v] = graph[index][v];
                  visited[index] = true;
              }
          }
      }
      for(int i=0;i<vertex;i++){
          System.out.print(i + "  " + key[i]);
          System.out.println();
      }
    }

    private static int extractMinVertexIndex(int[] key, int[][] graph, int vertex, boolean[] visited) {

            int min=Integer.MAX_VALUE;
            for(int i=0;i<vertex;i++){
                if(visited[i]!=true && key[i]<min){
                    return i;
                }
            }
            return -1;
    }
}
