package br.com.willams.datastructures.linkedlist;

public class SingleLinkedList {
    public ListNode head;

    // Time O(n) para percorrer a lista de size n
    // Space O(1) para criar uma variável temporária
    public int length() {
        var current = head;
        int count = 0;

        while(current != null) {
            count++;
            current = current.next;
        }

        return count;
    }
}
