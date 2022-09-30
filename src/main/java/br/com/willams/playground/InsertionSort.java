package br.com.willams.playground;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        // vetor com 5 elementos
        var v = new int[]{4, 2, 7, 1, 3};

        InsertionSort insertionSort = new InsertionSort();

        insertionSort.sort(v, v.length);
        

        // imprime um vetor com 5 elementos
        System.out.println(Arrays.toString(v));

    }

    // Usando o algorítmo de ordenação Insetion Sort,
    // ordena o vetor 'v' de tamanho 'n'
    // Time: Pior caso O(N²), Caso médio O(N² / 2) e melhor caso O(N)
    // Selection Sort é O(N²) em todos os cenários.
    // Insertion é melhor para inputs quase odernados (O(N) para o melhor caso)
    // Selection é melhor para inputs mais desordenados (O(N² / 2) para o pior caso)
    // Para inputs randômicos ambos são equivalentes (são iguais: O(N²/2))
    void sort(int v[], int n) {

        for (int i = 1; i < n; i++) {
            int tempValue = v[i];    
            int position =  i - 1;

            while(position >= 0 && v[position] > tempValue) {
                v[position + 1] = v[position];
                position--;
            }

            v[position + 1] = tempValue;
        }
    }
}
