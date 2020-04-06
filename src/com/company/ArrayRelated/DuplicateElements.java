package com.company.ArrayRelated;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DuplicateElements {


    public static void main(String args[]){
        int ar[]={12,19,12,1,1,1,13,1};

        HashMap<Integer,Integer> map=new HashMap<>();
        int count=0;
        for(int i=0;i<ar.length;i++){
            count=0;
            if(map.containsKey(ar[i])){
                System.out.println("Duplicate value : "+ar[i]);
                Integer existingCount = map.get(ar[i]);
                existingCount++;
                map.put(ar[i],existingCount);
            }
            else{
                count++;
                map.put(ar[i],count);
            }
        }
    }
}
