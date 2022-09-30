package br.com.willams.algorithms.sorting;

/*
 
A principal aplicação de um Heap é ordenação (heap sort). O heap sort insere todos elementos (de um array não ordenado)
em um heap, então remove eles da raiz do heap até o heap ficar vazio.

Note que heap sort pode ser feito in-place. Em vez de deletar um elemento, troca o primeiro elemento (máximo) com o último elemento
e reduz o tamanho do heap (tamanho do array). Então nós aplicamos heap no primeiro elemento. Continua este processo até o
número de elmentos ser um.

 */
public class HeapSort {
    public static void main(String[] args) {
        int[] v = new int[] {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};

        int n = v.length;

        for(int i = n / 2 - 1; i >= 0; i--) 
            heapify(v, n, i);  
        
        for(int j = n - 1; j > 0; j--) {
            swap(v, 0, j); // troca o primeiro com o último
            heapify(v, j, 0); // aplica heap no primeiro elemento
        }

        for (int i = 0; i < v.length; i++) 
            System.out.print(v[i] + " ");
        

        System.out.println();
    } 
    
    static void heapify(int v[], int n, int i) {
        int root = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if(left < n && v[left] > v[root]) {
            root = left;
        }
        
        if (right < n && v[right] > v[root]) {
            root = right;
        }

        if(root != i) {
            swap(v, i, root);

            heapify(v, n, root);
        }
    }

    static void swap(int v[], int a, int b) {
        int aux = v[a];
        v[a] = v[b];
        v[b] = aux;
    }
}
