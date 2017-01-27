package datastructures;

/**
 * <code>AQueue</code> is a data structure that stores elements in FIFO order.
 * Following implementation is constructed using an array.
 * 
 * @author Ajinkya Patil
 * @see java.util.concurrent.ArrayBlockingQueue
 */
public class AQueue {
	private Integer[] contents;
	private int front;
	private int rear;
	private int capacity;

	public AQueue(int c) {
		capacity = c;
		contents = new Integer[capacity];
		rear = -1;
		front = -1;
	}

	public void enqueue(int value) {
		if (isFull()) {
			return;
		}
		if (isEmpty()) {
			++front;
		}
		rear = rear == capacity - 1 ? 0 : rear + 1;
		contents[rear] = value;
	}

	public Integer dequeue() {
		if (isEmpty()) {
			return null;
		}
		int value = contents[front];
		if (front == rear) {
			front = -1;
			rear = -1;
			return value;
		}
		front = front == capacity - 1 ? 0 : front + 1;
		return value;
	}

	public boolean isEmpty() {
		return rear == -1 ? true : false;
	}

	public boolean isFull() {
		return rear == capacity - 1 ? (front == 0 ? true : false)
				: (rear + 1 == front ? true : false);
	}

	public Integer peekFront() {
		if (isEmpty()) {
			return null;
		}
		return contents[front];
	}

	public Integer peekRear() {
		if (isEmpty()) {
			return null;
		}
		return contents[rear];
	}

	public void print() {
		if (isEmpty()) {
			System.out.println("EMPTY");
			return;
		}
		int i = front;
		System.out.print("F (");
		while (i != rear) {
			System.out.print(contents[i] + " ");
			i = i == capacity - 1 ? 0 : i + 1;
		}
		System.out.print(contents[i] + ") R");
	}
}
