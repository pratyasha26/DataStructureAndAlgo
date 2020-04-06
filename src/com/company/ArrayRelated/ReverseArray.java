package com.company.ArrayRelated;

public class ReverseArray {

    public static void main(String args[]){
        int ar[]={1,2,3,4,5};
        for(int i=0;i<ar.length/2;i++){
            int temp=ar[i];
            ar[i]=ar[ar.length-i-1];
            ar[ar.length-1]=temp;
        }
        for(int i=0;i<ar.length;i++){
            System.out.println(ar[i]);
        }
    }
}
