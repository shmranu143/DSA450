package String;


public class Reverse {
    public static void main(String[] args) {
        char[] str = {'h','e','l','l','o'};
        char[] result = reverse(str);
        System.out.println(result);
    }
    public static char[] reverse(char [] str){
        if(str.length<=1) return str;
        int halfSize = (str.length)/2;
        int size = str.length;
        for (int i=0;i<halfSize;i++){
            char temp = str[i];
            str[i]=str[size-1];
            str[size-1]=temp;
            size--;
//            System.out.println(temp+" "+str[i]+" "+str[size-1]);
        }
        return str;
    }

}
