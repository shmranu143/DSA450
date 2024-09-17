package Multithreading.problem2;

public class Solution{

    /**
     * the bolow solution works but it does not guarantee always
     * the output in the same order
     * to ensure - you can use synchronization
     * @param args
     */
    public static void main(String[] args) {
        PrintOdd odd = new PrintOdd();
        PrintEven even = new PrintEven();
        odd.start();
        try{
            Thread.sleep(3);
        } catch (Exception e){}
        even.start();
    }
}
