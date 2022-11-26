package Hashing;

//public class CountPairs {
//
//}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    /**
     * Identical Twins Count
     * For an array of integers nums, an identical twin is defined as pair (i, j) where nums[i] is equal to nums[j] and i < j
     * @param arr
     * @return
     */
    static int getIdenticalTwinsCount (int[] arr) {
        // add your logic here
        int countPairs = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int val : arr){
            if(map.containsKey(val)){
                map.put(val,map.get(val)+1);
            }
            else map.put(val,1);
        }
        for (int val: map.values()){
            countPairs+=(val*(val-1))/2;
        }
        return countPairs;
    }

    public static void printLongestConsecutiveSequence(int a[]){

    }

    public static void main(String[] args) {
        System.out.println(getIdenticalTwinsCount(new int[]{1, 2, 3, 2, 1}));;
    }
}

class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int count =0;
        int sum = 0;
        if (num%2!=0) count++;
        int j = 1;
        for(int i=1;i<=num/2+1;i+=2){
            sum+=i;
            if(sum==num) {
                count++;
            } else if (sum>num){
                while(sum>num){
                    sum-=j;
                    j+=2;
                }
                if(sum==num) count++;
            }
        }
        System.out.println(count);
    }
}