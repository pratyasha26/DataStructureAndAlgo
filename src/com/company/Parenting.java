package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Parenting {

    public static void main(String args[]) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            StringBuilder response = new StringBuilder();
            int n = in.nextInt();
            int ar[][] = new int[2][n];
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < 2; col++) {
                    ar[col][row] = in.nextInt();
                }
            }
            TreeMap<Integer, Integer> startEndMap = new TreeMap<>();
            for (int row = 0; row < n; row++) {
                startEndMap.put(ar[0][row], ar[1][row]);
            }

            boolean isPossible = false;
            HashMap<Integer,String> res=new HashMap<>();
            HashMap<String, Integer> currentJob = new HashMap<>();
            currentJob.put("J", 0);
            currentJob.put("C", 0);

            for (Map.Entry<Integer, Integer> entries1 : startEndMap.entrySet()) {
                isPossible = false;
                int startTask = entries1.getKey();
                int endTask = entries1.getValue();
                for (Map.Entry<String, Integer> entries : currentJob.entrySet()) {

                    int free = startTask - entries.getValue();
                    if (free >= 0) {
                        currentJob.put(entries.getKey(), endTask);
                        res.put(startTask,entries.getKey());
                        isPossible = true;
                        break;
                    }
                }
                if (!isPossible) {
                    break;
                }
            }
            if (!isPossible) {
                System.out.println("Case #" + i + ": " +"IMPOSSIBLE") ;

            } else {
                for(int row=0;row<n;row++){
                    String s = res.get(ar[0][row]);
                    response.append(s);
                }
                System.out.println("Case #" + i + ": " + response.toString());


            }
        }


    }
}
