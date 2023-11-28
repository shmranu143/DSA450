package Array;

import java.util.ArrayList;
import java.util.List;

public class StringListDifference {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        // Add elements to list1 and list2
        list1.add("apple");
        list1.add("Banana");
        list1.add("orange");

        list2.add("banana");
        list2.add("grape");

        List<String> result = findMissingStrings(list1, list2);

        System.out.println("Strings present in list1 but not in list2:");
        for (String str : result) {
            System.out.println(str);
        }
    }

    public static List<String> findMissingStrings(List<String> list1, List<String> list2) {
        List<String> missingStrings = new ArrayList<>();

        for (String str1 : list1) {
            boolean found = false;
            for (String str2 : list2) {
                if (str1.equals(str2)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                missingStrings.add(str1);
            }
        }

        return missingStrings;
    }
}
