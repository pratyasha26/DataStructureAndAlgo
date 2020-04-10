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
            HashMap<Integer, Integer> map = new HashMap<>();
            int N = in.nextInt();
            int K = in.nextInt();
            int ar[][] = new int[N][N];
            for (int index = 1; index <= N; index++) {
                if(index == N){
                    map.put(index,1);
                }
                else {
                    map.put(index, index + 1);
                }
            }
            int initialCellValue = 1;
            while (initialCellValue != N) {
                int localTracker = initialCellValue;
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

    private static boolean isTraceValueSame(int k, int[][] ar) {
        int trace=0;
        for (int col = 0; col < ar.length; col++) {

                    trace+=ar[col][col];

        }
          return  trace==k;
    }

    private static void setValueOfTheRow(int[][] ar, int col, HashMap<Integer, Integer> map) {
        int cellvalue=ar[col][0];
        for(int index=0;index<ar.length;index++){
            ar[col][index]=map.get(cellvalue);
            cellvalue=ar[col][index];
        }
    }

}
