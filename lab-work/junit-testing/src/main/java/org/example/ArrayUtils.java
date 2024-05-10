package org.example;

public class ArrayUtils {
    public static int find(int[] a){
        int sumEven = 0;
        int sumOdd = 0;

        for (int i=0; i<a.length; i++)
        {
            if (a[i]%2 == 0)
                sumEven += a[i];
            else
                sumOdd += a[i];
        }

        return sumOdd - sumEven;
    }
}

