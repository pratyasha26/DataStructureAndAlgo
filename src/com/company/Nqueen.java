package com.company;

public class Nqueen {
    static int[][] ar;
    int n;
    int flag;

    public Nqueen(int n) {
        this.n = n;
        ar = new int[n][n];
    }

    public  boolean checkEachColumnForQueen(int col, int n, int[][] ar) {
        for (int row = 0; row < n; row++) {
            if (checkForQueenHorizontally(col, row, n) && checkForQueenVertically(col, row, n) && checkForQueenDiagonally(col,row,n)) {
                ar[row][col] = 1;
                return true;
            }
        }
        return false;
    }

    private boolean checkForQueenDiagonally(int col, int row, int n) {
    if(checkForQueenInRightDiagonal(col,row,n) && checkForQueenInLeftDiagonal(col,row,n)){
        return true;
    }
    return false;
    }

    private static boolean checkForQueenInLeftDiagonal(int col, int row, int n) {
        int left=row-1;
        int up=col-1;
        int down=col+1;
        while(left>=0 && up>=0){
            if(ar[left][up]==1){
                return false;
            }
            left--;
            up--;
        }
        while(left>=0 && down<n){
            if(ar[left][down]==1){
                return false;
            }
            left--;
            down++;
        }
        return true;
    }

    private static boolean checkForQueenInRightDiagonal(int col, int row, int n) {
        int right=row+1;
        int up=col-1;
        int down=col+1;
        while(right<n && up>=0){
            if(ar[right][up]==1){
                return false;
            }
            right++;
            up--;
        }
        while(right<=n && down<n){
            if(ar[row][col]==1){
                return false;
            }
            right++;
            down++;
        }
        return true;
    }

    private static boolean checkForQueenVertically(int col, int row, int n) {

        return checkForQueenDown(col, row, n) && checkForQueenUp(col, row, n);
    }

    private static boolean checkForQueenUp(int col, int row, int n) {
        for (int up = col - 1; up >= 0; up--) {
            if (ar[row][up] == 1) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkForQueenDown(int col, int row, int n) {
        for (int down = col + 1; down < n; down++) {
            if (ar[row][down] == 1) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkForQueenHorizontally(int col, int row, int n) {
        return checkForQueenRight(row, col, n) && checkForQueenLeft(row, col, n);
    }

    private static boolean checkForQueenLeft(int row, int col, int n) {
        for (int left = row-1; left >=0; left--) {
            if (ar[left][col] == 1) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkForQueenRight(int row, int col, int n) {
        for (int right = row+1; right <n; right++) {
            if (ar[right][col] == 1) {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        int n = 4;
        Nqueen nqueen = new Nqueen(n);

        for (int col = 0; col < n; col++) {
            boolean isQueenPlaced = nqueen.checkEachColumnForQueen(col, n, ar);
            if(isQueenPlaced){

            }
        }
        printTheChessBoard(ar,n);

    }

    private static void printTheChessBoard(int[][] ar, int n) {
        for(int row=0;row<n;row++){
            for(int col=0;col<n;col++){
                System.out.print(ar[row][col]);
            }
            System.out.println();
        }
    }

}
