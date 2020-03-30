package com.company.ArrayRelated;

import com.sun.deploy.util.StringUtils;

import java.util.*;
import java.io.*;

class Intersection {

    public static String FindIntersection(String[] strArr) {
        // code goes here
        String firstArray[]= StringUtils.splitString(strArr[0],",");
        String secondArray[]=StringUtils.splitString(strArr[1],",");
        Vector<String> vector=new Vector<>();
        String res[]=new String[firstArray.length];
        int k=0;
        for(int i=0;i<firstArray.length;i++){
            for(int j=i;j<secondArray.length;j++){
                if(secondArray[j].trim().equals(firstArray[i].trim())){
                    vector.add(firstArray[i].trim());
                    break;

                }
            }
        }
      //  strArr[0]=Arrays.toString(res);
        strArr[0]=vector.toString();
        //take first element
        //split each element into character using comma
        //do same for second element
        //run loop where chekc first element is there in second loop
        return strArr[0];
    }

    public static void main (String[] args) {
        // keep this function call here
        String[] strings = {"1, 3, 9, 10, 17, 18", "1, 4, 9, 10"};
        String s = FindIntersection(strings);
        System.out.println(s);
    }

}