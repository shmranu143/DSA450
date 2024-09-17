package neetcode150.arrayAndhashing;

import java.util.ArrayList;
import java.util.List;

/**
 * problem-Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 */


public class GroupAnagram {
    public List<List<String>> groupAnagrams(String[] s) {
        List<List<String>> result = new ArrayList<>();
        boolean [] visited = new boolean[s.length]; // space -> 100
        for(int i=0;i<s.length;i++){
            int [] freq = new int[26];// space -> 100*26
            List<String> list = new ArrayList<>();// space -> 10^4
            if(visited[i]){
                continue;
            }
            list.add(s[i]);
            String str = s[i];
            System.out.println(str);
            for(int j=0;j<str.length();j++){
                freq[str.charAt(j)-97]++;
            }
            int [] tempFreq = new int[26]; // space -> 100*26
            for(int x=0;x<26;x++){
                tempFreq[x]=freq[x];
            }
            for(int k=i+1;k<s.length;k++){
                boolean flag =true;
                String strNext = s[k];
                for(int l=0;l<strNext.length();l++){
                    tempFreq[strNext.charAt(l)-97]--;
                }
                for(int l=0;l<tempFreq.length;l++){
                    if(tempFreq[l]!=0){
                        flag = false;
                        break;
                    }
                }
                for(int x=0;x<26;x++){
                    tempFreq[x]=freq[x];
                }
                if(flag) {
                    visited[k]=true;
                    list.add(strNext);
                }
            }
            result.add(list);
        }
        return result;
    }
}