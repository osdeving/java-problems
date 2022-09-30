package br.com.willams.playground;

import java.util.Arrays;

public class QuickSort {
    public static void quicksort(int[] v, int left, int right) {
        if(left >= right) return;

        int p = partition(v, left, right);
        quicksort(v, left, p);
        quicksort(v, p + 1, right);
        
    }

    private static int partition(int[] v, int left, int right) {
        int mid = (left + right) / 2;
        int pivot = v[mid];
        int i = left - 1;
        int j = right + 1;

        while(true) {
            
            do i++; while(v[i] < pivot);
            do j--; while(v[j] > pivot);

            if(i >= j) return j;

            // swap
            int aux = v[i];
            v[i] = v[j];
            v[j] = aux;
        }
    }

    public static void main(String[] args) {
        int[] v = new int[] { 4, 6, 9, 2, 1, 8, 3, 5, 7 };
        
        quicksort(v, 0, v.length - 1);
        
        System.out.println(Arrays.toString(v));
    }
}
