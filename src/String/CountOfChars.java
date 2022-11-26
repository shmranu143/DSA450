package String;

import java.util.HashMap;

public class CountOfChars {
    public static void main(String[] args) {
        String str = "my name is shubham";
        String[] strNext = str.split(" ");
        for (int i=0;i< strNext.length;i++){
            System.out.print(strNext[i]);
        }
        System.out.println();
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i=0;i<str.length();i++){
            if(!map.containsKey(str.charAt(i))){
                map.put(str.charAt(i),1);
            }
            else {
                int value = map.get(str.charAt(i));
                map.put(str.charAt(i),value+1);
            }
        }
        for (HashMap.Entry<Character,Integer> entry : map.entrySet())
            System.out.println("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());
    }
}
