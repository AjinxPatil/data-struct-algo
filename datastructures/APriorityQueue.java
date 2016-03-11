package datastructures;

/**
 * <code>APriorityQueue</code> is an abstract data type that behaves like a
 * queue except that each item in it has an associated "priority". An item with
 * high priority is always retrieved before an item with low priority. If two
 * items have same priority, they are retrieved according to their order in
 * queue (FIFO). Following implementation is constructed using a singly linked
 * list.
 * 
 * @author Ajinkya Patil
 * @see java.util.PriorityQueue
 */
public class APriorityQueue {
	public static class Item {
		public int data;
		public int priority;
		public Item next;

		public Item(int data, int priority) {
			this.data = data;
			this.priority = priority;
		}
	}

	private Item front;
	private Item rear;

	public boolean isEmpty() {
		return rear == null ? true : false;
	}

	/**
	 * Inserts an item in the queue. It can always insert item due to linked list
	 * implementation.
	 * 
	 * @param data
	 * @param priority
	 */
	public void add(int data, int priority) {
		Item item = new Item(data, priority);
		if (isEmpty()) {
			rear = item;
			front = rear;
			return;
		}
		rear.next = item;
		rear = rear.next;
	}

	/**
	 * 
	 * @return the highest priority element but does not remove it from queue
	 */
	public int peek() {
		Item pass = front;
		Item mark = pass;
		while (pass != null) {
			if (pass.priority > mark.priority) {
				mark = pass;
			}
			pass = pass.next;
		}
		return mark.data;
	}

	/**
	 * 
	 * @return the highest priority element and removes it from queue
	 */
	public int remove() {
		Item pass = front;
		Item passprev = null;
		Item markprev = null;
		Item mark = pass;
		while (pass != null) {
			if (pass.priority > mark.priority) {
				mark = pass;
				markprev = passprev;
			}
			passprev = pass;
			pass = pass.next;
		}
		int max = mark.data;
		// if front element has highest priority
		if (markprev == null) {
			// if queue contains single element
			if (rear == front) {
				front = null;
				rear = null;
			} else {
				front = front.next;
			}
			return max;
		}
		markprev.next = mark.next;
		mark = null;
		return max;
	}

	public void print() {
		if (isEmpty()) {
			System.out.println("EMPTY");
			return;
		}
		Item pass = front;
		while (pass != null) {
			System.out.print(pass.data + " [" + pass.priority + "], ");
			pass = pass.next;
		}
		System.out.println();
	}
}
