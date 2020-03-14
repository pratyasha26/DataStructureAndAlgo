package com.company.ArrayRelated;

import java.util.HashSet;
import java.util.Set;

public class SubarrayConsequtive {

    public static void main(String args[]){
        int ar[]={2,0,2,2};
        Set<Integer> res = getSubarray(ar);
        if(res.isEmpty()){
            System.out.println("There is no sub array with consequtive element");
        }
        else{
          System.out.println(res);
        }
    }

    private static Set<Integer> getSubarray(int[] ar) {
       Set<Integer> set= new HashSet();
       int i=0;
       int max=ar[0];
       int min=ar[0];
       while(i<ar.length){
           set.add(ar[i]);
           if(ar[i]>max){
               max=ar[i];
           }
           if(ar[i]<min){
               min=ar[i];
           }
           i++;
       }
       if(max-min == set.size()-1){
           return set;
       }
       set.clear();
        return set;
    }
}
