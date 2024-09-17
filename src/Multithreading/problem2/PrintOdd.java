package Multithreading.problem2;

public class PrintOdd extends Thread{
    public void run(){
        try{
            for (int i=1;i<100;i+=2){
                System.out.println(i);
                Thread.sleep(7);
            }
        } catch (Exception e){

        }

    }
}
