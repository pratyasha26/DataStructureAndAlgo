package com.company.programmingBook;

import com.sun.deploy.util.StringUtils;

import java.util.Stack;

public class ReverseWords {
    public static void main(String args[]) {
        String str = "do try not to.";
        StringBuilder res = new StringBuilder();
        int count = 0;
        char[] strChar = str.toCharArray();
        for (int i = str.length() - 1; i >= 0; i--) {
            char c = strChar[i];
            if (c == ' ' ||  i == 0) {
                if(i!=0) {
                    res.append(str.substring(i + 1, count + 1));
                }
                if(i==0){
                    res.append(str.substring(i , count + 1));
                }
                res.append(' ');

            }
            if (c == '.' || c == ' ') {
                count = i;
            }
        }
        System.out.println("Reverse string: " + res.toString());

        //inplace solution
//        int j = 0;
//        StringBuilder stringBuilder=new StringBuilder(str);
//        for (int i = stringBuilder.length() - 1; i >= 0; i--) {
//            char c = strChar[i];
//            strChar[i] = strChar[j];
//            strChar[j] = c;
//       //     System.out.print(strChar[j]);
//
//            if (strChar[j] == ' ' ||  i == 0) {
//                if(i!=0) {
//                    stringBuilder.replace(i+1,count+1,str.substring(i + 1, count + 1));
//                }
//                if(i==0){
//                    stringBuilder.replace(i,count+1,str.substring(i , count + 1));
//                 //   stringBuilder.append(str.substring(i , count + 1));
//                }
//                stringBuilder.append(' ');
//
//            }
//            if (strChar[j] == '.' || strChar[j]== ' ') {
//                count = i;
//            }
//            j++;
//        }
//
//        System.out.println("Reverse string: " + stringBuilder.toString());
//
    }


}
