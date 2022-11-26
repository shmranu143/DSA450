package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class bfs {
    public static void main(String[] args) {
//        bfsOfGraph()
    }
    public static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[] vis = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (vis[i] == false) {
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                vis[i] = true;
                while (!q.isEmpty()) {
                    int node = q.poll();
                    bfs.add(node);
                    for (int it : adj.get(node)) {
                        if (vis[it] == false) {
                            q.add(it);
                            vis[it] = true;
                        }
                    }
                }
            }
        }
        return bfs;
    }
}
