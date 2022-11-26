package BinaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import BinaryTree.BinaryTreeImpl.Node;

public class BinaryTreeTest {
    public static void main(String[] args) {
        BinaryTreeImpl obj = new BinaryTreeImpl();
        List<Integer> list = Arrays.asList(50,25,12,null,null,37,30,null,null,null,75,62,null,70,null,null,87,null,null);
        Node root = obj.construct(list);
//        obj.display(root);
//        System.out.println();
//        System.out.println("size of Btree : "+obj.size(root));
//        System.out.println("sum of Btree : "+obj.sum(root));
//        System.out.println("max of Btree is : "+obj.max(root));
//        System.out.println("height of Btree : "+obj.height(root));
        obj.levelOrder(root);
//        obj.levelOrder2(root);
//        obj.levelOrder3(root);
//        System.out.println(obj.find(root,50)==true?"present":"not present");
//        Node node = obj.normalToLeftClone(root);
//        obj.display(node);
//        node = obj.leftCloneToNormal(node);
//        System.out.println();
//        obj.display(node);
//        System.out.println(obj.nodeToRootPath(root,60));
//        obj.printKLevelDown(root,2);
//        obj.printKNodesFar(root,37,1);
//        System.out.println("preorder : "+obj.preorder(root,new ArrayList<>()));
//        System.out.println("inorder : "+obj.inorder(root,new ArrayList<>()));
//        System.out.println("postorder : "+obj.postorder(root,new ArrayList<>()));
//        obj.iterativeTraversal(root);
//        obj.levelOrder(obj.removeLeaves(root));
//        obj.printSingleChild(root,null);
        System.out.println(obj.isBST(root));
        System.out.println(obj.largestBST(root));
    }
}
