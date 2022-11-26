package Dp;

// lcs with dp
public class LCS
{
    static int lcs(int x, int y, String s1, String s2)
    {
        // your code here
        int [][]t = new int[x+1][y+1];
        for (int i=0;i<=x;i++){
            for (int j=0;j<=y;j++){
                t[i][j]=-1;
            }
        }
        return lcsFunc(x,y,s1,s2,t);
    }

    private static int lcsFunc(int x, int y, String s1, String s2,int [][]t) {
        if(x==0 || y==0) return 0;
        if (t[x][y]!=-1){
            return t[x][y];
        }
        if(s1.charAt(x-1)==s2.charAt(y-1)){
            return t[x][y]=lcsFunc(x-1,y-1,s1,s2,t)+1;
        }
        else {
            return t[x][y]=Math.max(lcsFunc(x-1,y,s1,s2,t),lcsFunc(x,y-1,s1,s2,t));
        }
    }

    public static String countSort(String arr)
    {
        // code here
        int []count = new int[26];
        char ch[] = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        for (int i=0;i<arr.length();i++){
            count[arr.charAt(i)-'a']++;
        }
        String res="";
        for (int i=0;i<26;i++){
            int j=i;
            while(count[j]>0){
//                res+=ch[i];
                res+=(char)(i+97);
                j--;
            }
        }
        return res;

    }

}



class Solution
{
    //Function to merge the arrays.
    public static void merge(long arr1[], long arr2[], int n, int m)
    {
        // code here
        int gap = getGap(n+m);
        while (gap>=1){
            int i=0;int j=gap;
            if (j>=n) j=gap-n;
            while (i<n && j<m){
                if (arr1[i]>arr2[j]){
                    long temp = arr1[i];
                    arr1[i]=arr2[j];
                    arr2[j]=temp;
                }
                i++;
                j++;
            }
            if (j>=m) gap=getGap(gap);
            else if (i==n){
                i=0;
                while (j<m){
                    if (arr2[i]>arr2[j]){
                        long temp = arr2[i];
                        arr2[i]=arr2[j];
                        arr2[j]=temp;
                    }
                    i++;
                    j++;
                }
                gap=getGap(gap);
            }

        }
    }

    private static int getGap(int n) {
        if((n)%2==0) return (n)/2;
        else return ((n)/2)+1;
    }
}

