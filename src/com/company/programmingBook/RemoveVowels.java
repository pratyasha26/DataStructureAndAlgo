package com.company.programmingBook;

import java.util.HashMap;
import java.util.HashSet;

public class RemoveVowels {
    public static void main(String args[]){
        String str="Battle of the vowels";
        HashSet<Character> set=new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        StringBuilder result=new StringBuilder();
        char[] strChar = str.toCharArray();
        for(int i=0;i<str.length();i++){
            if(!set.contains(strChar[i])){
                result.append(strChar[i]);
            }
        }
        System.out.println(result.toString());
    }
}
