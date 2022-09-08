package br.com.willams.datastructures.linkedlist;

public class DoubleLinkedList {
    DLLNode head;

    // Time O(n)
    // Space O(1)
    public void print() {
        var current = head;
        while (current != null) {
            System.out.println("Node data = " + current.data);
            current = current.next;
        }
    }

    public void insert(int data, int position) {
        int k = 1;

        DLLNode temp = null;
        DLLNode newNode = new DLLNode();
        newNode.data = data;

        if (position == 1) {
            newNode.next = this.head;
            newNode.prev = null;

            if (this.head != null) {
                this.head.prev = newNode;
            }

            this.head = newNode;
            return;
        }
        temp = this.head;

        while ((k < position - 1) && temp.next != null) {
            temp = temp.next;
            k++;
        }

        newNode.next = temp.next;
        newNode.prev = temp;

        if (temp.next != null) {
            temp.next.prev = newNode;

            temp.next = newNode;
            return;
        }
    }

    public static void main(String[] args) {
        DoubleLinkedList dl = new DoubleLinkedList();
        dl.insert(1, 1);
        dl.insert(3, 2);
        dl.insert(5, 3);
        dl.insert(7, 4);
        dl.insert(9, 5);

        dl.print();
        
    }

}
