package Graph;

import Graph.BasicGraph.Edge;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;

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
    public void printKthLargestPath(ArrayList<Edge>[] graph, boolean[] visited, int k, int source, int dest, String asf,int weighgt) {
        if (source==dest){
            addToPQ(asf,weighgt,k);
            return;
        }
        visited[source]=true;
        for (int i=0;i<graph[source].size();i++){
            int nbr = graph[source].get(i).v2;
            int wt = graph[source].get(i).wt;
            if (visited[nbr]==false){
                printKthLargestPath(graph,visited,k,nbr,dest,asf+nbr,weighgt+wt);
            }
        }
        visited[source]=false;
    }

    @Override
    public ArrayList<ArrayList<Integer>> getConnectedComponents(ArrayList<Edge>[] graph) {
        boolean[] visited = new boolean[graph.length];
        ArrayList<ArrayList<Integer>> components = new ArrayList<>();
        for (int i=0;i<graph.length;i++){
            if (visited[i]==false){
                ArrayList<Integer> component = getComponents(graph,visited,i,new ArrayList<Integer>());
                components.add(component);
            }
        }
        return components;
    }

    @Override
    public void bfsOfGraph(ArrayList<Edge>[] graph) {
        ArrayDeque<Dual> queue = new ArrayDeque<>();
        queue.add(new Dual(graph[0].get(0).v1,""+graph[0].get(0).v1));
        boolean[] visited = new boolean[graph.length];
        while (!queue.isEmpty()){
            Dual rem = queue.remove();
            if (visited[rem.vtx]==true) continue;
            visited[rem.vtx]=true;

            System.out.println(rem.vtx+"@"+rem.psf);

            for (int i=0;i<graph[rem.vtx].size();i++){
                Edge e = graph[rem.vtx].get(i);
                if (visited[e.v2]==false){
                    queue.add(new Dual(e.v2,rem.psf+e.v2));
                }
            }
        }
    }

    @Override
    public int spreadOfInfection(ArrayList<Edge>[] graph, int source, int day) {
        ArrayDeque<InfectionPair> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[graph.length];
        queue.add(new InfectionPair(source,1));
        if (day<1) return 1;
        int count =0;
        while (!queue.isEmpty()){
            InfectionPair pair = queue.remove();
            if (pair.day>day) {
                return count;
            }
            if (visited[pair.vtx]==true) continue;
            visited[pair.vtx]=true;
            count++;
            for (int i=0;i<graph[pair.vtx].size();i++){
                Edge e = graph[pair.vtx].get(i);
                if (visited[e.v2]==false){
                    queue.add(new InfectionPair(e.v2,pair.day+1));
                }
            }
        }
        return count;
    }

    @Override
    public boolean isCyclic(ArrayList<Edge>[] graph) {
        boolean[] visited = new boolean[graph.length];
        for (int i=0;i<graph.length;i++){
            if (visited[i]==false){
                boolean isCycle = checkCycle(graph,visited,i);
                if (isCycle==true) return true;
            }
        }
        return false;
    }

    @Override
    public boolean isBipertite(ArrayList<Edge>[] graph) {
        int[] visited = new int[graph.length];// 0 for not visited , 1 for even set , -1 for odd set
        for (int i=0;i<graph.length;i++){
            if (visited[i]==0) {
                boolean temp = isComponentBipartite(graph,visited,i);
                if (temp==false) return false;
            }
        }
        return true;
    }

    /**
     ****  Djikstra Algorithm  ****
     *
     * @param graph
     */
    @Override
    public void printShortestPathInTermsOfWeight(ArrayList<Edge>[] graph) {
        boolean[] visited = new boolean[graph.length];
        PriorityQueue<PathTriplet> queue = new PriorityQueue<PathTriplet>();
        queue.add(new PathTriplet(graph[0].get(0).v1,"0",0));
        while (!queue.isEmpty()){
            PathTriplet rem = queue.remove();
            if (visited[rem.vertex]==true) continue;
            visited[rem.vertex]=true;
            System.out.println(rem.pathSooFar+"@"+rem.weightSoFar);
            for (int i=0;i<graph[rem.vertex].size();i++){
                if (visited[graph[rem.vertex].get(i).v2]==false){
                    queue.add(new PathTriplet(graph[rem.vertex].get(i).v2,
                            rem.pathSooFar+graph[rem.vertex].get(i).v2,
                            graph[rem.vertex].get(i).wt+rem.weightSoFar));
                }
            }
        }

    }

    private boolean isComponentBipartite(ArrayList<Edge>[] graph, int[] visited,int i) {
        ArrayDeque<LevelPair> queue = new ArrayDeque<LevelPair>();
        queue.add(new LevelPair(graph[i].get(0).v1,1));
        while (!queue.isEmpty()){
            LevelPair rem = queue.remove();
            if (visited[rem.vertex]!=0){
                // kuch aur hoga
                if ((rem.level%2!=0 && visited[rem.vertex]!=-1 )|| (rem.level%2==0 && visited[rem.vertex]!=1)) return false;
                continue;
            }
            fillVisited(rem,visited);
            for (int j = 0;j<graph[rem.vertex].size();j++){
                if (visited[graph[rem.vertex].get(j).v2]==0)
                queue.add(new LevelPair(graph[rem.vertex].get(j).v2,rem.level+1));
            }
        }
        return true;
    }

    private void fillVisited(LevelPair rem, int[] visited) {
        if (rem.level%2==0){
            visited[rem.vertex]=1;
        } else {
            visited[rem.vertex]=-1;
        }
    }


    private boolean checkCycle(ArrayList<Edge>[] graph,boolean[] visited,int source){
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(source);
        while (!queue.isEmpty()){
            int rem = queue.remove();
            if (visited[rem]==true) return true;
            visited[rem]=true;
            for (int i=0;i<graph[rem].size();i++){
                Edge e = graph[rem].get(i);
                if (visited[e.v2]==false){
                    queue.add(e.v2);
                }
            }
        }
        return false;
    }
    private ArrayList<Integer> getComponents(ArrayList<Edge>[] graph, boolean[] visited, int source,ArrayList<Integer> component) {
        visited[source]=true;
        component.add(source);
        for (int i =0;i<graph[source].size();i++){
            Edge edge = graph[source].get(i);
            int nbr = edge.v2;
            if (visited[nbr]==false){
                getComponents(graph,visited,nbr,component);
            }
        }
        return component;
    }

    private void addToPQ(String asf, int weighgt, int k) {
        if (pq.size()<k){
            pq.add(new Pair(asf,weighgt));
        } else if (pq.peek().weight<weighgt){
            pq.remove();
            pq.add(new Pair(asf,weighgt));
        }
    }

    int largestPathWeight = Integer.MIN_VALUE;
    int smallestPathWieght = Integer.MAX_VALUE;
    String smallestPath = "";
    String largestPath = "";
    PriorityQueue<Pair> pq = new PriorityQueue<Pair>();

    class Pair implements Comparable<Pair> {
        String asf;
        int weight;
        Pair(String asf , int weight){
            this.asf=asf;
            this.weight=weight;
        }

        @Override
        public int compareTo(Pair o) {
            return this.weight-o.weight;
        }
    }
    class Dual {
        int vtx;
        String psf;
        Dual(int vtx, String psf){
            this.vtx=vtx;
            this.psf=psf;
        }
    }
    class InfectionPair{
        int vtx ;
        int day;
        InfectionPair(int vtx, int day){
            this.vtx=vtx;
            this.day=day;
        }
    }
}
