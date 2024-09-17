package Multithreading.problem1;

public class Solution {
    public static void main(String[] args) {
        Hi hi = new Hi();
        Hello hello = new Hello();
        hi.start();
        try{
            Thread.sleep(10);
        } catch (Exception e){

        }
        hello.start();
    }
}
