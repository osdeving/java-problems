package br.com.willams.datastructures.linkedlist;


public class LinkedList {
    class Node {
        Node(int element) {
            this.element = element;
        }

        public int element;
        public Node next;

        @Override
        public String toString() {
            return String.valueOf(element);
        }
    }

    Node head;
    int count;

    public void push(int element) {
        var node = new Node(element);

        if (head == null) {
            this.head = node;
        } else {
            Node current = this.head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = node;
        }

        this.count++;
    }

    public Node getElementAt(int index) {
        if (index >= 0 && index <= this.count) {
            var node = this.head;

            for (int i = 0; i < index && node != null; i++) {
                node = node.next;
            }

            return node;
        }

        return null;
    }

    public Node removeAt(int index) {
        if (index >= 0 && index <= this.count) {
            var current = this.head;

            if (index == 0) {
                this.head = current.next;
            } else {
                var previous = this.getElementAt(index - 1);
                current = previous.next;
                previous.next = current.next;
            }
            this.count--;
            return current;
        }
        return null;
    }

    public boolean insert(int element, int index) {
        if (index >= 0 && index <= this.count) {

            var current = this.head;


            for (int i = 0; i < this.count && current != null; i++, current = current.next) {

                var newNode = new Node(element);

                if (i == 0) {
                    newNode.next = this.head;
                    this.head = newNode;

                    this.count++;
                    return true;
                } else if (i == index) {
                    var oldCurrentNext = current.next;
                    current.next = newNode;
                    newNode.next = oldCurrentNext;

                    this.count++;
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.push(15);
        list.push(10);

        var e1 = list.getElementAt(0);
        var e2 = list.getElementAt(1);
        var e3 = list.getElementAt(2);

        System.out.println(e1);
        System.out.println(e2);
        System.out.println(e3);

        list.removeAt(1);

        e2 = list.getElementAt(1);

        list.insert(32, 0);

        System.out.println(list.getElementAt(0));
    }
}
