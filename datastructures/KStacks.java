package datastructures;

/**
 * <code>KStacks</code> is an abstract data type that stores data in collection
 * of stacks. Each stack in <code>KStacks</code> is implemented in a single
 * array.
 * 
 * @author Ajinkya Patil
 */
public class KStacks {
	int stacks;
	int capacity;
	int nextFree;
	int[] next;
	int[] tops;
	Integer[] contents;

	public KStacks(int s, int c) {
		s = c >= s ? s : c;
		stacks = s;
		capacity = c;
		contents = new Integer[capacity];
		next = new int[capacity];
		for (int i = 0; i < capacity - 1; i++) {
			next[i] = i + 1;
		}
		next[capacity - 1] = -1;
		tops = new int[stacks];
		for (int i = 0; i < stacks; i++) {
			tops[i] = -1;
		}
		nextFree = 0;
	}

	public boolean isFull() {
		return nextFree == -1 ? true : false;
	}

	public void push(int data, int stack) {
		if (isFull()) {
			return;
		}
		int pos = nextFree;
		nextFree = next[nextFree];

		next[pos] = tops[stack];
		tops[stack] = pos;
		contents[pos] = data;
	}

	public Integer pop(int stack) {
		int top = tops[stack];
		if (top == -1) {
			return null;
		}
		int data = contents[top];
		contents[top] = null;
		tops[stack] = next[top];
		next[top] = nextFree;
		nextFree = top;
		return data;
	}

	public void print(int stack) {
		if (stack >= stacks) {
			return;
		}
		System.out.println("Stack");
		System.out.println("-----");
		for (int i = tops[stack]; i > -1; i = next[i]) {
			System.out.println(contents[i]);
		}
		System.out.println("-----");
	}
}
