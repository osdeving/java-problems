package br.com.willams.datastructures.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree {
	protected class Node {
		public Node(int key) {
			this.key = key;
		}

		public int key;
		public Node left;
		public Node right;
	}

	protected Node root;

	protected boolean nonRecursive = false;

	public static int PRE = 0;
	public static int IN = 1;
	public static int POS = 2;
	public static int LVL = 3;

	public void insert(int key) {
		if(nonRecursive)
			 insertNonRecursive(root, key);
		else
			this.root = insertNode(root, key);
	}

	// Time O(n) | Space O(n) (para recursive stack) 
	private Node insertNode(Node root, int key) {
		if (root == null) 
			root = new Node(key);
		else if (key < root.key) 
			root.left =	insertNode(root.left, key);
		else if(key > root.key)
			root.right = insertNode(root.right, key);
		
		return root;
	}

	// Time O(n) | Space O(1)
	private void insertNonRecursive(Node root, int key) {
		while(root != null) {
			if(key == root.key) 
				return;

			if(key > root.key) 
				root = root.right;
			else 
				root = root.left;
		}

		root = new Node(key);
	}

	public void visit(int type) {

		if (type == LVL) {
			levelOrder(root);
			System.out.println();
			return;
		}

		if (nonRecursive == true) {
			if (type == IN)
				inOrderNonRecursive(root);
			else if (type == POS)
				posOrderNonRecursive(root);
			else
				visitNode(root, type);
		} else {
			visitNode(root, type);
		}
		System.out.println();
	}

	// Time O(n) Space O(n)
	private void levelOrder(Node root) {
		Queue<Node> queue = new LinkedList<Node>();
		Node temp = null;

		if (root == null)
			return;

		queue.add(root);

		while (!queue.isEmpty()) {
			temp = queue.poll();

			System.out.print(temp.key + " ");

			if (temp.left != null) {
				queue.add(temp.left);
			}

			if (temp.right != null) {
				queue.add(temp.right);
			}
		}
	}

	// Time O(n) Space O(n)
	private void inOrderNonRecursive(Node root) {
		Stack<Node> stack = new Stack<Node>();

		while (true) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}

			if (stack.isEmpty()) {
				break;
			}

			root = stack.pop();

			System.out.print(root.key + " ");

			root = root.right;
		}
	}

	// Time O(n) Space O(n)
	private void posOrderNonRecursive(Node root) {
		Stack<Node> stack = new Stack<Node>();
		Node previous = null;

		do {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}

			while (root == null && !stack.isEmpty()) {
				root = stack.peek();

				if (root.right == null || root.right == previous) {
					System.out.print(root.key + " ");
					stack.pop();
					previous = root;
					root = null;
				} else {
					root = root.right;
				}
			}
		} while (!stack.isEmpty());
	}

	// Time O(n) Space O(n)
	void preOrderNonRecursive(Node root) {
		Stack<Node> stack = new Stack<Node>();
		while (true) {
			while (root != null) {
				System.out.print(root.key + " ");
				stack.push(root);

				root = root.left;
			}

			if (stack.isEmpty())
				break;

			root = stack.pop();
			root = root.right;
		}
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
		if(root == null) {
			throw new IllegalStateException("Chamando min() em uma ??rvore vazia");
		}

		if(nonRecursive)
			return minNonRecursive(root);
		else
			return minNode(root);
	}

	// Time O(n) (pior caso, skew-tree) | Space O(n) (por causa do recursive stack)
	public int minNode(Node root) {
		if(root.left == null)
			return root.key;
		else
			return minNode(root.left);
	}

	// Time O(n) (pior caso, skew-tree) | Space O(1) 
	public int minNonRecursive(Node node) {
		while(root.left != null) 
			root = root.left;
		return root.key;
	}

	public int max() {
		if(root == null) {
			throw new IllegalStateException("Chamando max() em uma ??rvore vazia");
		}

		if(nonRecursive)
			return maxNonRecursive(root);
		else
			return maxNode(root);
	}

	// Time O(n)  (pior caso, skew-tree) | Space O(1)
	protected int maxNonRecursive(Node root) {
		while(root.right != null) 
			root = root.right;
		return root.key;
	}

	// Time O(n) (pior caso, skew-tree) | Space O(n) (por causa do recursive stack)
	protected int maxNode(Node root) {
		if(root.right == null)
			return root.key;
		else
			return maxNode(root.right);
	}

	public boolean search(int key) {
		if(nonRecursive)
			return searchNodeNonRecursive(root, key);
		else
			return searchNode(root, key);
	}

	
	//
	// Nota: percorre a ??rvore como se fosse uma lista (curr = curr.next) mas decide se 'next' ser?? right ou left
	// efetuando um poss??vel zigue-zague. 'Poss??vel', porque se a ??rvore estiver completamente desbalanceada (skew-tree)
	// de fato ser?? uma lista encadeada ordenada
	//
	// pior caso ?? O(n) (skew-tree) melhor caso O(logn) (complete-binary-tree)
	boolean searchNodeNonRecursive(Node root, int key) {
		while(root != null) {
			if(key == root.key) 
				return true;

			if(key > root.key) 
				root = root.right;
			else 
				root = root.left;
		}

		// root aqui ?? igual null
		// significa que root j?? chegou null ou percorreu para direita e esquerda sem nunca key==node.key 
		return false;
	}

	// pior caso ?? O(n) (skew-tree) melhor caso O(logn) (complete-binary-tree)
	protected boolean searchNode(Node root, int key) {
		if (root == null) 
			return false;
		
		if (key < root.key) 
			return searchNode(root.left, key);
		else if (key > root.key) 
			return searchNode(root.right, key);
		else 
			return true;
	}

	public void remove(int key) {
		root = removeNode(root, key);
	}

	protected Node removeNode(Node node, int key) {

		if (node == null) {
			return null;
		}

		if (key < node.key) {
			node.left = removeNode(node.left, key);
		} else if (key > node.key) {
			node.right = removeNode(node.right, key);
		} else {

			if (node.left == null) {
				return node.right;
			}

			if (node.right == null) {
				return node.left;
			}

			node.key = minNode(node.right);
			node.right = removeNode(node.right, node.key);
		}

		return node;
	}

	public static void main(String[] args) {

		var list = List.of(11, 7, 15, 5, 3, 9, 8, 10, 13, 12, 14, 20, 18, 25, 6);

		var bst = new BinarySearchTree();
		list.stream().forEach(e -> bst.insert(e));

		System.out.print("\n\nVisitando PRE ORDER ==> ");
		bst.visit(BinarySearchTree.PRE);

		System.out.print("\n\nVisitando IN ORDER  ==> ");
		bst.visit(BinarySearchTree.IN);

		System.out.print("\n\nVisitando POS ORDER ==> ");
		bst.visit(BinarySearchTree.POS);

		System.out.print("\n\nVisitando LEVEL ORDER ==> ");
		bst.visit(BinarySearchTree.LVL);

		System.out.println("\nMenor valor = " + bst.min());
		System.out.println("\nMaior valor = " + bst.max());

		System.out.print("\nProcurando o valor 10... Valor 10 " + (bst.search(10) ? "encontrado." : "n??o encontrado."));
		System.out.print("\nProcurando o valor 4... Valor 4 " + (bst.search(4) ? "encontrado." : "n??o encontrado."));

		System.out.println("\n\nRemovendo o valor 15...");

		System.out.print("\n\n??vore antes de remover  ==> ");
		bst.visit(BinarySearchTree.IN);

		bst.remove(15);

		System.out.print("\n??vore depois de remover  ==> ");
		bst.visit(BinarySearchTree.IN);
	}
}

/*
 * 
 * Sa??da esperada:
 * 
 * $ java BinarySearchTree.java
 * 
 * 
 * Visitando PRE ORDER ==> 11 7 5 3 6 9 8 10 15 13 12 14 20 18 25
 * 
 * 
 * Visitando IN ORDER ==> 3 5 6 7 8 9 10 11 12 13 14 15 18 20 25
 * 
 * 
 * Visitando POS ORDER ==> 3 6 5 8 10 9 7 12 14 13 18 25 20 15 11
 * 
 * 
 * Visitando LEVEL ORDER ==> 11 7 15 5 9 13 20 3 6 8 10 12 14 18 25
 * 
 * Menor valor = 3
 * 
 * Maior valor = 25
 * 
 * Procurando o valor 10... Valor 10 encontrado.
 * Procurando o valor 4... Valor 4 n??o encontrado.
 * 
 * Removendo o valor 15...
 * 
 * 
 * ??vore antes de remover ==> 3 5 6 7 8 9 10 11 12 13 14 15 18 20 25
 * 
 * ??vore depois de remover ==> 3 5 6 7 8 9 10 11 12 13 14 18 20 25
 * 
 * 
 */
