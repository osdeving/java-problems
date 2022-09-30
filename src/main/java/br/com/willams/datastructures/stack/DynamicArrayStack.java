package br.com.willams.datastructures.stack;

public class DynamicArrayStack {

    // Default array capacity
    protected int capacity; // power of two
    public static final int CAPACITY = 16; // power of two
    private static final int MINCAPACITY = 0;

    // Array used to implement the stack
    protected int[] stackRep;

    // Index of the top element of the stack in the array
    protected int top = -1;

    // Intializes the stack to use an array of default length
    public DynamicArrayStack() {
        this(CAPACITY);
    }

    public DynamicArrayStack(int capacity) {
        this.capacity = capacity;
        stackRep = new int[capacity];
    }    

    public int size() {
        return top + 1;
    }

    public boolean isEmpty() {
        return top < 0;
    }

    public void push(int data) throws Exception {
        if(size() == capacity) {
            expand();
        }
        
        stackRep[++top] = data;
    }

    private void expand() {
        int length = size();
        int[] newStack = new int[length << 1];

        System.arraycopy(stackRep, 0, newStack, 0, length);

        stackRep = newStack;
        this.capacity = length;
    }

    private void shrink() {
        int length = top + 1;

        if(length <= MINCAPACITY || top << 2 >= length)
            return;

        length = length + (top<<1); // still means shrink to at 1/2 or less of the heap

        if(top < MINCAPACITY)
            length = MINCAPACITY;

        int[] newStack = new int[length];

        System.arraycopy(stackRep, 0, newStack, 0, top + 1);

        stackRep = newStack;
        this.capacity = length;
     }

     public int top() throws Exception {

        if(isEmpty()) throw new Exception("Stack is empty.");

        int data = stackRep[top];

        stackRep[top--] = Integer.MIN_VALUE; // dereference S[top] for garbage collection.
        shrink();

        return data;
     }

     // retorna a representação da pilha em string [..., prev, top]. Time O(n)
     public String toString() {
         String s;

         s = "[";

         if (size() > 0)
             s += stackRep[0];

         if (size() > 1) {
             for (int i = 1; i <= size() - 1; i++) {
                 s += ", " + stackRep[i];
             }
         }

         return s + "]";
     }
}
