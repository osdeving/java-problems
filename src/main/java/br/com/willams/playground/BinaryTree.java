package br.com.willams.playground;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    static public class Node {
        Node(int d) {
            data = d;
        }

        Node left;
        Node right;
        int data;
    }

    Node root;

    // DLR
    // Time O(N)
    // Space O(N)
    void preOrder(Node node) {
        if(node != null) {
            System.out.println(node.data);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    void levelOrder(Node node) {
        Queue q = new LinkedList();

        if(node == null) return;

        q.add(node);

        while(!q.isEmpty()) {
            var aux = (Node)q.remove();

            System.out.println(aux.data);

            if(aux.left != null) {
                q.add(aux.left);
            }

            if(aux.right  != null) {
                q.add(aux.right);
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree bst = new BinaryTree();

        bst.root = new BinaryTree.Node(41);
        bst.root.left = new BinaryTree.Node(20);
        bst.root.right = new BinaryTree.Node(65);
        bst.root.left.right = new BinaryTree.Node(29);
        bst.root.left.right.right = new BinaryTree.Node(32);
        bst.root.left.left = new BinaryTree.Node(11);
        bst.root.right.left = new BinaryTree.Node(50);
        bst.root.right.right = new BinaryTree.Node(91);
        bst.root.right.right.right = new BinaryTree.Node(99);
        bst.root.right.right.left = new BinaryTree.Node(72);
        

       // bst.preOrder(bst.root);
        System.out.println();
        bst.levelOrder(bst.root);

    }
}
