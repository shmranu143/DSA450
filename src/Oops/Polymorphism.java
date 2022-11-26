package Oops;


/**
 * method overloading example
 */
public class Polymorphism {

    public void showNum(int num, long num2){
        System.out.println("int , long :"+num+" "+num2);
    }
    public void showNum(long num, int num2){
        System.out.println("long , int :"+num+" "+num2);
    }
    public static void showNum(int num , int num2){
        System.out.println("int , long :"+num+" "+num2);
//        return num;
    }
//    public static int showNum(long num , int num2){
//        System.out.println("int , long :"+num+" "+num2);
//        return num2;
//    }
    public static void showNum(double num , int num2){
        System.out.println("double , int "+num +" "+num2);
    }
    public static void showNum(float num , int num2){
        System.out.println("float , int "+num +" "+num2);
    }
    public static void main(String[] args) {
        Polymorphism obj = new Polymorphism();
        obj.showNum(2,2l);
        obj.showNum( 5,7);
        obj.showNum(0.5,3);

    }
}
