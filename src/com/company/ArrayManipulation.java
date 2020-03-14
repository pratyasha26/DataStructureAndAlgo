package com.company;

import static com.company.Nqueen.ar;
import static sun.swing.MenuItemLayoutHelper.max;

public class ArrayManipulation {
    private static long largestNo;
    static long arrayManipulation(int n, int[][] queries) {
        int dynamicArray[]=new int[n];

        for(int index=0;index<queries.length;index++){
            long i=queries[index][0]-1;
            long j=queries[index][1];
            long no=queries[index][2];
            for(int count = Math.toIntExact(i); count<j; count++){
                dynamicArray[count]+=no;
                largestNo = Math.max(largestNo, dynamicArray[count]);
            }
        }
        return largestNo;
    }

    public static void main (String args[]){
        int n=10;
        int queries[][]={{1,5,3},{4,8,7},{6,9,1}};
        long result = arrayManipulation(n, queries);
        System.out.println(result);
    }
}
