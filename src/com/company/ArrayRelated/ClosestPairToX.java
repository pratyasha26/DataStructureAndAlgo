package com.company.ArrayRelated;

public class ClosestPairToX {
    public static void main(String args[]){
        int ar[]={-10,-2,28,29,30};
        int x=54;
        getPair(ar,x);
    }

    private static void getPair(int[] ar, int x) {
        int diff=Integer.MAX_VALUE;
        int curDiff=diff;
        int i=0;
        int sum;
        int j=ar.length-1;
        int res_l = 0;
        int res_r = 0;
     while(i<j){
         sum=Math.abs(ar[i])+Math.abs(ar[j]);
         diff=Math.abs(x-sum);
             if (curDiff > diff) {
                 curDiff = diff;
                 res_l = i;
                 res_r = j;

         }
             if(diff==0){
                 res_l=i;
                 res_r=j;
                 return;
             }
             i++;
         }
         System.out.println("pair: "+ar[res_l] +" , " +ar[res_r] );

    }
}
