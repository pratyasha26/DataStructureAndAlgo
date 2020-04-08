package com.company.programmingBook;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class NestedDepth {

    public static void main(String args[]) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int noOfParanthesisOpen = 0;
            StringBuilder stringWithParenthesis = new StringBuilder();
            String sample = in.next();
            for (int index = 0; index < sample.length(); index++) {


                int digit = Character.getNumericValue(sample.charAt(index));
                addParanthesis(digit, noOfParanthesisOpen, stringWithParenthesis);
                noOfParanthesisOpen = digit;
            }
            while(noOfParanthesisOpen!=0){
                stringWithParenthesis.append(")");
                noOfParanthesisOpen--;
            }
            System.out.println("Case #" + i + ": " + stringWithParenthesis.toString());
        }
    }

    private static StringBuilder addParanthesis(int digit, int noOfParanthesisOpen, StringBuilder stringWithParenthesis) {

        int reqNoOfParanthesis = digit - noOfParanthesisOpen;

        for (int index = 0; index < Math.abs(reqNoOfParanthesis); index++) {
            if (reqNoOfParanthesis > 0) {
                stringWithParenthesis.append("(");
            } else if (reqNoOfParanthesis < 0) {
                stringWithParenthesis.append(")");
            }
        }
        stringWithParenthesis.append(digit);
        return stringWithParenthesis;
    }
}
