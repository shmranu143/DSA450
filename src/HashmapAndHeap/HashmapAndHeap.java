package HashmapAndHeap;

import java.util.List;

public interface HashmapAndHeap {

    int countSubArrayWithEqualZeroAndOne(int[] arr);
    int countSubarrayWithKSum(int [] arr , int k ); // for only positive numbers  // hashSet is enough to solve
    int countSubarrayWithKSumNegativeNumbersAlso(int [] arr , int k );  //use hashMap
    int countSubarrayWithEqual012(int [] arr );
    int countSubarrayDivByK(int []arr, int k);
    int countPairWithKSum(int[] arr, int k);
    boolean hasGroupsSizeX(int[] deck);
    int validpairs(int[] arr); // valid pair=> a[j]-a[i] = j-i;
    List<Integer> distictElementInKsizeWindow(int[] arr,int k);

}
