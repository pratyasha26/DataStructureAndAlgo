package com.company.programmingBook;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {

    public static void main(String args[]){

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            boolean possibleFlag=false;
            HashMap<Long, Long> map = new HashMap<>();
            int N = in.nextInt();
            int K = in.nextInt();
            long ar[][] = new long[N][N];
            for (long index = 1; index <= N; index++) {
                if(index == N){
                    map.put(index,1L);
                }
                else {
                    map.put(index, index + 1);
                }
            }
            Long initialCellValue = 1L;
            while (initialCellValue != N) {
                Long localTracker = initialCellValue;
                for (int col = 0; col < N; col++) {
                    for (int row = 0; row < N; row++) {

                        ar[col][row] = localTracker;
                        setValueOfTheRow(ar,col,map);
                    }
                    localTracker=map.get(ar[col][0]);
                }
                if(isTraceValueSame(K,ar)){
                    System.out.println("Case #" + i + ": " + "POSSIBLE");
                    for (int col = 0; col < N; col++) {
                        for (int row = 0; row < N; row++) {
                            System.out.print(ar[col][row] + " ");
                        }
                        System.out.println();
                    }
                    possibleFlag=true;
                    break;
                }
                else {
                    initialCellValue++;
                }
            }
            if(!possibleFlag){
                System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
            }
        }
        }

    private static boolean isTraceValueSame(long k, long[][] ar) {
        int trace=0;
        for (int col = 0; col < ar.length; col++) {

                    trace+=ar[col][col];

        }
          return  trace==k;
    }

    private static void setValueOfTheRow(long[][] ar, int col, HashMap<Long, Long> map) {
        long cellvalue=ar[col][0];
        for(int index=0;index<ar.length;index++){
            ar[col][index]=map.get(cellvalue);
            cellvalue=ar[col][index];
        }
    }

}
