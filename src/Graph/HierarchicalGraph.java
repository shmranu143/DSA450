package Graph;
import java.util.*;
import java.util.stream.Collectors;

public class HierarchicalGraph {

    public static List<Integer> findDirectChildren(int n, int[][] nodes) {
        Map<Integer, List<Integer>> adjacencyList = buildAdjacencyList(n, nodes);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> directChildren = getDirectChildren(i, adjacencyList);
            result.addAll(directChildren);
            result.add(-1); // Separator for the next node
        }

        return result;
    }

    private static Map<Integer, List<Integer>> buildAdjacencyList(int n, int[][] nodes) {
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        int k=0;
        for (int[] innerArray : nodes) {
            List<Integer> innerList = new ArrayList<>();
            for (int value : innerArray) {
                innerList.add(value);
            }
            adjacencyList.put(k++,innerList);
        }
        System.out.println(adjacencyList);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isProperSubset(adjacencyList.get(i), adjacencyList.get(j))) {
                    System.out.println("list\n"+adjacencyList);
                    adjacencyList.get(j).clear();
                } else if (isProperSubset(adjacencyList.get(j), adjacencyList.get(i))) {
                    adjacencyList.get(i).clear();
                }
            }
        }

        return adjacencyList;
    }

    private static List<Integer> getDirectChildren(int node, Map<Integer, List<Integer>> adjacencyList) {
        List<Integer> directChildren = new ArrayList<>();
        List<Integer> currentNode = adjacencyList.get(node);

        for (int i = 0; i < adjacencyList.size(); i++) {
            if (i != node && isProperSubset(currentNode, adjacencyList.get(i))) {
                directChildren.add(i);
            }
        }

        return directChildren;
    }

    private static boolean isProperSubset(List<Integer> set1, List<Integer> set2) {
        return set2.containsAll(set1) && !set1.equals(set2);
    }

    private static List<Integer> toList(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int num : array) {
            list.add(num);
        }
        return list;
    }

    public static void main(String[] args) {
        int n = 7;
        int[][] nodes = {
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                {2, 4, 6, 8, 10, 12, 14},
                {1, 2, 3, 4, 5, 7},
                {1, 2, 3},
                {4, 5, 6},
                {2, 4, 6},
                {2}
        };
        System.out.println("nodes\n"+ Arrays.stream(nodes).collect(Collectors.toList()).get(0).length);
        List<Integer> result = findDirectChildren(n, nodes);
        System.out.println(result);
    }
}
