package com.company;

public class SparseArray {
    static int[] matchingStrings(String[] strings, String[] queries) {
        //a loop of the size of string should be here and
        int queryIndex=0;
        int output[]=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            for(int j=0;j<strings.length;j++){
                if(queries[i].matches(strings[j])){
                    queryIndex++;
                    output[i]=queryIndex;

                }
            }
            queryIndex=0;

        }
        return output;
    }

    public static void main(String[] args) {
        String[] strings={"ab","na","de","ab","na"};
        String[] queries={"ab","abc","na","de"};
        int[] matchingStrings = matchingStrings(strings, queries);
        for(int i=0;i<matchingStrings.length;i++){
            System.out.println(matchingStrings[i]);
        }
    }
}
