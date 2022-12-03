package Graph;

import Graph.BasicGraph.Edge;

import java.util.ArrayList;

public class GraphImpl implements Graph{
    @Override
    public boolean hasPath(ArrayList<BasicGraph.Edge>[] graph, boolean[] visited, int source, int dest) {
        if (source==dest) return true;
        visited[source]=true;
        for (int i=0;i<graph[source].size();i++){
            Edge edge = graph[source].get(i);
            int nbr = edge.v2;
            if (visited[nbr]==false){
                boolean pathExist = hasPath(graph,visited,nbr,dest);
                if (pathExist) return true;
            }
        }
        return false;
    }

    @Override
    public void printAllPath(ArrayList<BasicGraph.Edge>[] graph, boolean[] visited, int source, int dest, String asf) {
        if (source==dest){
            System.out.println(asf);
            return;
        }
        visited[source]=true;
        for (int i=0;i<graph[source].size();i++){
            Edge edge = graph[source].get(i);
            int nbr = edge.v2;
            if (visited[nbr]==false){
                printAllPath(graph,visited,nbr,dest,asf+" "+nbr);
            }
        }
        visited[source]=false;
    }

    @Override
    public void printSmallestPath(ArrayList<Edge>[] graph, boolean[] visited, int source, int dest, String asf, int weight) {
        if (source==dest){
            if (smallestPathWieght>weight){
                smallestPathWieght=weight;
                smallestPath = asf;
            }
            return;
        }
        visited[source]=true;
        for(int i=0;i<graph[source].size();i++){
            int nbr = graph[source].get(i).v2;
            int wt = graph[source].get(i).wt;
            if (visited[nbr]==false){
                printSmallestPath(graph,visited,nbr,dest,asf+nbr,weight+wt);
            }
        }
        visited[source]=false;
    }
    @Override
    public void printLargestPath(ArrayList<Edge>[] graph, boolean[] visited, int source, int dest, String asf, int weight) {
        if (source==dest){
            if (largestPathWeight<weight){
                largestPathWeight=weight;
                largestPath=asf;
            }
            return;
        }
        visited[source]=true;
        for(int i=0;i<graph[source].size();i++){
            int nbr = graph[source].get(i).v2;
            int wt = graph[source].get(i).wt;
            if (visited[nbr]==false){
                printLargestPath(graph,visited,nbr,dest,asf+nbr,weight+wt);
            }
        }
        visited[source]=false;
    }

    @Override
    public void printJustLargerPath(ArrayList<Edge>[] graph, boolean[] visited, int k, int source, int dest, String asf,int weight) {
        if (source==dest){
            if (weight>k && smallestPathWieght>weight){
                smallestPathWieght=weight;
                smallestPath=asf;
            }
            return;
        }
        visited[source]=true;
        for(int i=0;i<graph[source].size();i++){
            int nbr = graph[source].get(i).v2;
            int wt = graph[source].get(i).wt;
            if (visited[nbr]==false){
                printJustLargerPath(graph,visited,k,nbr,dest,asf+nbr,weight+wt);
            }
        }
        visited[source]=false;
    }

    @Override
    public void printJustSmallerPath(ArrayList<Edge>[] graph, boolean[] visited, int k, int source, int dest, String asf,int weight) {
        if (source==dest){
            if (weight<k && largestPathWeight<weight){
                largestPathWeight=weight;
                largestPath=asf;
            }
            return;
        }
        visited[source]=true;
        for(int i=0;i<graph[source].size();i++){
            int nbr = graph[source].get(i).v2;
            int wt = graph[source].get(i).wt;
            if (visited[nbr]==false){
                printJustSmallerPath(graph,visited,k,nbr,dest,asf+nbr,weight+wt);
            }
        }
        visited[source]=false;
    }

    @Override
    public void printKthLargestPath(ArrayList<Edge>[] graph, boolean[] visited, int k, int source, int dest, String asf) {

    }

    int largestPathWeight = Integer.MIN_VALUE;
    int smallestPathWieght = Integer.MAX_VALUE;
    String smallestPath = "";
    String largestPath = "";
}
