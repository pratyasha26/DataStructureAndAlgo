package com.company.programmingBook;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AlienLUsingPatternMatching {


    public static void  main(String args[]) {

        String pattern[] = {"(ab)(bc)(ca)","abc",
                "(abc)(abc)(abc)",
                "(zyx)bc"};
        for(int p=0;p<pattern.length;p++) {

            System.out.println("pattern : "+pattern[p] +" :" +getAlienCount(pattern[p]));
        }
    }

    private static int getAlienCount(String pattern) {
        int count = 0;
        int globalMatchCount=0;
        String words[] = {"abc",
                "bca",
                "dac",
                "dbc",
                "cba"};

        Pattern p = Pattern.compile(pattern);
        for (int i = 0; i < words.length; i++) {
            boolean matcher = p.matcher(words[i]).matches();
            if (matcher) {
                count++;
            }
        }
        return count;
    }
}
