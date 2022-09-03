package br.com.willams.playground;

import static br.com.willams.util.ConsolePrinter.*;

public class Tree {
	class Node {
		public Node(int key) {
			this.key = key;
		}

		public int key;
		public Node left;
		public Node right;
	}

	private Node root;

	public static int PRE = 0;
	public static int IN = 1;
	public static int POS = 2;

	public void insert(int key) {
		if (root == null) {
			root = new Node(key);
		} else {
			insertNode(root, key);
		}
	}

	private void insertNode(Node node, int key) {
		if (key < node.key) {
			if (node.left == null) {
				node.left = new Node(key);
			} else {
				insertNode(node.left, key);
			}

		} else {
			if (node.right == null) {
				node.right = new Node(key);
			} else {
				insertNode(node.right, key);
			}
		}
	}

	public void visit(int type) {
		visitNode(root, type);
		System.out.println();
	}

	public void visitNode(Node node, int type) {
		if (node != null) {

			if (type == PRE) {
				System.out.print(node.key + " ");
			}

			visitNode(node.left, type);

			if (type == IN) {
				System.out.print(node.key + " ");
			}

			visitNode(node.right, type);

			if (type == POS) {
				System.out.print(node.key + " ");
			}
		}
	}

	public int min() {
		return minNode(root);
	}

	public int minNode(Node node) {
		var curr = node;
		while (curr != null && curr.left != null)
			curr = curr.left;
		return curr.key; // deveria checar null
	}

	public Node minNode2(Node node) {
		var curr = node;
		while (curr != null && curr.left != null)
			curr = curr.left;
		return curr;
	}

	public int max() {
		return maxNode(root);
	}

	private int maxNode(Node node) {
		var curr = node;
		while (curr != null && curr.right != null)
			curr = curr.right;
		return curr.key; // deveria checar null
	}

	public boolean search(int key) {
		return searchNode(root, key);
	}

	private boolean searchNode(Node node, int key) {
		if (node == null) {
			return false;
		}

		if (key < node.key) {
			return searchNode(node.left, key);
		} else if (key > node.key) {
			return searchNode(node.right, key);
		} else {
			return true;
		}
	}

	public void remove(int key) {
		root = removeNode(root, key);
	}

	private Node removeNode(Node node, int key) {
		
		if(node == null) return null;
		
		if(key < node.key) 
			node.left = removeNode(node.left, key);
		else if(key > node.key) 
			node.right = removeNode(node.right, key);
		else {
			
			if(node.left == null) return node.right;
			if(node.right == null) return node.left;

			var m = minNode2(node.right);
			node.key = m.key;
			//m = null;
			
			System.out.println(root.right.left.left.key);
			node.right = removeNode(node.right, m.key);
		}

		return node;
	}

	public static void main(String[] args) {
		var bst = new Tree();

		bst.insert(11);
		bst.insert(7);
		bst.insert(15);
		bst.insert(5);
		bst.insert(3);
		bst.insert(9);
		bst.insert(8);
		bst.insert(10);
		bst.insert(13);
		bst.insert(12);
		bst.insert(14);
		bst.insert(20);
		bst.insert(18);
		bst.insert(25);
		bst.insert(6);

		// 11 7 5 3 6 9 8 10 15 13 12 14 20 18 25
		strongWhite("\n\nVisitando PRE ORDER ==> ");
		bst.visit(Tree.PRE);

		// 3 5 6 7 8 9 10 11 12 13 14 15 18 20 25
		strongWhite("\n\nVisitando IN ORDER  ==> ");
		bst.visit(Tree.IN);

		// 3 6 5 8 10 9 7 12 14 13 18 25 20 15 11
		strongWhite("\n\nVisitando POS ORDER ==> ");
		bst.visit(Tree.POS);

		bst.insert(12012);
		bst.insert(0);

		// Menor valor = 0
		// Maior valor = 12012
		purple("\nMenor valor = " + bst.min()).ln();
		purple("\nMaior valor = " + bst.max()).ln().ln();

		// Procurando o valor 10... Valor 10 não encontrado.
		// Procurando o valor 4... Valor 4 não encontrado.
		strongBlue("Procurando o valor 10... Valor 10 ");
		strongGreen((bst.search(10)) ? "encontrado." : " não encontrado.").ln();
		strongBlue("Procurando o valor 4... Valor 4 ");
		strongRed((bst.search(4)) ? "encontrado." : " não encontrado.").ln().ln();

		strongWhite("Removendo o valor 15...").ln();

		// 3 5 6 7 8 9 10 11 12 13 14 15 18 20 25
		strongWhite("\n\nÁvore").strongGreen(" antes").strongWhite(" de remover  ==> ");
		bst.visit(Tree.IN);

		bst.remove(15);

		// 3 5 7 8 9 10 11 12 13 14 15 18 20 25
		strongWhite("\n\nÁvore").strongRed(" depois").strongWhite(" de remover  ==> ");
		bst.visit(Tree.IN);

	}
}
