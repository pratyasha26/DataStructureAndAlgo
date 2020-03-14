package com.company;

import java.util.Arrays;

public class ArrayQ1 {
    static void minimumBribes(int[] q) {
        int length = q.length;
        int index = 0;
        int count=0;
        while(index!=q.length) {
            int c=0;
            for (int resIndex = index; resIndex < length; resIndex++) {
                if (q[index] > q[resIndex]) {
                    c++;
                }
            }
            if(c>=3){
                System.out.println("Too chaotic");
                return;
            }
            else{
                count+=c;
            }
            index++;
        }
        System.out.println(count);
    }

    public static void main(String args[])
        {
            int q[]={1 ,2 ,5 ,3, 7, 8, 6 ,4};
           minimumBribes(q);

        }
}
