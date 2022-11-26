package Array;

public class Sort012 {
    public static void main(String[] args) {
        int [] arr = new int[]{0,2,1,2,0};
        sort012(arr, arr.length);
    }

    private static void sort012(int[] a, int n)
    {
        // code here a
        int count0 = 0 , count1=0,count2=0;
        for(int i=0;i<n;i++){
            if(a[i]==0) count0++;
            if(a[i]==1) count1++;
        }
        int i =0;
        count2 = n-count1-count0;
            while(count0>0){
                a[i]=0;
                count0--;
                i++;
            }
            while(count1>0){
                a[i]=1;
                count1--;
                i++;
            }
            while(count2>0){
                a[i]=2;
                count2--;
                i++;
            }
        for (int j=0;j< a.length;j++)
            System.out.print(a[i]+" ");
    }
}

