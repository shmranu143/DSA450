package String;


public class Subsequence {
    public static void main(String[] args) {
        String str = "abc";
        String res = " ";
        int index = 0;
        getAllSubsequence(str,res,index);
    }
    private static void getAllSubsequence(String str, String res, int index) {
        if(index == str.length()){
            System.out.print(res+" ");
            return;
        }
        getAllSubsequence(str,res,index+1);
        getAllSubsequence(str,res+str.charAt(index),index+1);
    }
}
