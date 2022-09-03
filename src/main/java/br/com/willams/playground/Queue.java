package br.com.willams.playground;

public class Queue {
	public int top;
	public int pos;
	public int[] items;

	private int capacity;
	private static int CAPACITY_INC = 10;

	public Queue() {
		capacity = 10;
		items = new int[10];
		top = 0;
		pos = 0;
	}

	public void push(int element) {
		top++;
		
		if(top > capacity) {
			int[] newArray = new int[capacity + CAPACITY_INC];
			
			for (int i = 0; i < items.length; i++) {
				newArray[i] = items[1];
			}

			capacity += CAPACITY_INC;
		}

		items[++pos] = element;
	}

	public int pop() {
		if(pos > top) {
			throw new IllegalStateException("Desenfileirando além dos limites");
		}

		return items[pos++];
	}
}
