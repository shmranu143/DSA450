package Heap;

import java.util.PriorityQueue;
// r101 ***
public class KLargestElements {
//    public static void main(String[] args) {
//        int[] res = kLargest(new int[]{12, 5, 787, 1, 23},5,2);
//        System.out.println(res[0]+" "+res[1]);
//    }
    static int[] kLargest(int[] arr, int n, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int [] res = new int[k];
        int i =0;
        for (;i<k;i++){
            pq.add(arr[i]);
        }
        for (;i<n;i++){
            pq.add(arr[i]);
            if (pq.size()>k) pq.poll();
        }

        int j=0;
        while (!pq.isEmpty()){
            res[j++]=pq.poll();
        }
        return res;
    }
}
