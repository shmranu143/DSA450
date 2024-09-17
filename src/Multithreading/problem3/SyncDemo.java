package Multithreading.problem3;

class Counter {
    int c ;

    public synchronized void increment(){
        c++; // c=c+1;
    }
}

public class SyncDemo {
    public static void main(String[] args) throws InterruptedException {
        Counter count = new Counter();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i =0;i<1000;i++){
                    count.increment();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i =0;i<1000;i++){
                    count.increment();
                }
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(count.c);
    }
}
