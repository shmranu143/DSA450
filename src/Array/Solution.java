package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Solution {
    public static void main(String[] args) {
        int a = 1;
        a= a++;
        System.out.println(a++);
    }

//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int t = Integer.parseInt(br.readLine());
//        while (t-->0){
//            String str[]= br.readLine().trim().split(" ");
//            long a= Long.parseLong(str[0]);
//            long b= Long.parseLong(str[1]);
//            long c= Long.parseLong(str[2]);
//            long x= Long.parseLong(str[3]);
//            long y= Long.parseLong(str[4]);
//            boolean value = solution(a,b,c,x,y);
//            if (value)
//            System.out.println("YES");
//            else
//                System.out.println("NO");
//        }
//    }
//
//    private static boolean solution(long a, long b, long c, long x, long y) {
//        long max1 = max(a,x);
//        long min1 = min(a,x);
//        long max2 = max(b,y);
//        long min2 = min(b,y);
//        if((max1-min1)+(max2-min2)<=c) return true;
//        return false;
//    }
}
