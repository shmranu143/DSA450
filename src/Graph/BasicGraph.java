package Graph;

import java.util.ArrayList;

public class BasicGraph {

    static class Edge{
        int v1;
        int v2;
        int wt;
        Edge(int v1,int v2 , int wt){
            this.v1=v1;
            this.v2=v2;
            this.wt=wt;
        }
    }

    public static void main(String[] args) {
        ArrayList<Edge>[] graph = new ArrayList[7];
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

        for (int v=0;v< graph.length;v++){
//            System.out.println(graph[v]);
            int temp = graph[v].size();
            while (temp-->0){
                System.out.print(graph[v].get(temp).v1+" "+graph[v].get(temp).v2+" "+graph[v].get(temp).wt+" ");
            }
            System.out.println();
        }
    }
}
