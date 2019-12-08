package com.company;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static java.util.Collections.swap;

public class QuickSelect {

    //two steps : Partition then selection
    /*
    input: list of numbers,kth largest no.
     */
    private static int selection(List<Integer> listToBeSort,int indexFirst,int indexLast,int k){
        int pivot= partiton(listToBeSort,indexFirst,indexLast);
        if(pivot>k-1){
            selection(listToBeSort,indexFirst,pivot-1,k);
        }
        else if(pivot<k-1){
            selection(listToBeSort,pivot+1,indexLast,k);
        }
        return listToBeSort.get(k-1);
    }

    private static int partiton(List<Integer> listToBeSort, int indexFirst, int indexLast) {
        Random random=new Random();
        int pivot=random.nextInt(indexLast);
        swap(listToBeSort,indexLast,pivot);
        for(int i=indexFirst;i<indexLast;i++){
            Integer first = listToBeSort.get(i);
            Integer last = listToBeSort.get(indexLast);
            if(first>last){
                swap(listToBeSort,i,indexFirst);
                indexFirst++;
            }
        }
        swap(listToBeSort,indexFirst,indexLast);
        return indexFirst;
    }
    public static void main(String args[]){
        List<Integer> listToBeSorted= Arrays.asList(1,-2,5,8,7,6,9,10);
        int selection = selection(listToBeSorted, 0, listToBeSorted.size() - 1, 2);
        System.out.println(selection);
    }
}
