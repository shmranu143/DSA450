package HashmapAndHeap;

import java.util.HashMap;
import java.util.HashSet;

public class HashmapAndHeapImpl implements HashmapAndHeap{

    public static void main(String[] args) {
        HashmapAndHeap obj = new HashmapAndHeapImpl();
        int [] arr = new int[]{0,1,1,0,0,1,1,0,1,1,0};
//        System.out.println(obj.countSubArrayWithEqualZeroAndOne(arr));
//        System.out.println(obj.countSubarrayWithKSum(new int[]{1,3,5,4,7,1,3,4},8));
        System.out.println(obj.countSubarrayWithKSumNegativeNumbersAlso(new int[]{1,3,5,4,7,-7,-1,0},8));
    }
    @Override
    public int countSubArrayWithEqualZeroAndOne(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int countSubArr = 0;
        int prifixSum = 0;
        map.put(0,1);
        for (int i=0;i<arr.length;i++){
            prifixSum=arr[i]==0?prifixSum-1:prifixSum+1;
            if (map.containsKey(prifixSum)){
                countSubArr+=map.get(prifixSum);
                map.put(prifixSum,map.get(prifixSum)+1);
            } else {
                map.put(prifixSum,1);
            }
        }
        return countSubArr;
    }

    @Override
    public int countSubarrayWithKSum(int[] arr, int k) {
        HashSet<Integer> set = new HashSet<>();
        int preSum = 0;
        int count = 0;
        for (int i=0;i<arr.length;i++){
            preSum+=arr[i];
            if (set.contains(preSum-k) && arr[i]!=0){
                count++;
            } else if (set.contains(preSum-k) && arr[i]==0) {
                continue;
            }
            set.add(preSum);
        }
        return count;
    }

    @Override
    public int countSubarrayWithKSumNegativeNumbersAlso(int[] arr, int k) {
        int preSum = 0;
        int count = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for (int val:arr){
            preSum+=val;
            if (map.containsKey(preSum-k)){
                count+=map.get(preSum-k);
                map.put(preSum,map.getOrDefault(preSum,0)+1);
            } else {
                map.put(preSum,map.getOrDefault(preSum,0)+1);
            }
        }
        return count;
    }

    @Override
    public int countSubarrayWithEqual012(int[] arr) {
        return 0;
    }

    @Override
    public int countSubarrayDivByK(int[] arr, int k) {
        return 0;
    }

    @Override
    public int countPairWithKSum(int[] arr, int k) {
        return 0;
    }

    @Override
    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<deck.length;i++){
            if(map.containsKey(deck[i])){
                map.put(deck[i],map.get(deck[i])+1);
            }
            else map.put(deck[i],1);
        }
        int minVal = Integer.MAX_VALUE;
        for (int value: map.values()){
            if (minVal>value) minVal=value;
        }
        if (minVal<2) return false;
        for (int value: map.values()){
            if (value%minVal!=0) return false;
        }
        return true;
    }

}
