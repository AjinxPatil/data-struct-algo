package datastructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QueueDemo {
	public static void main(String[] args) throws IOException {
		AQueue queue = new AQueue(Integer.parseInt(args[0]));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.println("\nQueue Operations");
			System.out.println("(1) Front (2) Rear (3) Enqueue  (4) Dequeue"
					+ " (5) Print  (6) Exit");
			int option = Integer.parseInt(in.readLine());
			switch (option) {
			case 1:
				System.out.println("Front: " + queue.getFront());
				break;
			case 2:
				System.out.println("Rear: " + queue.getRear());
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
