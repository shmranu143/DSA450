package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BasicGraph {

    static class Edge{
        int v1;
        int v2;
        int wt;
        @Override
        public String toString() {
            return  "{" +
                    "v1=" + v1 +
                    ",v2=" + v2 +
                    ",wt=" + wt +
                    '}';
        }
        Edge(int v1,int v2 , int wt){
            this.v1=v1;
            this.v2=v2;
            this.wt=wt;
        }
        Edge(String v1,String v2 , String wt){
            this.v1=Integer.parseInt(v1);
            this.v2=Integer.parseInt(v2);
            this.wt=Integer.parseInt(wt);
        }
        Edge(String v1,String v2 ){
            this.v1=Integer.parseInt(v1);
            this.v2=Integer.parseInt(v2);
            this.wt=0;
        }
    }

    public static void main(String[] args) throws IOException{
        GraphImpl obj = new GraphImpl();
        ArrayList<Edge>[] graph = new ArrayList[7];
        createHardcodedGraph(graph);
//        obj.bfsOfGraph(graph);
//        ArrayList<Edge>[] weightedGraph = createWeightedArrayListGraph();
//        ArrayList<Edge>[] nonWeightedGraph = createNonWeightedArrayListGraph();
//        int[][] mapGraph = createMapGraph();

//        for (int v=0;v< graph.length;v++){
//            System.out.println(graph[v]);
//        }
//        printMap(mapGraph);
//        obj.printAllPath(graph,new boolean[graph.length],0,6,"0");
//        System.out.println(obj.hasPath(graph,new boolean[graph.length],0,6));
//        obj.printSmallestPath(graph,new boolean[graph.length],0,6,"0",0);
//        System.out.println("smallestPath : "+obj.smallestPath);
//        obj.printLargestPath(graph,new boolean[graph.length],0,6,"0",0);
//        System.out.println("largestPath : "+obj.largestPath);
//        obj.printJustLargerPath(graph,new boolean[graph.length],48,0,6,"0",0);
//        System.out.println("just larger path than 48 is: "+obj.smallestPath);
//        obj.printJustSmallerPath(graph,new boolean[graph.length],50,0,6,"0",0);
//        System.out.println("just smaller path than 50 is: "+obj.largestPath);
//        obj.printKthLargestPath(graph,new boolean[graph.length],2,0,6,"0",0);
//        System.out.println("kth largest path: "+obj.pq.peek().asf);
//        ArrayList<ArrayList<Integer>> list = obj.getConnectedComponents(graph);
//        System.out.println(list);

//        System.out.println(obj.spreadOfInfection(graph,6,0));
//        System.out.println(obj.isCyclic(weightedGraph));
//        System.out.println(obj.isBipertite(graph));
//        obj.printShortestPathInTermsOfWeight(weightedGraph);
//        obj.printHamiltonianPathAndCycle(weightedGraph);
        obj.iterativeDFS(graph);
        obj.bfsOfGraph(graph);
    }

    private static void printMap(int[][] mapGraph) {
        for (int i=0;i< mapGraph.length;i++){
            for (int j=0;j<mapGraph[i].length;j++)
                System.out.print(mapGraph[i][j]+" ");
            System.out.println();
        }
        return;
    }

    private static int[][] createMapGraph() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int [][] graph = new int[m][n];
        for (int i=0;i<m;i++){
            String [] str = br.readLine().trim().split(" ");
            for (int j=0;j<n;j++){
                graph[i][j]=Integer.parseInt(str[j]);
            }
        }
        return graph;
    }

    private static ArrayList<Edge>[] createNonWeightedArrayListGraph() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int vertices = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[vertices];// Array of ArrayList
        for (int i=0;i<vertices;i++){
            graph[i]=new ArrayList<>();
        }
        int edges = Integer.parseInt(br.readLine());
        for (int i=0;i<edges;i++){
            String[] str = br.readLine().trim().split(" ");
            Edge edge = new Edge(str[0],str[1]);
            graph[edge.v1].add(edge);
            graph[edge.v2].add(new Edge(str[1],str[0]));
        }
        return graph;
    }

    private static ArrayList<Edge>[] createWeightedArrayListGraph() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int vertices = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[vertices];// Array of ArrayList
        for (int i=0;i<vertices;i++){
            graph[i]=new ArrayList<>();
        }
        int edges = Integer.parseInt(br.readLine());
        for (int i=0;i<edges;i++){
            String[] str = br.readLine().trim().split(" ");
            Edge edge = new Edge(str[0],str[1],str[2]);
            graph[edge.v1].add(edge);
            graph[edge.v2].add(new Edge(str[1],str[0],str[2]));
        }
        return graph;
    }

    private static void createHardcodedGraph(ArrayList<Edge>[] graph) {
        for (int v=0;v<graph.length;v++){
            graph[v]=new ArrayList<>();
        }
        graph[0].add(new Edge(0,1,10));
        graph[0].add(new Edge(0,3,40));

        graph[1].add(new Edge(1,0,10));
        graph[1].add(new Edge(1,2,10));

        graph[2].add(new Edge(2,1,10));
        graph[2].add(new Edge(2,3,10));

        graph[3].add(new Edge(3,0,40));
        graph[3].add(new Edge(3,2,10));
        graph[3].add(new Edge(3,4,2));

        graph[4].add(new Edge(4,3,2));
        graph[4].add(new Edge(4,5,3));
        graph[4].add(new Edge(4,6,8));

        graph[5].add(new Edge(5,4,3));
        graph[5].add(new Edge(5,6,3));

        graph[6].add(new Edge(6,4,8));
        graph[6].add(new Edge(6,5,3));

    }
}
