package br.com.willams.algorithms.sorting;

import java.util.Arrays;

public class ShellSort {
    public void sort(int[] a, int n) {
        // insertion sort
        // for(int i = 0; i < n; i++) {
        //      int elemento = a[i];
        //      for(int j = i; j > 0; j--) {
        //          if(a[j-1] > elemento) {
        //              int temp = a[j-1];
        //              a[j-1] = a[j];
        //              a[j] = temp;
        //          }
        //      }
        // }

       
        // shell sort
        for(int interval = n / 2; interval > 0; interval--) {
            for(int i = interval; i < n; i++) {
                int element = a[i];
                for(int j = i; j >= interval && a[j - interval] > element; j -= interval) {
                    if(a[j - interval] > element) {
                        int temp = a[j];
                        a[j] = a[j - interval];
                        a[j - interval] = temp;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        ShellSort shellSort = new ShellSort();

        int[] array1 = new int[] { 5, 4, 3, 2, 1 }; // invertido
        int[] array2 = new int[] { 1, 2, 3, 4, 5 }; // ordenado
        int[] array3 = new int[] { 4, 1, 5, 2, 3 }; // aleatório
        int[] array4 = new int[] {}; // 0 elementos
        int[] array5 = new int[] { 27 }; // 1 elemento
        int[] array6 = new int[] { 4, 3 }; // 2 elementos

        shellSort.sort(array1, array1.length);
        shellSort.sort(array2, array2.length);
        shellSort.sort(array3, array3.length);
        shellSort.sort(array4, array4.length);
        shellSort.sort(array5, array5.length);
        shellSort.sort(array6, array6.length);

        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
        System.out.println(Arrays.toString(array3));
        System.out.println(Arrays.toString(array4));
        System.out.println(Arrays.toString(array5));
        System.out.println(Arrays.toString(array6));

    }
}
