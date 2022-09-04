package br.com.willams.datastructures.tree;

import java.util.List;

public class AVLTree extends BinarySearchTree {

	public int height(Node node) {
		if (node == null) {
			return -1;
		}

		int hl = height(node.left);
		int hr = height(node.right);

		int h = Math.max(hl, hr);

		return h + 1;
	}

	public BalancedType balanceFactor(Node node) {
		var diff = height(node.left) - height(node.right);

		switch (diff) {
			case -2:
				return BalancedType.UNBALANCED_RIGHT;
			case -1:
				return BalancedType.SLIGHTLY_UNBALANCED_RIGHT;
			case 1:
				return BalancedType.SLIGHTLY_UNBALANCED_LEFT;
			case 2:
				return BalancedType.UNBALANCED_LEFT;
			default:
				return BalancedType.BALANCED;
		}
	}

	private Node rotationLL(Node node) {
		var temp = node.left;
		node.left = temp.right;
		temp.right = node;
		return temp;
	}

	private Node rotationRR(Node node) {
		var temp = node.right;
		node.right = temp.left;
		temp.left = node;
		return temp;
	}

	private Node rotationLR(Node node) {
		node.left = rotationRR(node.left);
		return rotationLL(node);
	}

	private Node rotationRL(Node node) {
		node.right = rotationLL(node.right);
		return rotationRR(node);
	}

	public void insert(int key) {
		root = this.insertNode(root, key);
	}

	private Node insertNode(Node node, int key) {
		if (node == null) {
			return new Node(key);
		} else if (key < node.key) {
			node.left = this.insertNode(node.left, key);
		} else if (key > node.key) {
			node.right = this.insertNode(node.right, key);
		} else {
			return node;
		}

		var balanceFactor = balanceFactor(node);

		if (balanceFactor == BalancedType.UNBALANCED_LEFT) {
			if (key < node.left.key) {
				node = rotationLL(node);
			} else {
				return rotationLR(node);
			}
		}

		if (balanceFactor == BalancedType.UNBALANCED_RIGHT) {
			if (key > node.right.key) {
				node = rotationRR(node);
			} else {
				return rotationRL(node);
			}
		}

		return node;
	}

	public void remove(int key) {
		this.removeNode(root, key);
	}

	protected Node removeNode(Node node, int key) {
		node = super.removeNode(node, key);

		if(node == null) {
			return node;
		}

		var balanceFactor = balanceFactor(node);

		if(balanceFactor == BalancedType.UNBALANCED_LEFT) {	
			var balanceFactorLeft = balanceFactor(node.left);
			
			if(balanceFactorLeft == BalancedType.BALANCED || balanceFactorLeft ==BalancedType.SLIGHTLY_UNBALANCED_LEFT) {
				rotationLL(node);
			}

			if(balanceFactorLeft == BalancedType.SLIGHTLY_UNBALANCED_RIGHT) {
				return rotationLR(node.left);
			}

		}

		if(balanceFactor == BalancedType.UNBALANCED_RIGHT) {
			var balanceFactorRight = balanceFactor(node.right);

			if(balanceFactorRight == BalancedType.BALANCED || balanceFactorRight == BalancedType.SLIGHTLY_UNBALANCED_RIGHT) {
				return rotationRR(node);
			} else if(balanceFactorRight == BalancedType.SLIGHTLY_UNBALANCED_LEFT) {
				return rotationRL(node.right);
			}
		}

		return node;
	}

	public static void main(String[] args) {
		var list = List.of(8, 10, 24, 47, 50, 81, 85);
		
		var avl = new AVLTree();
		list.stream().forEach(e -> avl.insert(e));

		System.out.println("\n\nRemovendo o valor 85...");
		
		System.out.print("\n\nÁvore antes de remover  ==> ");
		avl.visit(BinarySearchTree.IN);
		
		avl.remove(85);
		
		System.out.print("\nÁvore depois de remover  ==> ");
		avl.visit(BinarySearchTree.IN);
	}
}
