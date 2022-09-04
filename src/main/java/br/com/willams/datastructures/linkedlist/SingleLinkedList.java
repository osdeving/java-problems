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

    // Time O(n)
    // Space O(1)
    public void insert(int data, int position) {
        ListNode newNode = new ListNode();
        newNode.data = data;
        newNode.next = null;

        // caso 1: insere no início
        if(position == 1) {
            newNode.next = this.head;
            this.head = newNode;
            return;
        }

        // case 2: insere no final ou no meio
        ListNode previous = head;
        ListNode current = head;

        int k = 0;
        while(current != null && k < position) {
            k++;
            previous = current;
            current = current.next;
        }

        // o next do nó anterior apontará para o novo nó
        previous.next = newNode;

        // current é igual null se a inserção for no final e o novo nó será o último com next apontando pra null
        //current é um nó válido se k == position e o novo nó terá next apontando para current
        newNode.next = current;
    }
}
