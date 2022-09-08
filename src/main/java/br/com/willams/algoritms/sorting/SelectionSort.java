package br.com.willams.algoritms.sorting;

import java.util.Arrays;

public class SelectionSort {
    public void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }
    }

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        
        int[] array1 = new int[]{5,4,3,2,1}; // invertido
        int[] array2 = new int[]{1,2,3,4,5}; // ordenado
        int[] array3 = new int[]{4,1,5,2,3}; // aleatório
        int[] array4 = new int[]{}; // 0 elementos
        int[] array5 = new int[]{27}; // 1 elemento
        int[] array6 = new int[]{4,3};  // 2 elementos
        
        selectionSort.sort(array1);
        selectionSort.sort(array2);
        selectionSort.sort(array3);
        selectionSort.sort(array4);
        selectionSort.sort(array5);
        selectionSort.sort(array6);

        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
        System.out.println(Arrays.toString(array3));
        System.out.println(Arrays.toString(array4));
        System.out.println(Arrays.toString(array5));
        System.out.println(Arrays.toString(array6));
    }
}
