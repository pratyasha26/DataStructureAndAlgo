package com.company.ArrayRelated;

public class CountOneInSortedArray {
    public static void main(String args[]){
        int ar[]={1,1,1,1,1,0,0,0,0};
       System.out.println("Nummber of 1's : "+ countOnes(ar,0,ar.length-1));
    }

    private static int countOnes(int[] ar,int low,int high) {
        int mid=0;
        int res=0;
        if(ar[high]>1){
            return 0;
        }
        if(low<high){
            mid=(low+high)/2;
            if(ar[mid]>1){
                high=mid-1;
                countOnes(ar,low,high);
            }
            else if(ar[mid]<1){
                low=mid+1;
                countOnes(ar,low,high);
            }
            if(ar[mid]==1){
                low=mid+1;
                res+=mid;
                countOnes(ar,low,high);
            }
        }
        if(res==0){
            return res;
        }
        return res+1;
    }

}
