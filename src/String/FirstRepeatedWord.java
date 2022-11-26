package String;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstRepeatedWord {
    public static void main(String[] args) {
        String str = "Ravi had been saying that he there";
        String result = findRepeatedWord(str);
        System.out.println(result);
    }

    private static String findRepeatedWord(String str) {
//        HashMap<String,Integer> map = new HashMap<>();
        Map<String,Integer> map = new LinkedHashMap<>();
        String [] strInput = str.trim().split(" ");
        for (int i=0; i<strInput.length;i++){
            if (map.containsKey(strInput[i])){
                map.put(strInput[i],map.get(strInput[i])+1);
            }
            map.putIfAbsent(strInput[i],1);
        }
        System.out.println(map);
        for (Map.Entry<String , Integer> entry: map.entrySet()) {
//            System.out.println("Key = " + entry.getKey() +
//                    ", Value = " + entry.getValue());
            if (entry.getValue() > 1)
                return entry.getKey();
        }
        return "NO repeated words";

    }
}
