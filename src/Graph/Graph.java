package Graph;

import java.util.ArrayList;

public interface Graph {

    boolean hasPath(ArrayList<BasicGraph.Edge>[] graph, boolean [] visited , int source, int dest );
    void printAllPath(ArrayList<BasicGraph.Edge>[] graph, boolean [] visited , int source, int dest, String asf);
    void printSmallestPath(ArrayList<BasicGraph.Edge>[] graph, boolean[] visited,int source, int dest, String asf, int weight);
    void printLargestPath(ArrayList<BasicGraph.Edge>[] graph, boolean[] visited,int source, int dest, String asf, int weight);
    void printJustLargerPath(ArrayList<BasicGraph.Edge>[] graph, boolean[] visited,int k,int source, int dest, String asf,int weight);
    void printJustSmallerPath(ArrayList<BasicGraph.Edge>[] graph, boolean[] visited, int k,int source, int dest, String asf, int weight);
    void printKthLargestPath(ArrayList<BasicGraph.Edge>[] graph, boolean[] visited,int k,int source, int dest, String asf);

}
