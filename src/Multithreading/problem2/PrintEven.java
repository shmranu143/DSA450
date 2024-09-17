package Multithreading.problem2;

public class PrintEven extends Thread{
    public void run(){
        try{
            for (int i=2;i<=100;i+=2){
                System.out.println(i);
                Thread.sleep(7);
            }
        } catch (Exception e){

        }
    }
}
