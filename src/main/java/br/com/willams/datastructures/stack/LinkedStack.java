package br.com.willams.datastructures.stack;

class ListNode<T> {
    T data;
    ListNode next;

    ListNode(T data) {
        this.data = data;
    }
}

public class LinkedStack<T> {
    private int length;
    private ListNode<T> top;

    public void push(T data) {
        ListNode<T> temp = new ListNode<T>(data);

        temp.next = top;
        top = temp;
        length++;
    }

    public T pop() throws Exception {
        if(isEmpty()) throw new Exception("Stack is empty.");

        T result = top.data;
        top = top.next;
        length--;
        return result;
    }

    public T peek() throws Exception {
        if(isEmpty()) throw new Exception("Stack is empty.");

        return top.data;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public String toString() {
        var result = new StringBuilder(length);

        ListNode<T> curr = top;

        do {
            //result.append(curr.toString() + "\n");
            result.append(curr.toString());
            result.append("\n");
        } while( (curr = curr.next) != null);
        
        return result.toString();
    }


    /* public String toString() {
        String result = "";

        ListNode<T> curr = top;

        do {
            result += curr.toString() + "\n";
        } while ((curr = curr.next) != null);

        return result.toString();
    }*/

}
