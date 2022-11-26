package Oops;

public class FinalKeyword {

    final int MIN = 0;
    final int MAX; // initialised below in instance initialiser block

    final int A; // initialised below in constructor

    static final int B = 5;
    static final int C; // initialised below in static block

    {
        MAX = 100;
    }
//    public FinalKeyword(){
//        A=20;
//    }
    public FinalKeyword(int b){
        this.A=b;
    }
    static {
        C=10;
    }

}
