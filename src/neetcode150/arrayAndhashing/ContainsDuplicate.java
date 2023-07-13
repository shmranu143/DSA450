package neetcode150.arrayAndhashing;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,2,5};
        System.out.println(containsDuplicate(nums));
    }
    public static boolean containsDuplicate(int[] nums) {
//        return nums.length!=Arrays.stream(nums).collect(Collectors.toSet()).size();
        return Arrays.stream(nums).boxed().toArray( Integer[]::new ).length!=Arrays.stream(Arrays.stream(nums).boxed().toArray( Integer[]::new )).collect(Collectors.toSet()).size();
    }
}
