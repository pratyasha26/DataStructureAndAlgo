package com.company.programmingBook;

import java.util.HashSet;

public class Vestiguim {

    public static void main(String args[]){
        int ar[][]={
                {1,2,3,4},
                {2,1,2,4},
                {1,1,2,3},
                {1,2,3,4}
        };
        int trace=getTraceOfMatrix(ar);
        int rowCount=getNoOfRepeatedRows(ar);
        int colCount=getNoOfRepeatedCols(ar);
        System.out.println("trace :" +trace+ " repeated rows : "+rowCount+" : repeated cols : "+colCount);
    }

    private static int getNoOfRepeatedRows(int[][] ar) {
        HashSet<Integer> set=new HashSet<>();
      int globalRowCount=0;
        for(int row=0;row<ar.length;row++){
            for(int col =0;col<ar.length;col++){
                if(set.contains(ar[row][col])){
                    globalRowCount++;
                    break;
                }
                else{
                    set.add(ar[row][col]);
                }
            }
            set.clear();
        }
        return globalRowCount;
    }

    private static int getNoOfRepeatedCols(int[][] ar) {
        HashSet<Integer> set=new HashSet<>();
        int globalRowCount=0;
        for(int row=0;row<ar.length;row++){
            for(int col =0;col<ar.length;col++){
                if(set.contains(ar[col][row])){
                    globalRowCount++;
                    break;
                }
                else{
                    set.add(ar[col][row]);
                }
            }
            set.clear();
        }
        return globalRowCount;

    }

    private static int getTraceOfMatrix(int[][] ar) {
        int sum=0;
        for(int i=0;i<ar.length;i++){
            sum+=ar[i][i];
        }
        return sum;
    }
}
