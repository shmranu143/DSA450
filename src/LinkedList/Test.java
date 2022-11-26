package LinkedList;

import java.lang.reflect.Array;
import java.util.*;

public class Test {
//    public static void main(String[] args) {
//        int []a={1,3,5,7,9};
//        int []b ={2,4,6,8,10};
//        for (int i)
//
//    }
}



class Solution{
    int findOnce(int a[], int n)
    {
        int l =0;
        int h = n;
        int uniq = -1;
        while (l<h){
            int mid = l+(h-l)/2;
            if (mid%2==0 && mid+1<n){
                if (a[mid]!=a[mid+1]){
                    uniq = a[mid];
                    break;
                }
                l=mid;
            }
            else if (mid>0 && mid+1<n){
                if (a[mid]==a[mid+1]) h=mid;
                else l=mid;
            }
        }
        return uniq;
    }
}

