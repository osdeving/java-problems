package br.com.willams.algorithms.sorting;

import java.util.Arrays;

public class BubbleSort {
    
    public void sort1(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for(int j = 0; j < array.length - 1; j++) {
                if(array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public void sort2(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for(int j = 0; j < array.length - i - 1; j++) {
                if(array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
    
    public void sort3(int[] array) {
        for (int i = 0; i < array.length; i++) {
            boolean swapped = false;
            for(int j = 0; j < array.length - i - 1; j++) {
                if(array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            if(!swapped) break;
        }
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        
        int[] array1 = new int[]{5,4,3,2,1}; // invertido
        int[] array2 = new int[]{1,2,3,4,5}; // ordenado
        int[] array3 = new int[]{4,1,5,2,3}; // aleatório
        int[] array4 = new int[]{}; // 0 elementos
        int[] array5 = new int[]{27}; // 1 elemento
        int[] array6 = new int[]{4,3};  // 2 elementos
        
        bubbleSort.sort1(array1);
        bubbleSort.sort1(array2);
        bubbleSort.sort1(array3);
        bubbleSort.sort1(array4);
        bubbleSort.sort1(array5);
        bubbleSort.sort1(array6);

        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
        System.out.println(Arrays.toString(array3));
        System.out.println(Arrays.toString(array4));
        System.out.println(Arrays.toString(array5));
        System.out.println(Arrays.toString(array6));
    }
}
