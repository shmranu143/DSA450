package Graph;

import java.util.ArrayList;
public interface Graph {

    boolean hasPath(ArrayList<BasicGraph.Edge>[] graph, boolean [] visited , int source, int dest );
    void printAllPath(ArrayList<BasicGraph.Edge>[] graph, boolean [] visited , int source, int dest, String asf);
    void printSmallestPath(ArrayList<BasicGraph.Edge>[] graph, boolean[] visited,int source, int dest, String asf, int weight);
    void printLargestPath(ArrayList<BasicGraph.Edge>[] graph, boolean[] visited,int source, int dest, String asf, int weight);
    void printJustLargerPath(ArrayList<BasicGraph.Edge>[] graph, boolean[] visited,int k,int source, int dest, String asf,int weight);
    void printJustSmallerPath(ArrayList<BasicGraph.Edge>[] graph, boolean[] visited, int k,int source, int dest, String asf, int weight);
    void printKthLargestPath(ArrayList<BasicGraph.Edge>[] graph, boolean[] visited,int k,int source, int dest, String asf,int weighgt);
    ArrayList<ArrayList<Integer>> getConnectedComponents(ArrayList<BasicGraph.Edge>[] graph);
//    perfectFriend
//    no of iceland
    void bfsOfGraph(ArrayList<BasicGraph.Edge>[] graph); // bfs -----------------------
    int spreadOfInfection(ArrayList<BasicGraph.Edge>[] graph , int source , int day);
    boolean isCyclic(ArrayList<BasicGraph.Edge>[] graph);
    boolean isBipertite(ArrayList<BasicGraph.Edge>[] graph);
    void printShortestPathInTermsOfWeight(ArrayList<BasicGraph.Edge>[] graph); // **** Djikstra  Algorithm ***** //
    void printHamiltonianPathAndCycle(ArrayList<BasicGraph.Edge>[] graph);
    void iterativeDFS(ArrayList<BasicGraph.Edge>[] graph);
    void minimumWireToConnectAllVertex(ArrayList<BasicGraph.Edge>[] graph);// *** Prims algorithm *** //
    // topological sort
    void topologicalSort();

}
