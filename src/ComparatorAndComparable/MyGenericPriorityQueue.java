package ComparatorAndComparable;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * create generic PriorityQueue ---------- that support Comparator and Comparable
 */
public class MyGenericPriorityQueue<T> {

    ArrayList<T> data;
    Comparator comparator;

    public MyGenericPriorityQueue(){
        this.data=new ArrayList<>();
        this.comparator=null;
    }
    public MyGenericPriorityQueue(Comparator comparator){
        this.data=new ArrayList<>();
        this.comparator=comparator;
    }
    boolean isSmaller(int i , int j){
        T ith = data.get(i);
        T jth = data.get(j);
        if (comparator!=null){
            if (comparator.compare(ith,jth)<0) return true;
            else return false;
        } else {
            Comparable cith = (Comparable) ith;
            Comparable cjth = (Comparable) jth;
            if (cith.compareTo(cjth)<0) return true;
            else return false;
        }
    }
    // operations
    public void add(T x){
        data.add(x);
        upHeapify(data.size()-1);
    }

    private void upHeapify(int lastIndex) {
        if (lastIndex<=0) return;
        int parentIndex = (lastIndex-1)/2;
        if(parentIndex>=0 && isSmaller(lastIndex,parentIndex)){
            swap(lastIndex,parentIndex);
            upHeapify(parentIndex);
        }
    }

    public T remove(){
        if (data.size()<1) return null;
        swap(0, data.size()-1);
        T res =data.remove(data.size()-1);
        downHeapify(0);
        return res;
    }

    private void downHeapify(int parentIndex) {
        int minIndex = parentIndex;
        int leftChildIndex = 2*parentIndex+1;
        if (leftChildIndex<data.size() && isSmaller(leftChildIndex,minIndex)) {
            minIndex = leftChildIndex;
        }
        int rightChildIndex = 2*parentIndex+2;
        if (rightChildIndex<data.size() && isSmaller(rightChildIndex,minIndex)) {
            minIndex=rightChildIndex;
        }
        if (minIndex!=parentIndex){
            swap(minIndex,parentIndex);
            downHeapify(minIndex);
        }
    }

    public T peek(){
        if (data.size()<1) return null;
        return data.get(0);
    }
    public int size(){
        return data.size();
    }

    private void swap(int i , int j){
        T ith = data.get(i);
        T jth = data.get(j);
        data.set(i,jth);
        data.set(j,ith);
    }

//    public static void main(String[] args) {
//        Heap.MyPriorityQueue qu = new Heap.MyPriorityQueue();
//        qu.add(30);
//        qu.add(90);
//        qu.add(10);
//        qu.add(20);
//        qu.add(50);
//        qu.add(40);
//        qu.add(98);
//        System.out.println(qu.data);
//        System.out.println("=======================");
//        while (qu.size()>0){
//            int val = qu.remove();
//            System.out.print(val+" ");
//        }
//    }
}

