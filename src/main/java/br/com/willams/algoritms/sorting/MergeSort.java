package br.com.willams.algoritms.sorting;

import java.util.Arrays;

public class MergeSort {
    public void sort(int[] v, int start, int end) {
        int len = end - start;
        if(len > 1) {
            int mid = (start + end) / 2;
            sort(v, start, mid);
            sort(v, mid, end);
            merge(v, start, mid, end);
        }
    }

    private void merge(int[] v, int start, int mid, int end) {
        int[] result = new int[end - start];

        int k = 0;
        int i = start;
        int j = mid;

        while(i < mid && j < end) {
            if(v[i] < v[j]) {
                result[k++] = v[i++];
            } else {
                result[k++] = v[j++];
            }
        }

        while(i < mid) result[k++] = v[i++];
        while(j < end) result[k++] = v[j++];

        for(int pass = 0; pass < k; pass++) {
            v[start + pass] = result[pass];
        }
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();

        int[] array1 = new int[] { 5, 4, 3, 2, 1 }; // invertido
        int[] array2 = new int[] { 1, 2, 3, 4, 5 }; // ordenado
        int[] array3 = new int[] { 4, 1, 5, 2, 3 }; // aleatório
        int[] array4 = new int[] {}; // 0 elementos
        int[] array5 = new int[] { 27 }; // 1 elemento
        int[] array6 = new int[] { 4, 3 }; // 2 elementos

        mergeSort.sort(array1, 0, array1.length);
        mergeSort.sort(array2, 0, array2.length);
        mergeSort.sort(array3, 0, array3.length);
        mergeSort.sort(array4, 0, array4.length);
        mergeSort.sort(array5, 0, array5.length);
        mergeSort.sort(array6, 0, array6.length);

        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
        System.out.println(Arrays.toString(array3));
        System.out.println(Arrays.toString(array4));
        System.out.println(Arrays.toString(array5));
        System.out.println(Arrays.toString(array6));

    }
}
