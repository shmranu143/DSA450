//package LinkedList;
//
//
//
//import java.util.*;
//import java.util.stream.Collectors;
////
////class Solutionf {
////    public List<Integer> findClosestElements(int[] arr, int k, int x) {
////        List<Integer> ll = (List<Integer>) new LinkedList();
////        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(10, new Comparator<Pair>(){
////            @Override
////            public int compare(Pair f, Pair s){
////                if(s.value - f.value == 0){
////                    return s.key - f.key;
////                }else{
////                    return s.value - f.value;
////                }
////
////            }
////        });
////
////        for(int i=0; i<arr.length; i++){
////            int tmp = Math.abs(arr[i] - x);
////            maxHeap.add(new Pair(arr[i], tmp));
////
////            if(maxHeap.size()>k){
////                maxHeap.poll();
////            }
////        }
////
////        while(maxHeap.size() != 0){
////            ll.add(maxHeap.peek().key);
////            maxHeap.poll();
////        }
////
////        Collections.sort(ll);
////        return ll;
////
////    }
////    static int[] can(int N , long X , int[] arr, long[] pos, int Q){
////        Arrays.sort(arr);
////        int newArr [] = new int[N*(int)X];
////        int j =0;
////        for (int i =0;i<arr.length;i++){
////            int temp = X;
////            List<Integer> list = Arrays.stream(ints).collect(Collectors.toList());
////        }
////    }
////}
//
//
//class Solutionw
//{
//    public static void main(String[] args) {
//        ArrayList<Integer> res =Kclosest(new int[]{-21, 21, 4, -12, 20},5,0,4);
//        System.out.println(res);
//    }
//    public static ArrayList<Integer> Kclosest(int arr[], int n, int x, int k)
//    {
////        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
//        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
////        PriorityQueue<Pair<Integer, Integer> > pq =
////                new PriorityQueue<>((a, b) -> b.getKey() - a.getKey());
//        int i =0;
//        for (;i<k;i++){
//            pq.add(new Pair(Math.abs(arr[i]-x),i));
//        }
//
//        for (;i<n;i++){
//            pq.add(new Pair(Math.abs(arr[i]-x),i));
//            Pair pair = pq.poll();
//            if (pq.peek().key==pair.key){
//                if(arr[pair.value]>arr[pq.peek().value]){
//                    pq.poll();
//                    pq.add(pair);
//                }
//            }
//        }
//        ArrayList<Integer> res = new ArrayList<>();
//        while (!pq.isEmpty()){
//            res.add(arr[pq.poll().key]);
//        }
//        return res;
//    }
//}
//class Pair{
//    int key;
//    int value;
//
//    Pair(int key, int value){
//        this.key = key;
//        this.value = value;
//    }
//}
//
//
//
//
//
//
//
//class Node
//{
//    int data;
//    Node left, right;
//
//    Node(int item)
//    {
//        data = item;
//        left = right = null;
//    }
//}
//class Tree
//{
//
//    public class Node{
//
//    }
//    //Function to check whether a binary tree is balanced or not.
//    boolean isBalanced(Node root)
//    {
//        // Your code here
//        int h1 = height(root.left);
//        int h2 = height(root.right);
//        if (Math.abs(h1-h2)>1) return false;
//        else return true;
//    }
//
//    int height(Node node)
//    {
//        // code here
//        int ht=0;
////        if(node!=null) ht =1;
//        if (node.left!=null){
//            int h = height(node.left);
//            ht = Math.max(ht,h);
//        }
//        if (node.right!=null){
//            int h =height(node.right);
//            ht = Math.max(ht,h);
//        }
//        return ht+1;
//    }
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
