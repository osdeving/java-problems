package br.com.willams.algorithms.sorting;

import java.util.Arrays;
import java.util.Random;

public class Sort {

    static public void bublesort(int[] v) {
        int n = v.length;
        boolean swapped = false;

        // itera até n-1 porque o laço interior vai de 0 até 'i' e compara 'j' com 'j' +
        // 1
        for (int i = 0; i < n - 1; i++) {

            // os últimos 'i' elementos já estão ordenados E no local correto
            for (int j = 0; j < n - i - 1; j++) {
                // se a posição atual é maior que a próximo, troca de lugar
                if (v[j] > v[j + 1]) {
                    swap(v, j, j + 1); // troca
                    swapped = true; // indica que houve uma troca
                }
            }

            // se não trocou nenhuma vez no laço interno é porque já tá tudo ordenado
            // p.ex.: [1,2,3,4]
            // 1 não é menor que 2 que por sua vez não é menor que 3 e tampouco este é menor
            // que 4
            // então não haverá nenhuma troca e, portanto, estará ordenado.
            if (!swapped)
                break;
        }
    }

    static public void recursiveBubblesort(int[] v, int n) {
        if (n <= 1)
            return;

        boolean swapped = false;

        for (int j = 0; j < n - 1; j++) {
            if (v[j] > v[j + 1]) {
                swap(v, j, j + 1);
                swapped = true;
            }
        }

        if (!swapped)
            return;

        recursiveBubblesort(v, n - 1);
    }

    static public void selectionsort(int[] v) {
        for (int i = 0; i < v.length; i++) {
            int minIndex = i;

            for (int j = i; j < v.length; j++) {
                if (v[j] > v[minIndex])
                    minIndex = j;
            }

            swap(v, i, minIndex);
        }
    }

    static public void mergeSort(int[] v, int start, int end) {
        int len = end - start;
        if (len > 1) {
            int mid = (end + start) / 2;

            mergeSort(v, start, mid);
            mergeSort(v, mid, end);

            merge(v, start, mid, end);
        }
    }

    static public void merge(int[] v, int start, int mid, int end) {
        int[] result = new int[end-start];

        int i = start;
        int j = mid;
        int k = 0;

        while (i < mid && j < end) {
            if (v[i] < v[j]) {
                result[k++] = v[i++];
            } else {
                result[k++] = v[j++];
            }
        }

        while (i < mid) result[k++] = v[i++];
        while (j < end) result[k++] = v[j++];
        
        for (int pos = 0; pos < k; pos++) {
            v[start + pos] = result[pos];
        }
    }

    static public void swap(int[] v, int a, int b) {
        int temp = v[a];
        v[a] = v[b];
        v[b] = temp;
    }

    public static void main(String[] args) {
        var random = new Random();
        int[] v = random.ints(10, 100).limit(10).toArray();

        System.out.println(Arrays.toString(v));

        Sort.mergeSort(v, 0, v.length);

        System.out.println(Arrays.toString(v));
    }
}
