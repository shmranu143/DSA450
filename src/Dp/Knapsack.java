package Dp;

public class Knapsack
{
    //Function to return max value that can be put in knapsack of capacity W.

    static int knapSackRecursive(int W, int[] wt, int[] val, int n) {
        if(W==0 || n==0) return 0;
        if (wt[n-1]<=W){
            return Math.max(val[n-1]+knapSackRecursive(W-wt[n-1],wt,val,n-1),knapSackRecursive(W,wt,val,n-1));
        }
        else{
            return knapSackRecursive(W,wt,val,n-1);
        }
    }

    // bottom-up dp(recursion+memorisation)
    static int knapSackRecursiveMemo(int W, int wt[], int val[], int n)
    {
        // your code here
        int [][]t=new int[n+1][W+1];
        for (int i=0;i<=n;i++){
            for (int j=0;j<=W;j++){
                t[i][j]=-1;
            }
        }
        return knapSackDp(W,wt,val,n,t);
    }

    private static int knapSackDp(int W, int[] wt, int[] val, int n, int[][] t) {
        if(W==0 || n==0) return 0;
        if (t[n][W]!=-1) return t[n][W];
        if (wt[n-1]<=W){
            return t[n][W]=Math.max(val[n-1]+knapSackDp(W-wt[n-1],wt,val,n-1,t),knapSackDp(W,wt,val,n-1,t));
        }
        else{
            return t[n][W]=knapSackDp(W,wt,val,n-1,t);
        }
    }


    // knapsack top-down (iterative)
    static int knapSackIterativeMemo(int W, int wt[], int val[], int n){
        int [][]t=new int[n+1][W+1];
        for (int i=1;i<n+1;i++){
            for (int j=1;j<W+1;j++){
                if (wt[i-1]<=j){
                    t[i][j]=Math.max(val[i-1]+t[i-1][j-wt[i-1]],t[i-1][j]);
                }
                else t[i][j]=t[i-1][j];
            }
        }
        return t[n][W];
    }
}