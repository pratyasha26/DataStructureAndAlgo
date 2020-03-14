package com.company.graph;

import java.util.LinkedList;

class Graph{
    int v;
    LinkedList<Integer> linkedList[];
    Graph(int v){
        this.v=v;
        this.linkedList=new LinkedList[v];
        for(int i=0;i<v;i++){
           linkedList[i]=new LinkedList<>();
        }
    }
}
public class AdjacencyList {
    public static void addEdge(Graph g, int src, int des){
       g.linkedList[src].add(des);
       g.linkedList[des].add(src);
    }
    public static void printGraph(Graph g){

        for(int i=0;i<g.v;i++){
            System.out.println("Adjacency list of vertex "+ i);
            System.out.print("head");
            for(Integer pCrawl: g.linkedList[i]){
                System.out.print(" -> "+pCrawl);
            }
        }
    }
    public static  void main(String args[]){
        Graph graph=new Graph(5);
        addEdge(graph, 1, 2);
        addEdge(graph, 1, 3);
        addEdge(graph, 2, 4);
        addEdge(graph, 3, 4);
        addEdge(graph, 3, 2);
        printGraph(graph);
        bfs(graph,2);
        dfsStart(graph,2);
        printGraph(graph);
    }

    private static void dfsStart(Graph graph, int i) {
        boolean visited1[] = new boolean[graph.v];
        dfs(graph,i,visited1);
    }

    private static void dfs(Graph graph, int i, boolean[] visited1) {
        if (visited1[i] == false) {
            System.out.print(i + " -> ");
        }
        visited1[i] = true;
        for (Integer pCrawl : graph.linkedList[i]) {
            if (visited1[pCrawl] == false) {
                dfs(graph, pCrawl,visited1);
            }
        }
    }

    private static void bfs(Graph graph, int i) {
        LinkedList<Integer> queue=new LinkedList<>();
        boolean visited[]=new boolean[graph.v];
        queue.add(i);
        while(queue.size()!=0){
            int v=queue.poll();
            if(!visited[v]) {
                System.out.print(v + " -> ");
                visited[v]=true;
            }

            for(Integer pCrawl: graph.linkedList[i]){
                if(visited[pCrawl]==false) {
                    queue.add(pCrawl);
                }
            }
        }
    }
}
