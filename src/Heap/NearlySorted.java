package Heap;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class NearlySorted {

    ArrayList<Integer> nearlySorted(int arr[], int num, int k)
    {
        ArrayList<Integer> res = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i =0;
        for (;i<=k;i++){
            pq.add(arr[i]);
        }
        for (;i<num;i++){
            if (i==k) res.add(pq.poll());
            pq.add(arr[i]);
        }
        while (!pq.isEmpty()){
            res.add(pq.poll());
        }
        return res;
    }
}
