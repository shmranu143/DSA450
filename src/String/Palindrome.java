package String;

public class Palindrome {
    public static void main(String[] args) {
        char[] s = {'a','b','c','b','a'};
        System.out.print(s);
        if (isPalindrome(s)){
            System.out.println(" is palindrome");
        }
        else{
            System.out.println(" is not palindrome");
        }
    }
    public static boolean isPalindrome(char [] str){
        if (str.length<=1) return true;
        int left=0;
        int right= str.length-1;
        while (left<right){
            if(str[left]!=str[right]) return false;
            left++;
            right--;
        }
        return true;
    }
}
