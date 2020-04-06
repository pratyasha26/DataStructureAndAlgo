package com.company.programmingBook;

import java.util.HashSet;
import java.util.Set;

public class ChangeLetters {

    public static void main(String args[]){
        String str="this is a string";
        char[] charStr = str.toCharArray();
        StringBuilder res=new StringBuilder();
        Set<Character> vowels=new HashSet<Character>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        for(int i=0;i<str.length();i++){
            if(charStr[i]>=65 && charStr[i]<=90 || charStr[i]>=97 && charStr[i]<=122){
                charStr[i] = (char) (charStr[i] + 1);
                if (vowels.contains(charStr[i])) {
                    charStr[i] = (char) (charStr[i] - 32);
                }
            }
            res.append(charStr[i]);

        }
        System.out.println(res.toString());
    }
}
