package com.company;

public class InsertionSort {
    public static void main(String[] args) {
        int[] ar = {3, 8, 5, 4, 1, 9, -2};
        int[] ar1 = {10, 80, 30, 90, 40, 50, 70};
        int[] ar2= {10, 80, 30, 90, 40, 50, 70};
//        int[] sortedArrayI = insertionSort(ar);
//        int[] sortedArrayQ = quickSort(ar1, 0, ar1.length);
        int [] sortedArrayM=mergeSort(ar2,0,ar.length-1);
        printArray(ar2);
    }

    private static int[] mergeSort(int[] ar, int low, int high) {
        if(low<high){
            int mid=(low+high)/2;
            mergeSort(ar,low,mid);
            mergeSort(ar,mid+1,high);
            merge(ar,low,mid,high);
        }
        return ar;
    }

    private static void merge(int[] ar, int low, int mid, int high) {
        int i=0;
        int j=0;
        int index=low;
        int n1 = mid - low + 1;
        int n2 = high - mid;
        int l[]=new int[n1];
        int h[]=new int[n2];
        for( i=0;i<n1;i++){
            l[i]=ar[low+i];
        }
        for( i=0;i<n2;i++){
            h[i]=ar[mid+1+i];
        }
        i=0;
        while(i<n1 && j<n2){
            if(l[i]<=h[j]){
                ar[index]=l[i];
                i++;
            }
            else{
                ar[index]=h[j];
                j++;
            }
            index++;
        }
            while(i<n1){
                ar[index]=l[i];
                index++;
                i++;
            }
        while(j<n2){
            ar[index]=h[j];
            index++;
            j++;
        }

    }

    private static int[] quickSort(int[] ar, int low, int high) {
        if (low < high) {
            int pivot = partition(ar, low, high);
            quickSort(ar, low, pivot-1);
            quickSort(ar, pivot+1 , high - 1);
        }

        return ar;
    }

    private static int partition(int[] ar, int low, int high) {
        int p=ar[high-1];
        int j=low-1;
        int temp;
        for(int i=low;i<high-1;i++){
            if(ar[i]<p){
               temp=ar[j+1];
               ar[j+1]=ar[i];
               ar[i]=temp;
               j++;
            }
        }
        temp=ar[j+1];
        ar[j+1]=p;
        ar[high-1]=temp;
        return j+1;
    }

    private static void printArray(int[] ar) {
        for (int i = 0; i < ar.length; i++) {
            System.out.println(ar[i]);
        }
    }

    private static int[] insertionSort(int[] ar) {
        int j;
        int value;
        for (int i = 1; i < ar.length; i++) {
            j = i;
            value = ar[j];
            while (j > 0 && ar[j - 1] > value) {
                ar[j] = ar[j - 1];
                j--;
            }
            ar[j] = value;
        }
        return ar;
    }
}
