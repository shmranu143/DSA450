package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import BinaryTree.BinaryTreeImpl.Node;

public interface BinaryTree {
    public Node construct(List<Integer> list);
    public void display(BinaryTreeImpl.Node node);
    int size(Node node);
    int sum(Node node);
    int max(Node node);
    int height(Node node);
    void levelOrder(Node node);
    void levelOrder2(Node node);
    void levelOrder3(Node node);
    boolean find(Node node, int data);
    ArrayList<Node> nodeToRootPath(Node node, int data);
    void printKLevelDown(Node node,int k);
    /**
     * very very important sawal hai niche wala
     */
    void printKNodesFar(Node root,int data, int k);
    List<Integer> preorder(Node root,List<Integer> list);
    List<Integer> inorder(Node root,List<Integer> list);
    List<Integer> postorder(Node root,List<Integer> list);
    void iterativeTraversal(Node root);
    Node normalToLeftClone(Node root);
    Node leftCloneToNormal(Node root);
    Node removeLeaves(Node root);
    void printSingleChild(Node root, Node parent);
    void pathToLeafFromRoot(Node node , String path , int sum , int low , int high);
    int diameter(Node node);
    BinaryTreeImpl.DiaPair diameter2(Node node);
    BinaryTreeImpl.TiltTriplet tiltOfBTree(Node root); // try two approaches (1. traverse and tweek , 2. pair wala)
    boolean isBalanced(Node root);  // try two approaches (1. traverse and tweek , 2. pair wala)

    /**
     * BST started
     */
    boolean isBST(Node root); // can not be done using traverse and tweek
    int largestBST(Node root);
    Node SortedArrayToBst(int []arr) ;
    int sumOfBst(Node node);
    int maxOfBst(Node node);
    int minOfBst(Node node);
    boolean findInBst(Node node,int data);
    Node replaceWithSumOfLarger(Node node);
    void printInBetween(Node node);
    int lca(Node node);
    void targetSumPair(Node node, int target);   // find and arrayList approach
    void targetSumPair2(Node node, int target); // 2 stack approach (optimised)
    Node addNodeBst(Node node,int data);
    Node removeNodeBst(Node node,int data);
    Node cuntructTreeFromPreAndIn(int[] preorder , int[] inorder);
    boolean isCompleteBT(Node node);

}
