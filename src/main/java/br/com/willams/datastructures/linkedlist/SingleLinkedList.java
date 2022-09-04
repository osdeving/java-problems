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
    public void print() {
        var current = head;
        while(current != null) {
            System.out.println("Node data = " + current.data);
            current = current.next;
        }
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

    // Time O(n)
    // Space O(1)
    void remove(int position) {
        // caso 1: remove o primeiro nó
        if(position == 1) {
            this.head = this.head.next;
            return;
        }

        // case 2: remove o último nó ou no meio
        ListNode previous = this.head;
        ListNode current = this.head;

        int k = 0;
        while(current != null && k < position) {
            k++;
            previous = current;
            current = current.next;
        }

        // posição não existe
        if(current == null) return;

        // isso efetivamente pula o nó, fazendo o próximo do anterior apontar para o próximo do atual.
        previous.next = current.next;
    }

    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();

        list.insert(40, 1);
        list.insert(15, 2);
        list.insert(7, 3);
        list.insert(4, 4);

        System.out.println("Imprimindo a lista: ");
        list.print();

        list.remove(2);

        System.out.println("Removendo o nó da posição 2: ");
        list.print();
    }
}
