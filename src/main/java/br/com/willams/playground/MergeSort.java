package br.com.willams.playground;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        var v = new int[]{2, 9, 1, 3, 23, 23, 0, 23};

        mergeSort(v, 0, v.length);

        System.out.println(Arrays.toString(v));

    }

    private static void mergeSort(int[] v, int start, int end) {
        if( (end-start) > 1) {
            int mid = (start+end) / 2;

            mergeSort(v, start, mid);
            mergeSort(v, mid, end);

            var a = new int[end-start];
            int i = start;
            int j = mid;
            int k = 0;

            while(i < mid && j < end) {
                if(v[i] < v[j]) a[k++] = v[i++];
                else a[k++] = v[j++];
            }

            while(i < mid) a[k++] = v[i++];
            while(j < end) a[k++] = v[j++];

            while(k > 0) v[--end] = a[--k];

        }
    }
    
}