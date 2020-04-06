package com.company.ArrayRelated;

import com.sun.deploy.util.StringUtils;

import java.util.*;
import java.io.*;

class Intersection {

    public static String FindIntersection(String[] strArr) {
        // code goes here
        String firstArray[]= StringUtils.splitString(strArr[0].trim(),",");
        String secondArray[]=StringUtils.splitString(strArr[1].trim(),",");
        Vector<String> vector=new Vector<>();
        StringBuilder res=new StringBuilder();
        int k=0;
        for(int i=0;i<firstArray.length;i++){
            firstArray[i]=firstArray[i].trim() ;
        }
        for(int i=0;i<secondArray.length;i++){
            secondArray[i]=secondArray[i].trim();
        }
        for(int i=0;i<firstArray.length;i++){
            for(int j=0;j<secondArray.length;j++){
                if(secondArray[j].trim().equals(firstArray[i].trim())){
                    res.append(firstArray[i]).append(",");
                    break;

                }
            }
        }
      //  strArr[0]=Arrays.toString(res);
        String s = res.toString();
        if(s.isEmpty()){
            strArr[0]= String.valueOf(false);
        }
        else {
            strArr[0] = s.substring(0, s.length() - 1);
        }

        //take first element
        //split each element into character using comma
        //do same for second element
        //run loop where chekc first element is there in second loop
        return strArr[0];
    }

    public static void main (String[] args) {
        // keep this function call here
        String[] strings = {"1, 5, 6, 7, 10, 11, 12", "8, 17"};
        String s = FindIntersection(strings);
        System.out.println(s);
    }

}