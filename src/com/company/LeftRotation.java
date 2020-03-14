package com.company;

public class LeftRotation {

    public static int[] rotateArrayLeft(int[] ar, int d) {
        int[] temp = new int[ar.length];
        for (int i = 0; i < d; i++) {
            temp[i] = ar[i];
        }
        int count = d;
        int k=0;
        while (count<ar.length) {
            ar[k++] = ar[count];
            count++;
        }
        int i=0;
        for (int index = ar.length - d; index < ar.length; index++) {
            ar[index] = temp[i];
            i++;

        }
        return ar;
    }

    public static void main(String[] arg) {
        int[] ar = {1, 2, 3, 4, 5, 6};
        int d = 3;
        int index = 0;
        int[] rotateArrayLeft = rotateArrayLeft(ar, d);
        while (index != rotateArrayLeft.length) {
            System.out.print(rotateArrayLeft[index]+ " ");
            index++;
        }
    }
}
