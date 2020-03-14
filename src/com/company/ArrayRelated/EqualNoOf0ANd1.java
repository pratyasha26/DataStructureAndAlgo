package com.company.ArrayRelated;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class EqualNoOf0ANd1 {

    public static void main(String arg[]){
        int ar[] ={0,0,1,0,1,0,0};
        int subArray = getSubArray(ar);
        System.out.println(subArray);
    }

    private static int getSubArray(int[] ar) {
        Map<Integer,Integer> map=new HashMap<>();
        Vector<Integer> vector=new Vector<>();
        int zero=0;
        int one=0;
        int maxLen=0;
        for(int i=0;i<ar.length;i++){
            if(ar[i]==0){
                zero++;
                map.put(0,zero);
            }
            if(ar[i]==1){
                one++;
                map.put(1,one);
            }
            if(map.get(0)==map.get(1)){
              maxLen=  Math.max(maxLen,map.get(0)+map.get(1));
            }

        }

        return maxLen;
    }

}
