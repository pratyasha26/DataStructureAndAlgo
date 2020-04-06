package com.company.programmingBook;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class NonRepeatedCharInString {
    public  static  void main(String args[]){
        String str="total";
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(map.containsKey(c)) {
                Integer count = map.get(c);
                count++;
                map.put(c, count);
            }
            else {
                map.put(c,1);
            }
        }

        for(Map.Entry<Character, Integer> entries:map.entrySet()){
            if(entries.getValue()==1){
                System.out.println("non repeated element : " +entries.getKey());
            }
        }
    }
}
