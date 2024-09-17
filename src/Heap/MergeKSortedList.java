package Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
// r101 ***
public class MergeKSortedList {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> l1 = new ArrayList<>();
        l1.add(10);l1.add(20);l1.add(30);l1.add(40);
        ArrayList<Integer> l2 = new ArrayList<>();
        l2.add(5);l2.add(12);l2.add(60);
        ArrayList<Integer> l3 = new ArrayList<>();
        l3.add(13);l3.add(56);l3.add(80);
        list.add(l1);list.add(l2);list.add(l3);
        ArrayList<Integer> res = mergeKSortedList(list);
        System.out.println(res);
    }
    private static ArrayList<Integer> mergeKSortedList(ArrayList<ArrayList<Integer>> lists) {
        PriorityQueue<TripLet> pq = new PriorityQueue<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i=0;i<lists.size();i++){
            TripLet list = new TripLet(lists.get(i).get(0),i,0);
            pq.add(list);
        }
        while (pq.size()>0){
            TripLet top = pq.remove();
            result.add(top.data);
            int li = top.listInd;
            int ind = top.index;
            if (ind+1<lists.get(li).size()){
                pq.add(new TripLet(lists.get(li).get(ind+1),li,ind+1));
            }
        }
        return result;
    }
}
class TripLet implements Comparable<TripLet>{

    int data;
    int listInd;
    int index;
    TripLet(int data , int listInd , int index){
        this.data=data;
        this.listInd=listInd;
        this.index=index;
    }
    @Override
    public int compareTo(TripLet o) {
        return this.data-o.data;
    }
}
