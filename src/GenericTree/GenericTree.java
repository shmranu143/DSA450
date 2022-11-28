package GenericTree;
import java.util.List;
public interface GenericTree {
    public int sizeOfGenTree(GenericTreeImpl.Node root);
    public void levelOrderZigzag(GenericTreeImpl.Node root);
    void levelOrder(GenericTreeImpl.Node root);
    void leveOrderLinewise(GenericTreeImpl.Node root);
    GenericTreeImpl.Node construct(int arr[]);
    int maxOfTree(GenericTreeImpl.Node root);
    int minOfTree(GenericTreeImpl.Node root);
    int heightOfGenTree(GenericTreeImpl.Node root);
    void traversArea(GenericTreeImpl.Node root);
    List<Integer> serialize(GenericTreeImpl.Node root , List<Integer> list);
    void mirrorGenTree(GenericTreeImpl.Node root);
    void removeLeaves(GenericTreeImpl.Node root);
    void linearize(GenericTreeImpl.Node root);
    List<Integer> nodeToRoot(GenericTreeImpl.Node root,int data);
    int lowestCommonAnchestor(GenericTreeImpl.Node root , int child1 , int child2);
    int distanceBetweenNodes(GenericTreeImpl.Node root , int child1 , int child2);
    boolean similarShape(GenericTreeImpl.Node root1 , GenericTreeImpl.Node root2);
    boolean mirrorInShape(GenericTreeImpl.Node root1 , GenericTreeImpl.Node root2);
    boolean isSymetric(GenericTreeImpl.Node root);
    int kthLargest(GenericTreeImpl.Node root, int k);
    void predAndSucc(GenericTreeImpl.Node root , int data);
    void iterativeTravers(GenericTreeImpl.Node root );
}
