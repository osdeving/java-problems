package br.com.willams.datastructures.heap;

public class Heap {
    public int[] v;
    public int count;
    public int capacity;
    public int type;

    // Time O(1)
    public Heap(int capacity, int type) {
        this.type = type;
        this.count = 0;
        this.capacity = capacity;
        v = new int[capacity];
    }

    // Time O(1)
    public int parent(int i) {
        if(i <= 0 || i >= count) return -1;
        return (i - 1) / 2;
    }

    // Time O(1)
    public int leftChild(int i) {
        int left = 2 * i + 1;
        if(left >= count) return -1;
        return left;
    }

    // Time O(1)
    public int rightChild(int i) {
        int right = 2 * i + 2;
        if (right >= count)
            return -1;
        return right;
    }

    // Time O(1)
    int max() {
        if(count == 0) return -1;
        return v[0];
    }

    // Time O(logn)
    // Space O(1)
    void percolateDown(int i) {
        int left = leftChild(i);
        int right = rightChild(i);

        int max = 0;

        if(left != -1 && v[left] > v[i])
            max = left;
        else
            max = i;

        if(right != -1 && v[right] > v[max])
            max = right;

        if(max != i) {
            int temp = v[i];
            v[i] = v[max];
            v[max] = temp;
        }
        percolateDown(max);
    }

    // Time O(logn)
    // Space O()
    public int deleteMax() {
        if(count == 0) return -1;

        int data = v[0];

        v[0] = v[--count];

        percolateDown(0);

        return data;
    }

    // Time O(logn)
    // Space O()
    public void insert(int data) {
        if(count == capacity) resizeHeap();

        count++;

        int i = count - 1;

        while(i >= 0 && data > v[(i - 1) / 2]) {
            v[i] = v[(i - 1) / 2];
            i = (i - 1) / 2;
        }

        v[i] = data;
    }

    public void resizeHeap() {
        int[] newVector = new int[capacity * 2];

        for (int i = 0; i < capacity; i++) newVector[i] = v[i];
        
        v = newVector;
        capacity *= 2;
    }

    public void build(int a[], int n) {
        while(n > capacity) resizeHeap();

        for (int i = 0; i < n; i++) {
            v[i] = a[i];
        }

        count = n;

        for (int i = (n - 1) / 2; i  >= 0; i--) {
            percolateDown(i);
        }
    }

    void heapsort(int a[], int n) {
        build(a, n);
        
        int oldCount = count;

        for (int i = n - 1 ; i > 0; i--) {
            int temp = v[0];
            v[0] = v[count  - 1];
            v[count - 1] = temp;
            count--;
            percolateDown(0);
        }
        count = oldCount;
    }
}
