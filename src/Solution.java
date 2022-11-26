import java.util.HashMap;

class Solution {
    public static void main (String args[]){
        HashMap<Character,Integer> map = new HashMap<>();
        String str = "ggffaaaaiittrrrrrr";
        for(int i=0;i<str.length();i++){
            if(map.containsKey(str.charAt(i))){
//                int value = map.get(str.charAt(i));
//                map.put(str.charAt(i),map.get(str.charAt(i)+1));
                map.put(str.charAt(i),map.get(str.charAt(i)+1));
            }
            else map.put(str.charAt(i),1);
        }
        System.out.println(map);
    }


}