package GenericTree;

import java.util.ArrayList;
import java.util.List;

public class TestGenericTreeImpl extends GenericTreeImpl {

    public static void main(String[] args) {
        GenericTreeImpl obj = new GenericTreeImpl();
        int[] arr = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,-1,40,90,-1,100,-1,-1,-1};
        int[] arr2 = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,-1,40,100,-1,-1};
        Node root = obj.construct(arr);
        Node root2 = obj.construct(arr2);
        obj.leveOrderLinewise(root);
//        obj.levelOrderZigzag(root);
//        List<Integer> list = obj.serialize(root,list);
//        System.out.println(list);
//        obj.removeLeaves(root);
//        obj.linearize(root);
//        obj.leveOrderLinewise(root);
//        System.out.println(obj.sizeOfGenTree(root));
//        System.out.println(obj.maxOfTree(root));
//        System.out.println(obj.heightOfGenTree(root));
//        System.out.println(obj.nodeToRoot(root,110));
//        System.out.println(obj.nodeToRoot(root,70));
//        System.out.println(obj.lowestCommonAnchestor(root,110,100));
//        System.out.println(obj.distanceBetweenNodes(root,110,70));
//        System.out.println(obj.mirrorInShape(root,root));
//        System.out.println(obj.isSymetric(root));
//        System.out.println(obj.kthLargest(root,4));
//        obj.iterativeTravers(root);
        /**
         * print predesessor and successor
         */
        obj.predAndSucc(root,80);
        if (pred!=null)
        System.out.println("pred: "+pred.data);
        else System.out.println("pred: "+root.data);
        if (succ!=null)
        System.out.println("succ: "+succ.data);
        else
        System.out.println("succ: "+null);
        //-------------------------------------


    }

}
