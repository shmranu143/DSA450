package Heap;

import java.util.PriorityQueue;

public class ConnectRopesMinimizeCost {
    long minCost(long arr[], int n)
    {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0 ;i <n ;i++){
            pq.add(arr[i]);
        }
        long cost = 0;
        while (!pq.isEmpty() && pq.size()>1){
            long p1 = pq.poll();
            long p2 = pq.poll();
            long temp = p1+p2;
            cost+=temp;
            pq.add(temp);
            if (pq.size()==1) break;
        }
        return cost;
    }
}
