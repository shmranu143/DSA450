package Oops;

public class Multithreading extends Thread{
    public void run() {
        try {
            System.out.println("thread is running ");
            System.out.println(Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getId());
        } catch (Exception e ){
            System.out.println(e);
        }

    }

    public static void main(String[] args) {
        for (int i =0;i<3;i++){
            Multithreading obj = new Multithreading();
//            Thread obj = new Thread(new Multithreading());
            obj.start();
        }

    }
}