package GenericTree;

import java.util.*;

public class GenericTreeImpl implements GenericTree {
    public static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
        Node(int data){
            this.data=data;
        }
    }
    @Override
    public int sizeOfGenTree(Node root) {
        int size =0;
        for (Node child:root.children){
            size+=sizeOfGenTree(child);
        }
        return size+1;
    }
    static Node Null = new Node(-1);

    @Override
    public void levelOrderZigzag(Node root){
        LinkedList<Node> q1 = new LinkedList<>();
        LinkedList<Node> q2 = new LinkedList<>();
        boolean shuldReverse = false;
        q1.addLast(root);
        q1.addLast(Null);
        while(!q1.isEmpty()){
            Node temp = q1.removeFirst();
            if (temp==Null){
                q2.addLast(Null);
                shuldReverse=shuldReverse==true?false:true;
                System.out.println();
                if (q1.isEmpty() && q2.size()>1){
                    q1=q2;
                    q2=new LinkedList<>();
                }
                continue;
            }
            System.out.print(temp.data+" ");
            int size = temp.children.size();

            if (shuldReverse){
                for (int i =size-1;i>=0;i--){
                    q2.addFirst(temp.children.get(i));
                }
            }
            else {
                for (Node child: temp.children){
                    q2.addFirst(child);
                }
            }


        }
    }
//    public void levelOrderZigzag(Node root) {
//        Queue<Node> queue = new LinkedList<>();
////        Queue<Node> cQueue = new ArrayDeque<>();
//        queue.add(root);
//        queue.add(Null);
//        boolean hasNull = true;
//        boolean shouldRev = false;
//        while (!queue.isEmpty()){
//            hasNull=false;
//            Node temp = queue.remove();
//            if(temp==Null) {
//                if(shouldRev){
//                    //reverse queue
//                    int size=queue.size();
//                    Stack<Node> st = new Stack<>();
//                    while(!queue.isEmpty()){
//                        st.add(queue.peek());
//                        queue.remove();
//                    }
////                    size=st.size();
//                    while(!st.isEmpty()){
//                        queue.add(st.peek());
//                        st.pop();
//                    }
//                }
//                continue;
//            }
//            System.out.print(temp.data+" ");
//            if (queue.peek()==Null) {
//                System.out.println();
//                hasNull=true;
//            }
//            for (Node child: temp.children){
//                queue.add(child);
//            }
//            if (hasNull) {
//                queue.add(Null);
//                shouldRev=shouldRev==true?false:true;
//            }
//        }
//        System.out.println("------------------");
//
//    }
    @Override
    public void levelOrder(Node root) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node temp = queue.remove();
            System.out.print(temp.data+" ");
            for(Node child : temp.children){
                queue.add(child);
            }
        }
        System.out.println("------------------");
    }
    @Override
    public void leveOrderLinewise(Node root){
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        queue.add(Null);
        boolean hasNull = true;
        while (!queue.isEmpty()){
            hasNull=false;
            Node temp = queue.remove();
            if (temp==Null) continue;
            System.out.print(temp.data+" ");
            if(queue.peek()==Null){
                hasNull=true;
                System.out.println();
            }
            for(Node child: temp.children){
                queue.add(child);
            }
            if (hasNull) queue.add(Null);
        }
        System.out.println("-----------------");
    }

    @Override
    public Node construct(int[] arr) {
        Node root = null;
        Stack<Node> st = new Stack<>();
        for (int data:arr){
            if (st.isEmpty()) st.add(new Node(data));
            else if(data!=-1){
                st.add(new Node(data));
            } else {
                Node temp = st.pop();
                if (st.isEmpty()) {
                    root = temp;
                    break;
                }
                Node peek = st.peek();
                peek.children.add(temp);

            }
        }
        return root;
    }

    @Override
    public int maxOfTree(Node root) {
        int max=root.data;
        for (Node child:root.children){
            int recMax=maxOfTree(child);
            max=Math.max(recMax,max);
        }
        return max;
    }

    @Override
    public int minOfTree(Node root) {
        int min = root.data;
        for (Node child : root.children){
            int recMin = minOfTree(child);
            min = Math.min(recMin,min);
        }
        return min;
    }

    @Override
    public int heightOfGenTree(Node root) {
        int height =0;// 0 wrt node and 1 wrt edges
//        if (root==null) return height;
//        if (root.children.size()<1) return height+1;
        for (Node child:root.children){
            int curSize = heightOfGenTree(child);
            height=Math.max(curSize,height);
        }
        return height+1;
    }

    @Override
    public void traversArea(Node root) {
        // node pre area
        System.out.println("Node Pre "+root.data);
        // edge pre  and edge post
        for (Node child:root.children){
            System.out.println("Edge Pre "+root.data+"---"+child.data);
            traversArea(child);
            System.out.println("Edge Post "+root.data+"---"+child.data);
        }
        // node post area
        System.out.println("Node Post "+root.data);
    }

    @Override
    public List<Integer> serialize(Node root , List<Integer> list) {
        list.add(root.data);
        for (Node child : root.children){
            serialize(child,list);
        }
        list.add(-1);
        return list;
    }

    @Override
    public void mirrorGenTree(Node root) {
        for (Node child : root.children){
            mirrorGenTree(child);
        }
        Collections.reverse(root.children);
    }

    @Override
    public void removeLeaves(Node root) {
        for (int i =root.children.size()-1;i>=0;i--){
            Node child = root.children.get(i);
            if (child.children.size()<1) root.children.remove(i);
        }
        for (Node child : root.children){
            removeLeaves(child);
        }
    }

    @Override
    public void linearize(Node root) {
        for (Node child : root.children){
            linearize(child);
        }
        while(root.children.size()>1){
            Node last = root.children.remove(root.children.size()-1);
            Node slast = root.children.get(root.children.size()-1);
            Node tail = gettail(slast);
            tail.children.add(last);
        }
    }

    @Override
    public List<Integer> nodeToRoot(Node root,int data) {
        List<Integer> list = new ArrayList<>();
        if(root.data==data) {
            list.add(data);
            return list;
        }
        for (Node child: root.children){
            List<Integer> templist = null;
            templist = nodeToRoot(child,data);
            if (!templist.isEmpty()) {
                list=templist;
                list.add(root.data);
            }
        }
        return list;
    }

    @Override
    public int lowestCommonAnchestor(Node root, int child1, int child2) {
        List<Integer> list1 = nodeToRoot(root,child1);
        List<Integer> list2 = nodeToRoot(root,child2);
        int res = -1;
        while(!list1.isEmpty() && !list2.isEmpty()){
            int lca1=list1.remove(list1.size()-1);
            int lca2=list2.remove(list2.size()-1);
            if(lca1!=lca2) return res;
            res=lca1;
        }
        return res;
    }

    @Override
    public int distanceBetweenNodes(Node root, int child1, int child2) {
        int distance =-1;
        List<Integer> list1 = nodeToRoot(root,child1);
        List<Integer> list2 = nodeToRoot(root,child2);
        int lca = -1;
        while(!list1.isEmpty() && !list2.isEmpty()){
            int lca1=list1.remove(list1.size()-1);
            int lca2=list2.remove(list2.size()-1);
            if(lca1!=lca2) break;
            lca=lca1;
        }
        if (lca==-1) return distance;
        distance=list1.size()+list2.size()+2;
        return distance;
    }

    @Override
    public boolean similarShape(Node root1, Node root2) {
        if((root1==null && root2!=null)|| (root2==null && root1!=null)) return false;
        if(root1==null && root2==null) return true;
        int size1 = root1.children.size();
        int size2 = root2.children.size();
        if(size1!=size2) return false;
        for (int i=0;i<size1;i++){
            boolean res =similarShape(root1.children.get(i),root2.children.get(i));
            if(res==false) return false;
        }
        return true;
    }

    @Override
    public boolean mirrorInShape(Node root1, Node root2) {
        if(root1.children.size()!=root2.children.size()) return false;
        int size = root1.children.size();
        for (int i =0;i<size;i++){
            boolean res =  mirrorInShape(root1.children.get(i),root2.children.get(size-1-i));
            if(res==false) return false;
        }
        return true;
    }

    /**
     * hint - symetric tree will be mirror image of itself
     * @param root
     * @return
     */
    @Override
    public boolean isSymetric(Node root) {
        if(mirrorInShape(root,root)) return true;
        return false;
    }

    @Override
    public int kthLargest(Node root, int k) {
        int max = maxOfTree(root);
//        Props props = new Props();
        while (k-->1){
//            props.ceil=Integer.MIN_VALUE;
            Props props = new Props();
            max = getFloor(root,max,props);
        }
        return max;
    }

    static class Props{
        int ceil = Integer.MIN_VALUE;
    }
    private int getFloor(Node root, int max,Props props) {
        if (root.data>props.ceil && root.data<max){
            props.ceil = root.data;
        }
        for (Node child : root.children){
            getFloor(child,max,props);
        }
        return props.ceil;
    }

    static int state=0;
    static Node pred;
    static Node succ;
    @Override
    public void predAndSucc(Node root, int data) {

        if (state==0){
            if (root.data==data) state++;
            else pred=root;
        }
        else if (state==1){
            succ=root;
            state++;
        }
        for (Node child: root.children){
            predAndSucc(child,data);
        }
//        if(state==0) {
//            if (root.data==data){
//                state++;
//            } else {
//                pred=root;
//            }
//        }
//        else if (state==1 && root.data!=data){
//            state=2;
//        }
//        if (state==2) {
//            state=3;
//            succ = root;
//            if (pred!=null) System.out.println("pred: "+pred.data);
//            else System.out.println("pred: rootnode");
//            if (succ!=null) System.out.println("succ: "+succ.data);
////            System.out.println(pred.data+" "+succ.data);
//            return;
//        }
//        for (Node child : root.children){
//            predAndSucc(child,data);
//        }
//        if(pred!=null && succ!=null){
//            System.out.println(pred.data+" "+succ.data);
//        }

    }
    class pair{
        Node node ;
        int state ;
        pair(Node node,int state){
            this.node = node;
            this.state=state;
        }
    }
    @Override
    public void iterativeTravers(Node root) {

        if (root==null) return;
        Stack<pair> stack= new Stack<>();
        stack.push(new pair(root,-1));
        String preorder = "";
        String postorder = "";
        while (!stack.isEmpty()){

            if(stack.peek().state==-1){
                preorder+=stack.peek().node.data+" ";
                stack.peek().state++;
            }
            if(stack.peek().state>=0 && stack.peek().state<stack.peek().node.children.size()){
                stack.add(new pair(stack.peek().node.children.get(stack.peek().state),-1));
            }
            if(stack.peek().state==stack.peek().node.children.size()){
                postorder+=stack.peek().node.data+" ";
                stack.peek().state++;
            }
            if (stack.peek().state>stack.peek().node.children.size()){
                stack.pop();
                if (!stack.isEmpty()) stack.peek().state++;
            }

        }
        System.out.println("preorder: "+preorder);
        System.out.println("postorder: "+postorder);

    }

    private void printSucc(Node root, int data, boolean flag) {
        if (flag){
            System.out.println(root.data);
            return;
        }
        int succ = root.data;
        for (Node child : root.children){
            if(succ==data){
                flag = true;
            }
            printSucc(child,data,flag);
            if (flag) return;
        }
    }

    private void printPred(Node root, int data) {
        int pred = root.data;
        for (Node child : root.children){
            if (data==child.data){
                System.out.println(pred);
                return;
            }
            printPred(child,data);
        }
    }

    private Node gettail(Node slast) {
        Node tail =null;
        while(slast.children.size()>0){
            tail=slast.children.get(0);
        }
        return tail;
    }


    public static void main(String[] args) {
        GenericTreeImpl obj = new GenericTreeImpl();
        Node root = new Node(10);
        Node twenty = new Node(20);
        root.children.add(twenty);
        Node thirty = new Node(30);
        root.children.add(thirty);
        Node forty = new Node(40);
        root.children.add(forty);
        Node fifty = new Node(50);
        twenty.children.add(fifty);
        Node sixty =  new Node(60);
        twenty.children.add(sixty);
        Node seventy = new Node(70);
        thirty.children.add(seventy);
        Node eighty = new Node(80);
        thirty.children.add(eighty);
        Node ninty = new Node(90);
        forty.children.add(ninty);
        Node hundred = new Node(100);
        forty.children.add(hundred);
        Node hundTen = new Node(110);
        eighty.children.add(hundTen);
        Node hund20 = new Node(120);
        eighty.children.add(hund20);
    }
}
