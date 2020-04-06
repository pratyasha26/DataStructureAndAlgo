package com.company.ArrayRelated;

public class KthLargestHeap {

    public static void main(String args[]){
        int arr[] = { 1, 3, 5, 4, 6, 13, 10,
                9, 8, 15, 17 };
        buildHeap(arr, arr.length);

        extractMin(arr, arr.length);
            System.out.println(arr[0]);


     //   System.out.println(arr[0]);
    }

    private static void extractMin(int[] arr, int length) {
        arr[0]=arr[length-1];
        length=length-1;
        heapify(arr,length,0);
    }


    private static void buildHeap(int[] arr, int length) {
        int startIndex=length/2-1;
        for(int i=startIndex;i>=0;i--){
            heapify(arr,length,i);
        }
    }

    private static void heapify(int[] ar, int length, int i) {
        int largest=i;
        int l=2*i+1;
        int r=2*i+2;
        if(l<length && ar[l]>ar[largest]){
            largest=l;
        }
        if(r<length && ar[r]>ar[largest]){
            largest=r;
        }
        if(largest!=i){
            int temp=ar[i];
            ar[i]=ar[largest];
            ar[largest]=temp;
            heapify(ar,length,largest);
        }

    }
}
