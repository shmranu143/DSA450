package Oops;

/**
 * 1- static method can not be overriden
 * 2- Since Java8 you can have static methods in an interface (with body).
 * 3- final method can not be overriden
 */
public class Inheritance extends Parent implements Parents{
//    public static void sing(){
//        System.out.println("I am singing");
//    }
//    void dance(){
//        System.out.println("i m am dancing");
//    }
    private int data;
    public Inheritance(){
        data = 6;
    }
    public int getData(){
        return data;
    }

    public static void main(String[] args) {
        Inheritance obj = new Inheritance();
        System.out.println(obj.getData());
//        Parents pr = new Inheritance();
//        Parent p = new Inheritance();
//        p.dance();
//        Parents.sing();

    }
}

class Parent {
      final void dance(){
        System.out.println("parent is dancing");
    }
    private int data;
      public Parent(){
          data =5;
      }
      public int getData(){
          return this.data;
      }
}

interface Parents{
    static void sing(){
        System.out.println("parents are singing");
    }
}
