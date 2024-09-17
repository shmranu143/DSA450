package String;

import java.util.ArrayDeque;
import java.util.Queue;
// r101
public class AreStringRotation {
    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = "cdeab";
        areRotation(str1,str2);
    }

    private static void areRotation(String str1, String str2) {
        if(str1.length()!=str2.length()){
            return;
        }
        Queue<Character> q1 = new ArrayDeque<>();
        Queue<Character> q2 = new ArrayDeque<>();
        for (int i=0;i< str1.length();i++){
            q1.add(str1.charAt(i));
            q2.add(str2.charAt(i));
        }
        for (int i=0;i< str1.length();i++) {
            if(q1.toString().equals(q2.toString())){
                System.out.println("given strings are rotation of each other");
                return;
            }
            char temp = q2.poll();
            q2.add(temp);
        }
        System.out.println("given strings are not rotation of each other");
        }
}
