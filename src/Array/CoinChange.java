package Array;

import java.util.ArrayList;
import java.util.List;
// r101
public class CoinChange {
    static int getLowerBound(int arr[], int num){
        int i=0;
        while(i<arr.length && num>=arr[i]){
            i++;
        }
        if(i==0) return arr[0];
        return arr[i-1];
    }
    static List<Integer> minPartition(int N)
    {
        // code here
        List<Integer> list = new ArrayList<>();
        int arr[] ={ 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 };
        while(N>0){
            int lb = getLowerBound(arr,N);
            list.add(lb);
            N= N-lb;
        }
        return list;

    }

    public static void main(String[] args) {
        System.out.println(minPartition(8098));
    }
}