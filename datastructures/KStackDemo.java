package datastructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Ajinkya Patil
 * @see datastructures.KStacks
 */
public class KStackDemo {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Number of stacks: ");
		int stackCount = Integer.parseInt(in.readLine());
		System.out.print("\nSize of each stack: ");
		int stackSize = Integer.parseInt(in.readLine());
		KStacks stack = new KStacks(stackCount, stackSize);

		while (true) {
			System.out.println("\nStack Operations");
			System.out.println("(1) Push  (2) Pop  (3) Print  (4) Exit");
			int option = Integer.parseInt(in.readLine());
			int stk;
			switch (option) {
			case 1:
				System.out.print("Push? ");
				int value = Integer.parseInt(in.readLine());
				System.out.print("In stack ");
				stk = Integer.parseInt(in.readLine());
				stack.push(value, stk);
				break;
			case 2:
				System.out.print("Pop from stack ");
				stk = Integer.parseInt(in.readLine());
				System.out.println("Popped: " + stack.pop(stk));
				break;
			case 3:
				System.out.print("Stack? ");
				stk = Integer.parseInt(in.readLine());
				stack.print(stk);
				break;
			case 4:
				return;
			default:
				System.out.println("ERROR: Invalid option!");
			}
		}
	}
}
