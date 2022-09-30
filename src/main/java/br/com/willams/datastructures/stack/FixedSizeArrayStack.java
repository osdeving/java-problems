package br.com.willams.datastructures.stack;

public class FixedSizeArrayStack {
    protected int capacity;
    public static final int CAPACITY = 10;
    
    protected int stack[];

    protected int top = -1;

    FixedSizeArrayStack() {
        this(CAPACITY);
    }

    FixedSizeArrayStack(int capacity) {
        this.capacity = capacity;
        stack = new int[capacity];
    }

    public int size() {
        return top + 1;
    }

    public boolean isEmpty() {
        return top < 0;
    }

    public boolean isFull() {
        return size() == capacity;
    }

    public void push(int data) throws Exception {
        if(isFull()) throw new Exception("Stack is full.");
        
        stack[++top] = data;
    }

    public int pop() throws Exception {
        if(isEmpty()) throw new Exception("Stack is empty.");

        int data = stack[top];
        stack[top--] = Integer.MIN_VALUE;
        return data;
    }

    public int top() throws Exception {
        if (isEmpty()) throw new Exception("Stack is empty.");

        return stack[top];
    }

    public String toString() {
        String s;

        s = "[";

        if(size() > 0) s += stack[0];

        if(size() > 1) {
            for (int i = 1; i <= size() - 1; i++) {
                s += ", " + stack[i];
            }
        }

        return s + "]";
    }

}
