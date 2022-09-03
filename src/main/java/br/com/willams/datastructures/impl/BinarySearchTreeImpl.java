package br.com.willams.datastructures.impl;

import java.util.Comparator;
import java.util.function.Consumer;


import br.com.willams.datastructures.BinarySearchTree;
import br.com.willams.datastructures.TraversalType;

import static br.com.willams.util.ConsolePrinter.*;



public class BinarySearchTreeImpl<T> implements BinarySearchTree<T> {
	private static final String FOUND_STRING = " found";
	private static final String NOT_FOUND_STRING = " not found";
	

	class Node  {

		Node(T element) {
			this.element = element;
		}

		public T element;
		public Node left;
		public Node right;

		@Override
		public String toString() {
			return String.valueOf(element);
		}
	}

	private Node root;

	@Override
	public void traversal(Consumer<T> consumer, TraversalType traversalType) {
		switch(traversalType) {
			case IN_ORDER:
				inOrder(root, consumer);
				break;
			case PRE_ORDER:
				preOrder(root, consumer);
				break;
			case POS_ORDER:
				posOrder(root, consumer);
				break;
		}
	}

	@Override
	public void insert(T element, Comparator<T> comparator) {
		if (this.root == null) {
			this.root = new Node(element);
		} else {
			this.insertNode(this.root, element, comparator);
		}
	}

	@Override
	public void remove(T element, Comparator<T> comparator) {
		this.root = removeNode(this.root, element, comparator);
	}

	private Node removeNode(Node node, T element, Comparator<T> comparator) {
		if(node == null) {
			return null;
		}

		if(comparator.compare(element, node.element) < 0) {
			node.left = removeNode(node.left, element, comparator);
			return node;
		} else if(comparator.compare(element, node.element) > 0) {
			node.right = removeNode(node.right, element, comparator);
			return node;
		} else {
			if(node.left == null && node.right == null) {
				node = null;
				return node;
			}

			if(node.left == null) {
				node = node.right;
				return node;
			} else if(node.right == null) {
				node = node.left;
				return node;
			}

			var aux = minNode(node.right);
			node.element = aux;
			node.right = removeNode(node.right, aux, comparator);
			return node;
		}
	}

	@Override
	public T min() {
		return this.minNode(this.root);
	}

	@Override
	public T max() {
		return this.maxNode(this.root);
	}
	
	@Override
	public boolean search(T element, Comparator<T> comparator) {
		return searchNode(this.root, element, comparator);
	}


	private boolean searchNode(Node node, T element, Comparator<T> comparator) {
		
		if(node == null) {
			return false;
		}

		if(comparator.compare(element, node.element) < 0) {
			return searchNode(node.left, element, comparator);
		} else if(comparator.compare(element, node.element) > 0) {
			return searchNode(node.right, element, comparator);
		} else {
			return true;
		}
	}

	private T minNode(Node root) {
		var current = root;

		while(current != null && current.left != null) {
			current = current.left;
		}

		if(current !=null && current.left != null) {
			return current.left.element;
		} else {
			return null;
		}
	}	
	
	private T maxNode(Node root) {
		var current = root;

		while(current != null && current.right != null) {
			current = current.right;
		}

		if(current != null && current.right != null) {
			return current.right.element;
		} else {
			return null;
		}
	}

	private void preOrder(Node node, Consumer<T> consumer) {
		if(node != null) {
			consumer.accept(node.element);
			preOrder(node.left, consumer);
			preOrder(node.right, consumer);
		} 
	}
	
	private void inOrder(Node node, Consumer<T> consumer) {
		if(node != null) {
			inOrder(node.left, consumer);
			consumer.accept(node.element);
			inOrder(node.right, consumer);
		} 
	}

	private void posOrder(Node node, Consumer<T> consumer) {
		if(node != null) {
			posOrder(node.left, consumer);
			posOrder(node.right, consumer);
			consumer.accept(node.element);
		} 
	}

	private void insertNode(Node node, T element, Comparator<T> comparator) {
		if (comparator.compare(element, node.element) < 0) {
			if (node.left == null) {
				node.left = new Node(element);
			} else {
				insertNode(node.left, element, comparator);
			}
		} else {
		 	if (node.right == null) {
				node.right = new Node(element);
			} else {
				insertNode(node.right, element, comparator);
			}
		}
	}

	
	public static void main(String[] args) {
		BinarySearchTree<Integer> bst = new BinarySearchTreeImpl<>();

		Comparator<Integer> comparator = (Integer a, Integer b) -> a - b;

		bst.insert(11, comparator);
		bst.insert(7, comparator);
		bst.insert(15, comparator);
		bst.insert(5, comparator);
		bst.insert(3, comparator);
		bst.insert(9, comparator);
		bst.insert(8, comparator);
		bst.insert(10, comparator);
		bst.insert(13, comparator);
		bst.insert(12, comparator);
		bst.insert(14, comparator);
		bst.insert(20, comparator);
		bst.insert(18, comparator);
		bst.insert(25, comparator);
		bst.insert(6, comparator);

		bst.traversal(e -> blue(e + " "), TraversalType.PRE_ORDER);
		ln();
		bst.traversal(e -> blue(e + " "), TraversalType.IN_ORDER);
		ln();
		bst.traversal(e -> blue(e + " "), TraversalType.POS_ORDER);
		ln();

		green("Number 6" + (bst.search(6, comparator) ? FOUND_STRING: NOT_FOUND_STRING)).ln();
		red("Number 46" + (bst.search(46, comparator) ? FOUND_STRING: NOT_FOUND_STRING)).ln();
		
		purple("Removing number 6").ln();
		bst.remove(6, comparator);
		strongRed("Now number 6" + (bst.search(6, comparator) ? FOUND_STRING: NOT_FOUND_STRING)).ln();
	}
}
