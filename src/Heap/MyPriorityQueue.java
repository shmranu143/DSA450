package Heap;

import java.util.ArrayList;

/**
 * create heap data structure and write heap sort
 */
public class MyPriorityQueue {
    ArrayList<Integer> data;

    public MyPriorityQueue(){
        this.data=new ArrayList<>();
    }

    // operations
    public void add(int x){
        data.add(x);
        upHeapify(data,data.size()-1);
    }

    private void upHeapify(ArrayList<Integer> data,int lastIndex) {
        if (lastIndex<=0) return;
        int parentIndex = (lastIndex-1)/2;
        if(parentIndex>=0 && data.get(parentIndex)>data.get(lastIndex)){
            int temp = data.get(lastIndex);
            data.set(lastIndex,data.get(parentIndex));
            data.set(parentIndex,temp);
            upHeapify(data,parentIndex);
        }
    }

    public int remove(){
        if (data.size()<1) return -1;
        swap(0, data.size()-1);
        int res =data.remove(data.size()-1);
        downHeapify(data,0);
        return res;
    }

    private void downHeapify(ArrayList<Integer> data,int parentIndex) {
        if (data.isEmpty()) return;
        int leftChild =(2*parentIndex+1<data.size())? data.get(2*parentIndex+1):Integer.MAX_VALUE;
        int rightChild =(2*parentIndex+2<data.size())? data.get(2*parentIndex+2):Integer.MAX_VALUE;
        int minValue = Integer.min(data.get(parentIndex),Integer.min(leftChild,rightChild));
        if (minValue==leftChild){
            swap(parentIndex,2*parentIndex+1);
            downHeapify(data,2*parentIndex+1);
        } else if (minValue==rightChild) {
            swap(parentIndex,2*parentIndex+2);
            downHeapify(data,2*parentIndex+2);
        } else {
            return;
        }
    }

    public int peek(){
        if (data.size()<1) return -1;
        return data.get(0);
    }
    public int size(){
        return data.size();
    }

    private void swap(int i , int j){
        int ith = data.get(i);
        int jth = data.get(j);
        data.set(i,jth);
        data.set(j,ith);
    }

    public static void main(String[] args) {
        MyPriorityQueue qu = new MyPriorityQueue();
        qu.add(30);
        qu.add(90);
        qu.add(10);
        qu.add(20);
        qu.add(50);
        qu.add(40);
        qu.add(98);
        System.out.println(qu.data);
        System.out.println("=======================");
        while (qu.size()>0){
            int val = qu.remove();
            System.out.print(val+" ");
        }
    }
}
