package String;

public class StringAndObject {


    public static void main(String[] args) {
        String str = "my string";
        Object obj = str;
        System.out.println(obj.getClass()+" "+str.trim());
    }
}
