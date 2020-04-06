package com.company.programmingBook;

import com.sun.deploy.util.StringUtils;

import java.util.HashMap;

public class LongestSentence {


    public static String LongestWord(String sen) {
        /*
        * i
        * love
        * dogs
        *
        *
        *
        *
        *
        * */
        String[] s = sen.split(" ");
        int start=0;
        int curr=0;
        for(int i=0;i<s.length;i++){
            if(s[i].length()>curr && !s[i].contains("!")) {
                curr=s[i].length();
                start=i;
            }
        }
        return s[start];
    }

    public static void main(String[] args) {
        // keep this function call here
        String str = "Argument goes here";
        String s = LongestWord(str);
       System.out.println(s);
    }


}
