package Tree;

import java.util.*;

public class BTree{
    Node root;
    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
//        foo(null);
//        int [] a = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120};
//        BTree tree = new BTree();
//        tree.root = createTree(a);
//        display(tree.root);
//        int size = sizeOfTree( tree.root);
//        System.out.println("*****************************************");
//        System.out.println("size of tree : "+size);
//        int max = maxOfTree(tree.root);
//        System.out.println("max of tree : "+max);
//        System.out.println("height of tree : "+heightOfTree(tree.root));
//        displayEulerPath(tree.root);
    }
    public static void foo(Objects o){
        System.out.println("object");
    }
    public static void foo(String s){
        System.out.println("object");
    }
    private static void displayEulerPath(Node root) {
        System.out.println("Node pre : "+root.data);
        Stack<Node> st = new Stack<>();
        if (root.left!=null){
            System.out.println("edge pre :"+root.data+"--"+root.left.data);
            if (root.left.left==null){

            }
            displayEulerPath(root.left);
        }
        else {
            System.out.println("Node post : "+root.data);
//            System.out.println("edge post : "+root.data+"--"+prev.data);
        }

    }

    private static int heightOfTree(Node root) {
        int height = 0;
        if(root.left!=null){
            int ch = heightOfTree(root.left);
            height = Math.max(ch,height);
        }
        if(root.right!=null){
            int ch = heightOfTree(root.right);
            height = Math.max(ch,height);
        }
        return height+1;

    }

    private static int maxOfTree(Node root) {
        int max = -1;
        if (root.left!=null){
            int cm = maxOfTree(root.left);
            max = Math.max(cm,max);
        }
        if (root.right!=null){
            int cm = maxOfTree(root.right);
            max = Math.max(cm,max);
        }
        return Math.max(max, root.data);

    }

    private static int sizeOfTree(Node root) {
       int s = 0;
       if(root.left!=null){
           int size = sizeOfTree(root.left);
           s=s+size;
       }
       if (root.right!=null){
           int size = sizeOfTree(root.right);
           s=s+size;
       }
       return s+1;
    }

    private static void display(Node root) {
        String str = root.data + "->";
        if (root.left != null) {
            str = str + root.left.data + ",";
        }
        if (root.right != null) {
            str = str + root.right.data;
        }
        System.out.println(str);
        if (root.left != null) {
            display(root.left);
        }
        if (root.right != null) {
            display(root.right);
        }
    }

    private static Node createTree(int[] a) {
        Node root =null;
        Stack<Node> stack = new Stack<>();
        for (int i =0;i<a.length;i++){
            if (a[i]==-1){
                stack.pop();
            } else {
                Node node = new Node(a[i]);
                if(stack.isEmpty()){
                    root = node;
                }
                else {
                    Node temp = stack.peek();
                    if (temp.left==null)    temp.left = node;
                    else temp.right=node;
                }
                stack.push(node);
            }
        }
        return root;
    }
}

class Node
{
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}


class Solution
{
    //Function to remove duplicates from unsorted linked list.
    public Node removeDuplicates(Node head)
    {
        // Your code here
        Node curr = head;
        if (curr == null) return head;
        HashSet<Integer> set = new HashSet<>();
        set.add(curr.data);
        while (curr.next!=null){
            set.add(curr.next.data);
            if (set.contains(curr.next.data)) curr.next = curr.next.next;
            else curr=curr.next;
        }
        return head;
    }
}


