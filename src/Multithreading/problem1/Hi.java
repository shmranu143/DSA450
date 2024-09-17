package Multithreading.problem1;

class Hi extends Thread{

    public void run(){
        for (int i=0;i<5;i++){
            System.out.println("hi");
            try{
                Thread.sleep(100);
            } catch (Exception e){

            }
        }
    }
}
