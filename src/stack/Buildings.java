package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Buildings {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str[]= br.readLine().trim().split(" ");
        Set<Integer> buildings = new HashSet<>();
//        Stack<Integer> stack = new Stack<>();
        int max_building = Integer.parseInt(str[0]);
        buildings.add(max_building);
        for (int i=1;i<n;i++){
            int val = Integer.parseInt(str[i]);
            if(val>max_building){
                max_building=val;
                buildings.add(max_building);
            }
        }
        System.out.println(buildings.size()+" : "+buildings);
    }

}

