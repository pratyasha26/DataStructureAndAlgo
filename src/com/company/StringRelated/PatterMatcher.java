package com.company.StringRelated;

import com.sun.deploy.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatterMatcher {
    public static void main(String args[]){
        String str="121";
//        String numMarks=str.replaceAll("[^0-9]","");
//        Pattern p=Pattern.compile("//d//?+//d");
//        Matcher matcher = p.matcher(numMarks);
//        boolean matched=false;
//        while ((matcher.find())){
//            String group = matcher.group();
//            int a=Integer.parseInt(group.substring(0,1));
//            int b=Integer.parseInt(group.substring(group.length()-1));
//            if(a+b==10){
//                if (group.length() != 5) {
//                  matched=false;
//                } else {
//                    matched = true;
//                }
//            }
//        }
//        System.out.println(matched);
        String reversedBinaryNum = new StringBuilder(Integer.toBinaryString(Integer.parseInt(str))).reverse().toString();
        reversedBinaryNum += (reversedBinaryNum.length() % 8 > 0 ? "0000000".substring(0, 8 - reversedBinaryNum.length() % 8) : "");
        int i = Integer.parseInt(reversedBinaryNum, 2);

    }

}
