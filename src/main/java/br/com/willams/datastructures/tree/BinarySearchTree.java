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

	protected boolean nonRecursive = true;

	public static int PRE = 0;
	public static int IN = 1;
	public static int POS = 2;
	public static int LVL = 3;

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

		if(type == LVL) {
			levelOrder(root);
			System.out.println();
			return;
		}

		if(nonRecursive == true) {
			if(type == IN)
				inOrderNonRecursive(root);
			else if(type == POS)
				posOrderNonRecursive(root);
			else
				visitNode(root, type);
		} else {
			visitNode(root, type);
		}
		System.out.println();
	}

	private void levelOrder(Node root) {
		Queue<Node> queue = new LinkedList<Node>();
		Node temp = null;

		if(root == null) return;

		queue.add(root);
		
		while(!queue.isEmpty()) {
			temp = queue.poll();

			System.out.print(temp.key + " ");

			if(temp.left != null) {
				queue.add(temp.left);
			}

			if(temp.right != null) {
				queue.add(temp.right);
			}
		}
	}

	// Complexity O(n)  Space O(n)
	private void inOrderNonRecursive(Node root) {
		Stack<Node> stack = new Stack<Node>();

		while(true) {
			while(root != null) {
				stack.push(root);
				root = root.left;
			}

			if(stack.isEmpty()) {
				break;
			}

			root = stack.pop();

			System.out.print(root.key + " ");
			
			root = root.right;
		}
	}
	
	// Complexity O(n)  Space O(n)
	private void posOrderNonRecursive(Node root) {
		Stack<Node> stack = new Stack<Node>();
		Node previous = null;
		
		do {
			while(root != null) {
				stack.push(root);
				root = root.left;
			}

			while(root == null && !stack.isEmpty()) {
				root = stack.peek();

				if(root.right == null || root.right == previous) {
					System.out.print(root.key + " ");
					stack.pop();
					previous = root;
					root = null;
				} else {
					root = root.right;
				}
			}
		} while(!stack.isEmpty());
	}
	
	// Complexity O(n)  Space O(n)
	void preOrderNonRecursive(Node root) {
		Stack<Node> stack = new Stack<Node>();
		while(true) {
			while(root != null) {
				System.out.print(root.key + " ");
				stack.push(root);

				root = root.left;
			}

			if(stack.isEmpty())
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
		return minNode(root);
	}

	public int minNode(Node node) {
		var curr = node;
		
		while (curr != null && curr.left != null) {
			curr = curr.left;
		}
		
		return curr.key;
	}

	public int max() {
		return maxNode(root);
	}

	protected int maxNode(Node node) {
		var curr = node;
		
		while (curr != null && curr.right != null) {
			curr = curr.right;
		}
		
		return curr.key; 
	}

	public boolean search(int key) {
		return searchNode(root, key);
	}

	protected boolean searchNode(Node node, int key) {
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

	protected Node removeNode(Node node, int key) {
		
		if(node == null) {
			return null;
		}
		
		if(key < node.key) {
			node.left = removeNode(node.left, key);
		} else if(key > node.key) {
			node.right = removeNode(node.right, key);
		} else {
			
			if(node.left == null) {
				return node.right;
			}

			if(node.right == null) {
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
		
		System.out.print("\nProcurando o valor 10... Valor 10 "+ (bst.search(10) ? "encontrado." : "não encontrado."));
		System.out.print("\nProcurando o valor 4... Valor 4 " + (bst.search(4) ? "encontrado." : "não encontrado."));
		
		System.out.println("\n\nRemovendo o valor 15...");
		
		System.out.print("\n\nÁvore antes de remover  ==> ");
		bst.visit(BinarySearchTree.IN);
		
		bst.remove(15);
		
		System.out.print("\nÁvore depois de remover  ==> ");
		bst.visit(BinarySearchTree.IN);
	}
}

/* 

Saída esperada:

$ java BinarySearchTree.java

 
Visitando PRE ORDER ==> 11 7 5 3 6 9 8 10 15 13 12 14 20 18 25 


Visitando IN ORDER  ==> 3 5 6 7 8 9 10 11 12 13 14 15 18 20 25 


Visitando POS ORDER ==> 3 6 5 8 10 9 7 12 14 13 18 25 20 15 11 


Visitando LEVEL ORDER ==> 11 7 15 5 9 13 20 3 6 8 10 12 14 18 25 

Menor valor = 3

Maior valor = 25

Procurando o valor 10... Valor 10 encontrado.
Procurando o valor 4... Valor 4 não encontrado.

Removendo o valor 15...


Ávore antes de remover  ==> 3 5 6 7 8 9 10 11 12 13 14 15 18 20 25 

Ávore depois de remover  ==> 3 5 6 7 8 9 10 11 12 13 14 18 20 25


 */
