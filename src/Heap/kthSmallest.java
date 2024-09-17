package Heap;

import java.util.Collections;
import java.util.PriorityQueue;
// r101 ***
public class kthSmallest {
    public static void main(String[] args) {
        int num =  kthSmallest(new int[]{7, 10, 4 ,3 ,20, 15},0,5,3);
        System.out.println(num);
    }
    public static int kthSmallest(int[] arr, int l, int r, int k)
    {
        //Your code here
        PriorityQueue<Integer> maxH = new PriorityQueue<>(Collections.reverseOrder());
        for (int i=l;i<l+k;i++){
            maxH.add(arr[i]);
        }
        for (int i=k;i<=r;i++){
            if (arr[i]<maxH.peek()){
                maxH.poll();
                maxH.add(arr[i]);
            }
        }
        return maxH.peek();
    }
}
