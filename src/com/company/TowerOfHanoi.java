package com.company;

public class TowerOfHanoi {

    private static void moveDisk(int n, String rodFrom, String rodMid, String rodTo) {
        if (n == 1) {
            System.out.println("Moving Plate 1 from " + rodFrom + " to " + rodTo);
            return;
        }
        moveDisk(n - 1, rodFrom, rodTo, rodMid);
        System.out.println("Moving Plate " + n + " from " + rodFrom + " to " + rodTo);
        moveDisk(n - 1, rodMid, rodFrom, rodTo);
    }

    public static void main(String[] args) {
        moveDisk(3, "A", "B", "C");
    }
}

/* 3,A,B,C
 *  2,A,B,C
 * 1,A,B,C (BASE CASE SO WE PRINT AND POP => MOVING PLATE 1 FROM  A TO C)
 *
 * NOW STACK HAS
 * 3,A,B,C
 * 2,A,B,C  (PRINT MOVE PLATE 2 FROM A TO B)
 * 1,C,A,B (BASE CASE SO WE PRINT AND POP =>MOVING PLATE 1 FROM C TO B)
 *
 * NOW STACK HAS
 * 3,A,B,C (PRINT MOVE PLATE 3 FROM A TO C)
 * 2,B,A,C (NOW THIS WILL RUN RECURSIVELY)
 * 1,B,C,A (BASE CASE SO WE PRINT AND POP =>MOVING PLATE 1 FROM B TO A)
 * 2,B,A,C(PRINT MOVE PLATE 2 FROM B TO C)
 * NOW STACK HAS
 * 1,A,B,C(BASE CASE SO WE PRINT AND POP =>MOVING PLATE 1 FROM A TO C)
 *
 *
 * */
