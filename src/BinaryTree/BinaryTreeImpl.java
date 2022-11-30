package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeImpl implements BinaryTree{
    @Override
    public Node construct(List<Integer> list) {
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(new Node(list.get(0)),1));
        int idx=1;
        Pair root = null;
        while (!st.isEmpty()){
            int state = st.peek().state;
            if (state==1){
                Integer data = list.get(idx++);
                st.peek().state++;
                if (data!=null){
                    Node next = new Node(data);
                    st.peek().node.left=next;
                    st.push(new Pair(next,1));
                }
            } else if (state==2){
                Integer data = list.get(idx++);
                st.peek().state++;
                if (data!=null) {
                    Node next = new Node(data);
                    st.peek().node.right=next;
                    st.push(new Pair(next,1));
                }
            } else if (state==3) {
                root = st.pop();
            }
        }
        return root.node;
    }
    @Override
    public void display(Node node) {
        if (node==null) return;
        if (node!=null) System.out.print(node.data+" ");
        display(node.left);
        display(node.right);
    }
    @Override
    public int size(Node node) {
        if (node==null) return 0;
        return size(node.left)+size(node.right)+1;
    }
    @Override
    public int sum(Node node) {
        if (node==null) return 0;
        int lsum = sum(node.left);
        int rsum = sum(node.right);
        return lsum+rsum+node.data;

        // 1 line code
//        return (node==null?0:sum(node.left)+sum(node.right)+node.data);
    }
    @Override
    public int max(Node node) {
        if (node==null) return 0;
        int max = node.data;
        max = Math.max(max(node.left),max);
        max = Math.max(max(node.right),max);
        return max;
    }
    @Override
    public int height(Node node) {
        if (node==null) return 0;
        int lh = height(node.left);
        int rh = height(node.right);
        return Math.max(lh,rh)+1;
    }
    @Override
    public void levelOrder(Node node) {
        LinkedList<Node> queue = new LinkedList<>();
        queue.addLast(node);
        while (queue.size()>0){
            int count = queue.size();
            for (int i=0;i<count;i++){
                Node peek = queue.removeFirst();
                System.out.print(peek.data+" ");
                if (peek.left!=null) queue.addLast(peek.left);
                if (peek.right!=null) queue.addLast(peek.right);
            }
            System.out.println();
        }
    }
    @Override
    public void levelOrder2(Node node){
        LinkedList<Node> queue = new LinkedList<>();
        queue.addLast(node);
        queue.addLast(new Node(-1));
        while (queue.size()>0){
            Node peek = queue.removeFirst();
            if (peek.data==-1){
                if (queue.size()>0) queue.add(new Node(-1));
                System.out.println();
                continue;
            }
            System.out.print(peek.data+" ");
            if (peek.left!=null) queue.addLast(peek.left);
            if (peek.right!=null) queue.addLast(peek.right);
        }
    }
    @Override
    public void levelOrder3(Node node) {
        LinkedList<Node> pq = new LinkedList<>();
        LinkedList<Node> cq = new LinkedList<>();
        pq.add(node);
        while (pq.size()>0){
            Node peek = pq.removeFirst();
            System.out.print(peek.data+" ");
            if (peek.left!=null) cq.addLast(peek.left);
            if (peek.right!=null) cq.addLast(peek.right);
            if (pq.size()==0){
                pq=cq;
                cq= new LinkedList<>();
                System.out.println();
            }
        }
    }
    @Override
    public boolean find(Node node, int data) {
        if (node==null) return false;
        else if (node.data==data) return true;
        if(find(node.left,data)) return true;
        if(find(node.right,data)) return true;
        return false;
    }
    @Override
    public ArrayList<Node> nodeToRootPath(Node node, int data) {
        ArrayList<Node> list = new ArrayList<>();
        if (node==null) return new ArrayList<>();
        else if (node.data==data){
            list.add(node);
            return list;
        }
        ArrayList<Node> temp = nodeToRootPath(node.left,data);
        if (temp.size()>0) {
            list=temp;
            list.add(node);
            return list;
        }
        temp = nodeToRootPath(node.right,data);
        if (temp.size()>0) {
            list=temp;
            list.add(node);
            return list;
        }
        return new ArrayList<>();
    }
    @Override
    public void printKLevelDown(Node node, int k) {
        if(node==null || k<0) return;
        if (k==0){
            System.out.print(node.data+" ");
        }
        printKLevelDown(node.left,k-1);
        printKLevelDown(node.right,k-1);
        return;
    }
    @Override
    public void printKNodesFar(Node root, int data, int k) {
        ArrayList<Node> list = nodeToRootPath(root,data);
        for (int i=0;i<list.size();i++){
            printKLevelDownWithBlocker(list.get(i),k-i,i>0?list.get(i-1):null);
            System.out.println();
        }
    }
    @Override
    public List<Integer> preorder(Node root, List<Integer> list) {
        if (root==null) return list;
        list.add(root.data);
        preorder(root.left,list);
        preorder(root.right,list);
        return list;
    }
    @Override
    public List<Integer> inorder(Node root, List<Integer> list) {
        if (root==null) return list;
        preorder(root.left,list);
        list.add(root.data);
        preorder(root.right,list);
        return list;
    }
    @Override
    public List<Integer> postorder(Node root, List<Integer> list) {
        if (root==null) return list;
        preorder(root.left,list);
        preorder(root.right,list);
        list.add(root.data);
        return list;
    }
    public void printKLevelDownWithBlocker(Node node, int k, Node blocker) {
        if(node==null || k<0 || node==blocker) return;
        if (k==0){
            System.out.print(node.data+" ");
        }
        printKLevelDown(node.left,k-1);
        printKLevelDown(node.right,k-1);
        return;
    }

    @Override
    public void iterativeTraversal(Node root) {
        String pre = "";
        String in = "";
        String post = "";
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root,1));
        while (st.size()>0){
            Node node = st.peek().node;
            if (st.peek().state==1){
                pre+=node.data+" ";
                st.peek().state++;
                if(node.left!=null)
                st.push(new Pair(node.left,1));
            } else if (st.peek().state==2){
                in+=node.data+" ";
                st.peek().state++;
                if (node.right!=null)
                st.push(new Pair(node.right,1));
            } else {
                post+=st.pop().node.data+" ";
            }

        }
        System.out.println("preorder: "+pre);
        System.out.println("inorder: "+in);
        System.out.println("postorder: "+post);
    }
    @Override
    public Node normalToLeftClone(Node root) {
        if (root==null) return null;
        normalToLeftClone(root.left);
        normalToLeftClone(root.right);
        Node left = root.left;
        Node newNode = new Node(root.data);
        newNode.left=left;
        root.left=newNode;
        return root;
    }
    @Override
    public Node leftCloneToNormal(Node root) {
        if (root==null) return null;
        root.left=root.left.left;
        leftCloneToNormal(root.left);
        leftCloneToNormal(root.right);
        return root;
    }
    @Override
    public Node removeLeaves(Node root) {
        if (root==null) return null;
        if (root.left==null && root.right==null){
            return null;
        }
        root.left= removeLeaves(root.left);
        root.right = removeLeaves(root.right);
        return root;
    }
    @Override
    public void printSingleChild(Node root, Node parent) {
        if (root==null) return;
        if (root.left!=null && root.right==null){
            System.out.println(root.left.data+" ");
        }
        if (root.right!=null && root.left==null){
            System.out.println(root.right.data+" ");
        }
        printSingleChild(root.left,root);
        printSingleChild(root.right,root);
    }
    @Override
    public void pathToLeafFromRoot(Node node, String path, int sum, int low, int high) {
        if (node==null) return;
        if (node.left==null && node.right==null){
            sum+=node.data;
            if (sum>=low && sum<=high)
                System.out.println(path+" "+node.data);
            return;
        }
        pathToLeafFromRoot(node.left,path+" "+node.data,sum+node.data,low,high);
        pathToLeafFromRoot(node.right,path+" "+node.data,sum+node.data,low,high);
    }

    int dia=0;
    @Override
    public int diameter(Node node) {
        if (node==null) return -1;  // in terms of edge
        int lh = diameter(node.left);
        int rh = diameter(node.right);
        int ht = Math.max(lh,rh)+1;
        if (dia<lh+rh+2){
            dia = lh+rh+2;
        }
        return ht;
    }
    @Override
    public DiaPair diameter2(Node node) {
        if (node==null){
            return new DiaPair();
        }
        DiaPair ld = diameter2(node.left);
        DiaPair rd = diameter2(node.right);
        DiaPair mp = new DiaPair();
        mp.ht=Math.max(ld.ht, rd.ht)+1;
        mp.dia= ld.ht+ rd.ht+2> mp.dia?ld.ht+ rd.ht+2: mp.dia;
        return mp;
    }
    /**
     * --------------------------------------------do below code -------------------------------------------------- *
     */
    @Override
    public TiltTriplet tiltOfBTree(Node root) {
        if (root==null) return new TiltTriplet();
        TiltTriplet lt=tiltOfBTree(root.left);
        TiltTriplet rt=tiltOfBTree(root.right);
        TiltTriplet mt = new TiltTriplet();
        mt.sum=lt.sum+ rt.sum+root.data;
        mt.nodeTilt = Math.abs(lt.sum- rt.sum);
        mt.treeTilt=mt.nodeTilt+lt.treeTilt+rt.treeTilt;
        return mt;
    }
    @Override
    public boolean isBalanced(Node root) { // if left height and right height has at most 1 difference
        heightBalanced(root);
        return false;
    }

    private int heightBalanced(Node root) {
        if (root==null) return 0;
        int lh = heightBalanced(root.left);
        int rh = heightBalanced(root.right);
        return 0;
    }

    @Override
    public boolean isBST(Node root) {
        return isBst(root,new BstTriplet(Integer.MIN_VALUE,Integer.MAX_VALUE));
    }
    @Override
    public int largestBST(Node root) {

//        BstPenta obj = getLargestBstSize(root);
//        System.out.println(obj.min+" : "+obj.max+" : "+obj.largestBstNode+" : "+ obj.isBst+" :"+ obj.largestBstNodeSize);
//        return obj.largestBstNodeSize;
        return 0;
    }
    @Override
    public Node SortedArrayToBst(int[] arr) {
        return null;
    }
    @Override
    public int sumOfBst(Node node) {
        if (node==null) return 0;
        int sum = node.data+sumOfBst(node.left)+sumOfBst(node.right);
        return sum;
    }
    @Override
    public int maxOfBst(Node node) {
        if (node==null) return Integer.MIN_VALUE;
        int max = node.data;
        int maxTemp = maxOfBst(node.right);
        return Math.max(max,maxTemp);
    }
    @Override
    public int minOfBst(Node node) {
        if (node==null) return Integer.MAX_VALUE;
        int min = node.data;
        int minTemp = minOfBst(node.left);
        return Math.min(minTemp,min);
    }
    @Override
    public boolean findInBst(Node node,int data) {
        if (node==null) return false;
        if (node.data==data) return true;
        else if (node.data<data) {
            return findInBst(node.right,data);
        } else if (node.data>data) {
            return findInBst(node.left,data);
        }
        return false;
    }
    @Override
    public Node replaceWithSumOfLarger(Node node) {
        return null;
    }
    @Override
    public void printInBetween(Node node) {

    }
    @Override
    public int lca(Node node) {
        return 0;
    }
    @Override
    public void targetSumPair(Node node, int target) {

    }
    @Override
    public void targetSumPair2(Node node, int target) {

    }
    @Override
    public Node addNodeBst(Node node, int data) {
        if (node==null){
            return new Node(data);
        }
        if(data<node.data){
            node.left=addNodeBst(node.left,data);
        } else if (data>node.data) {
            node.right=addNodeBst(node.right,data);
        } else {
            System.out.println("data already present");
        }
        return node;
    }
    @Override
    public Node removeNodeBst(Node node, int data) {
        if (node.data==data){
            node=removeNode(node);
        } else if (node.data<data) {
            node.right=removeNodeBst(node.right,data);
        } else {
            node.left=removeNodeBst(node.left,data);
        }
        return node;
    }

    /**
     * imp**
     * @param preorder
     * @param inorder
     * @return
     */
    @Override
    public Node cuntructTreeFromPreAndIn(int[] preorder, int[] inorder) {
        return null;
    }

    @Override
    public boolean isCompleteBT(Node node) {
        return false;
    }

    private Node removeNode(Node node) {
        if (node.left!=null && node.right!=null){
            int max = max(node.left);
            node.data=max;
            node.left=removeNodeBst(node.left,max);
            return node;
        } else if (node.left!=null) {
            return node.left;
        } else if (node.right!=null) {
            return node.right;
        } else {
            return null;
        }
    }
    private BstPenta getLargestBstSize(Node root) {
        if (root == null) {
            return new BstPenta();
        }

        BstPenta lt = getLargestBstSize(root.left);
        BstPenta rt = getLargestBstSize(root.right);

        BstPenta mt = new BstPenta();
        mt.min = Math.min(root.data, Math.min(lt.min, rt.min));
        mt.max = Math.max(root.data, Math.max(lt.max, rt.max));

        boolean nIsBst = root.data > lt.max && root.data < rt.min;
        mt.isBst = (lt.isBst==true) && (rt.isBst==true) && (nIsBst==true);
        if (mt.isBst == true) {
            mt.largestBstNode = root;
            mt.largestBstNodeSize = lt.largestBstNodeSize + rt.largestBstNodeSize + 1;
        } else if (lt.largestBstNodeSize > rt.largestBstNodeSize) {
            mt.largestBstNode = lt.largestBstNode;
            mt.largestBstNodeSize = lt.largestBstNodeSize;
        } else {
            mt.largestBstNode = rt.largestBstNode;
            mt.largestBstNodeSize = rt.largestBstNodeSize;
        }
        return mt;
    }
    private boolean isBst(Node root, BstTriplet bstTriplet) {
        if (root==null) return true;
        if (root.data<bstTriplet.min || root.data>bstTriplet.max) return false;
        return isBst(root.left,new BstTriplet(bstTriplet.min,root.data)) && isBst(root.right,new BstTriplet(root.data,bstTriplet.max));
    }
    class BstPenta{
        int min= Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        boolean isBst=true;
        Node largestBstNode=null;
        int largestBstNodeSize=0;
        BstPenta(){}
    }
    class BstTriplet{
        int min ;
        int max ;
        boolean isBst;
        BstTriplet(int min , int max){
            this.min=min;
            this.max=max;
        }
    }
    class DiaPair{
        int ht ;
        int dia ;
        DiaPair(){
            this.ht=-1;
            this.dia=0;
        }

        @Override
        public String toString() {
            return "DiaPair{" +
                    "ht=" + ht +
                    ", dia=" + dia +
                    '}';
        }
    }
    class Node {
        int data ;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    class Pair{
        Node node;
        int state;
        Pair(Node node, int state){
            this.node=node;
            this.state=state;
        }
    }
    class TiltTriplet{
        int sum ;
        int nodeTilt;
        int treeTilt;
        public TiltTriplet(){
            this.sum=0;
            this.nodeTilt=0;
            this.treeTilt=0;
        }

        @Override
        public String toString() {
            return "TiltTriplet{" +
                    "sum=" + sum +
                    ", nodeTilt=" + nodeTilt +
                    ", treeTilt=" + treeTilt +
                    '}';
        }
    }
}
