package com.company;

import java.util.ArrayList;
import java.util.List;

public class DynamicArray {
    int N;
    int Q;
    int lastAnswer;
    List<List<Integer>> listofSequences;

    public DynamicArray(int N, int Q,int lastAnswer) {
        this.N = N;
        this.Q = Q;
        this.lastAnswer=lastAnswer ;
        this.listofSequences = initalizeNnOfSequnce(N);
    }

    public int performXorOperationBasedOnQuery(int queryNo, int x, int y, int lastAnswer) {
        if (queryNo == 1) {
            //perform Q1 query
            solveQueryOne(this.listofSequences, x, y, lastAnswer);
        } else {
            //perform Q2 query
            lastAnswer = solveQueryTwo(this.listofSequences, x, y, lastAnswer);
            System.out.println(lastAnswer);
        }
        return lastAnswer;
    }

    private void solveQueryOne(List<List<Integer>> listofSequences, int x, int y, int lastAnswer) {
        int seqNumber = (x ^ lastAnswer) % N;
        listofSequences.get(seqNumber).add(y);
    }

    private int solveQueryTwo(List<List<Integer>> listofSequences, int x, int y, int lastAnswer) {
        int seqNumber = (x ^ lastAnswer) % N;
        lastAnswer =listofSequences.get(seqNumber).get( y % (listofSequences.get(seqNumber).size()));
        return lastAnswer;
    }

    private void callOperation(int queryNO, int x, int y) {

         int updateLastAns= performXorOperationBasedOnQuery(queryNO, x, y, lastAnswer);
         lastAnswer=updateLastAns;

    }

    private List<List<Integer>> initalizeNnOfSequnce(int n) {
        List<List<Integer>> listofSequences = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            listofSequences.add(new ArrayList<Integer>());
        }
        return listofSequences;
    }

    public static void main(String[] args) {

        DynamicArray dynamicArray=new   DynamicArray(2,5,0);
        dynamicArray.callOperation(1,0,5);
        dynamicArray.callOperation(1,1,7);
        dynamicArray.callOperation(1,0,3);
        dynamicArray.callOperation(2,1,0);
        dynamicArray.callOperation(2,1,1);

    }
}
