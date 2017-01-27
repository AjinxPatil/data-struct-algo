package datastructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Ajinkya Patil
 * @see datastructures.AStack
 */
public class AStackDemo {
	public static void main(String[] args) throws IOException {
		System.out.print("Size of stack: ");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(in.readLine());
		AStack stack = new AStack(size);
		while (true) {
			System.out.println("\nStack Operations");
			System.out.println("(1) Peek  (2) Push  (3) Pop  (4) Print  (5) Exit");
			int option = Integer.parseInt(in.readLine());
			switch (option) {
			case 1:
				System.out.println("Found: " + stack.peek());
				break;
			case 2:
				System.out.print("Push? ");
				int value = Integer.parseInt(in.readLine());
				stack.push(value);
				break;
			case 3:
				System.out.println("Popped: " + stack.pop());
				break;
			case 4:
				stack.print();
				break;
			case 5:
				return;
			default:
				System.out.println("ERROR: Invalid option!");
			}
		}
	}
}
