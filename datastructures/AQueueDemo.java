package datastructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Ajinkya Patil
 * @see datastructures.AQueue
 */
public class AQueueDemo {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Capacity of new queue: ");
		int capacity = Integer.parseInt(in.readLine());
		AQueue queue = new AQueue(capacity);
		while (true) {
			System.out.println("\nQueue Operations");
			System.out.println("(1) Front (2) Rear (3) Enqueue  (4) Dequeue"
					+ " (5) Print  (6) Exit");
			int option = Integer.parseInt(in.readLine());
			switch (option) {
			case 1:
				System.out.println("Front: " + queue.peekFront());
				break;
			case 2:
				System.out.println("Rear: " + queue.peekRear());
				break;
			case 3:
				System.out.print("Enqueue? ");
				int value = Integer.parseInt(in.readLine());
				queue.enqueue(value);
				break;
			case 4:
				System.out.println("Dequeued: " + queue.dequeue());
				break;
			case 5:
				queue.print();
				break;
			case 6:
				return;
			default:
				System.out.println("INVALID OPTION");
			}
		}
	}
}
