package br.com.willams.algorithms.sorting;

import java.util.Arrays;

public class InsertionSort {
    public void sort(int[] a, int n) {

        for (int i = 1; i < n; i++) {
            int neo = a[i]; // o escolhido! kkk
            int j = i - 1;

            while (j >= 0 && a[j] > neo) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = neo;
        }
    }


    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        
        int[] array1 = new int[]{5,4,3,2,1}; // invertido
        int[] array2 = new int[]{1,2,3,4,5}; // ordenado
        int[] array3 = new int[]{4,1,5,2,3}; // aleatório
        int[] array4 = new int[]{}; // 0 elementos
        int[] array5 = new int[]{27}; // 1 elemento
        int[] array6 = new int[]{4,3};  // 2 elementos
        
        insertionSort.sort(array1, array1.length);
        insertionSort.sort(array2, array2.length);
        insertionSort.sort(array3, array3.length);
        insertionSort.sort(array4, array4.length);
        insertionSort.sort(array5, array5.length);
        insertionSort.sort(array6, array6.length);

        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
        System.out.println(Arrays.toString(array3));
        System.out.println(Arrays.toString(array4));
        System.out.println(Arrays.toString(array5));
        System.out.println(Arrays.toString(array6));

    }
}
