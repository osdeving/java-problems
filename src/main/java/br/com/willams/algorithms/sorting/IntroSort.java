package br.com.willams.algorithms.sorting;

public class IntroSort {
    static public void swap(int[] v, int a, int b) {
        int temp = v[a];
        v[a] = v[b];
        v[b] = temp;
    }

    static public void insertionSort(int[] v, int begin, int end) {
        int left = begin;
        int right = end;

        for(int i = left + 1; i <= right; i++) {
            int key = v[i];
            int j = i - 1;

            while(j >= left && v[j] > key) {
                v[j + 1] = v[j];
                j--;
            }
            v[j + 1] = key;
        }
    }

    static public int partition(int v[], int low, int high) {
        int pivot = v[high];
        int i = (low - 1);

        for(int j = low; j <= high - 1; j++) {
            if(v[j] <= pivot)  {
                i++;

                swap(v, i, j);
            }
        }
        swap(v, i + 1, high);
        return v[i + 1];
    }

    static public int medianOf3(int a, int b, int c) {
        if(a < b && b < c) return b;
        if(a < c && c <= b) return c;
        if(b <= a && a < c) return a;
        if (b < c && c <= a) return c;
        if (c <= a && a < b) return a;
        if (c <= b && b <= a) return b;
        return a;
    }

    static public void introSort(int[] v, int begin, int end) {
        //int depthLimit = 2 * Math.log(end - begin);

       // introSortUtil(v, begin, end, depthLimit);
    }

    static public void introSortUtil(int[] v, int begin, int end, int depthLimit) {
        int size = end - begin;

        if(size < 16) {
            insertionSort(v, begin, end);
            return;
        }

        if (depthLimit == 0) {
        //    make_heap(begin, end + 1);
         //   sort_heap(begin, end + 1);
            return;
        }

        int pivot = medianOf3(begin, begin + size / 2, end);

        swap(v, pivot, end);

        int partitionPoint = partition(v, begin, end);
        introSortUtil(v, begin, partitionPoint - 1, depthLimit - 1);
        introSortUtil(v, partitionPoint + 1, end, depthLimit - 1);
    }
}
