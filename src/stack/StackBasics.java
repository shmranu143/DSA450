package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class StackBasics {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String str= br.readLine();
//        System.out.println(findDuplicate(str));
//        System.out.println(balancedBrackets(str));
//        printNextGreaterElementToRight(str);
        System.out.println(isValid("()"));
    }
    public static  boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='(' || ch=='{' || ch=='[') st.push(ch);
            else if((ch==')' && st.peek()=='(') || (ch=='}' && st.peek()=='{') || (ch==']' && st.peek()=='[')) st.pop();
        }
        if(st.isEmpty()) return true;
        return false;
    }

    private static void printNextGreaterElementToRight(String str) {
        String s[] = str.trim().split(" ");
        int n=s.length;
        int nextGreater[] = new int[n];
        Stack<Integer> st = new Stack<>();
        st.add(Integer.parseInt(s[n-1]));
        nextGreater[n-1]=-1;
        for (int i =n-2;i>=0;i--){
            int num = Integer.parseInt(s[i]);
            if(!st.empty() && st.peek()<=num){
                while (st.peek()<=num){
                    st.pop();
                }
                nextGreater[i]=st.empty()?-1:st.peek();
                st.add(num);
            } else {
                nextGreater[i]=st.peek();
                st.add(num);
            }
        }
        for (int i =0;i<n;i++){
            System.out.println("next greater to "+s[i]+" is :"+nextGreater[i]);
        }
    }

    private static boolean balancedBrackets(String str) {
        Stack<Character> st = new Stack<>();
        for (int i=0;i<str.length();i++){
            Character ch = str.charAt(i);
            if (ch==')'){
                try{
                    while (st.peek()!='('){
                        st.pop();
                    }
                    st.pop();
                } catch (Exception e){
                    System.out.println("empty stack :"+e);
                    return false;
                }
            } else{
                st.add(ch);
            }
        }
        return true;
    }

    private static boolean findDuplicate(String str) {
        Stack<Character> st = new Stack<>();
        boolean flag = false;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)!=' ' && str.charAt(i)!=')'){
                st.add(str.charAt(i));
            }
            else if(str.charAt(i)!=' ' && str.charAt(i)==')'){
                while (st.peek()!='('){
                    st.pop();
                    flag = true;
                }
                if(!flag){
                    return true;
                }
                st.pop();
            }
            flag=false;
        }
        return false;
    }
}
