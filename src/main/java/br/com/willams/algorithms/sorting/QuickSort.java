package br.com.willams.algorithms.sorting;

import java.util.Arrays;

public class QuickSort {
    public void sort(int[] a, int left, int right) {
        if(a.length > 1) {
            int index = partition(a, left, right);
            if(left < index - 1)
                sort(a, left, index - 1);
           if(index < right)
                sort(a, index, right);
        }
    }

    private int partition(int[] a, int left, int right) {
        int pivot = a[(right + left) / 2];
        int i = left;
        int j = right;

        while(i <= j) {
            while(a[i] < pivot) i++;
            while(a[j] > pivot) j--;
            
            if(i <= j) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
                j--;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();

        int[] array1 = new int[] { 5, 4, 3, 2, 1 }; // invertido
        int[] array2 = new int[] { 1, 2, 3, 4, 5 }; // ordenado
        int[] array3 = new int[] { 4, 1, 5, 2, 3 }; // aleatório
        int[] array4 = new int[] {}; // 0 elementos
        int[] array5 = new int[] { 27 }; // 1 elemento
        int[] array6 = new int[] { 4, 3 }; // 2 elementos

        quickSort.sort(array1, 0, array1.length - 1);
        quickSort.sort(array2, 0, array2.length - 1);
        quickSort.sort(array3, 0, array3.length - 1);
        quickSort.sort(array4, 0, array4.length - 1);
        quickSort.sort(array5, 0, array5.length - 1);
        quickSort.sort(array6, 0, array6.length - 1);

        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
        System.out.println(Arrays.toString(array3));
        System.out.println(Arrays.toString(array4));
        System.out.println(Arrays.toString(array5));
        System.out.println(Arrays.toString(array6));

    }
}
