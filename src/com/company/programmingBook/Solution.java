import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String args[]) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int ar[][] = new int[n][n];
            for(int row=0;row<n;row++){
                for(int col=0;col<n;col++){
                    ar[col][row]=in.nextInt();
                }
            }

            int trace = getTraceOfMatrix(ar);
            int rowCount = getNoOfRepeatedRows(ar);
            int colCount = getNoOfRepeatedCols(ar);
            System.out.println("Case #" + i + ": " + (trace) + " " + (rowCount) + " " + (colCount));

        }
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
