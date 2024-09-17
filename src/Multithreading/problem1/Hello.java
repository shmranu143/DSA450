package Multithreading.problem1;

class Hello extends Thread{

    public void run(){
        for (int i=0;i<5;i++){
            System.out.println("hello");
            try{
                Thread.sleep(100);
            } catch (Exception e){

            }
        }
    }
}
