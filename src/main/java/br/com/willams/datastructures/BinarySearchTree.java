package br.com.willams.datastructures;

import java.util.Comparator;
import java.util.function.Consumer;

public interface BinarySearchTree<T> {
	void traversal(Consumer<T> consumer, TraversalType traversalType);
	void insert(T element, Comparator<T> comparator);
	boolean search(T element, Comparator<T> comparator);
	T min();
	T max();
	void remove(T element, Comparator<T> comparator);
}
