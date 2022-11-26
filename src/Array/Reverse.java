package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reverse {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        String[] str = br.readLine().trim().split(" ");
        int arr[] = new int[size];
        for(int i=0;i<size;i++){
            arr[i]= Integer.parseInt(str[i]);
        }
        int temp =size;
        for(int i=0;i<size;i++){
            System.out.print(arr[temp-1]+" ");
            temp--;
        }
    }
}
