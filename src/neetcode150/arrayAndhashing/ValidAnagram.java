package neetcode150.arrayAndhashing;

/**
 * Problem
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * <p>
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] arr = new int[27];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 0;
        }
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 97]++;
            arr[t.charAt(i) - 97]--;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) return false;
        }
        return true;

    }
}
