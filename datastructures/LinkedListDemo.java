package datastructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Ajinkya Patil
 * @see datastructures.SinglyLinkedList
 */
public class LinkedListDemo {
	public static void main(String[] args) throws IOException {
		SinglyLinkedList list = new SinglyLinkedList();
		SinglyLinkedList.Node node = null;
		for (int i = 0; i < args.length; i++) {
			node = new SinglyLinkedList.Node(Integer.parseInt(args[i]));
			list.add(node);
		}
		System.out.println("(1) Reverse (2) Remove (3) Remove all (4) Length"
				+ " (5) Swap (6) Merge 2");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int option = Integer.parseInt(in.readLine());
		int x, y;
		switch (option) {
		case 1:
			list.reverseByRecursion(list.head);
			System.out.print("\nReversed: ");
			list.print();
			break;
		case 2:
			System.out.print("Remove? ");
			x = Integer.parseInt(in.readLine());
			node = new SinglyLinkedList.Node(x);
			list.remove(node);
			System.out.print("List: ");
			list.print();
			break;
		case 3:
			System.out.print("Remove all? ");
			x = Integer.parseInt(in.readLine());
			node = new SinglyLinkedList.Node(x);
			list.removeAll(node);
			System.out.print("List: ");
			list.print();
			break;
		case 4:
			int size = list.lengthByRecursion(list.head);
			System.out.print("Length: " + size);
			break;
		case 5:
			System.out.println("Swap? Which 2?");
			x = Integer.parseInt(in.readLine());
			y = Integer.parseInt(in.readLine());
			list.swap(new SinglyLinkedList.Node(x), new SinglyLinkedList.Node(y));
			System.out.print("List: ");
			list.print();
			break;
		case 6:
			System.out
					.println("Merge two lists? Enter 2nd list " + "length and the list");
			SinglyLinkedList list2 = new SinglyLinkedList();
			SinglyLinkedList.Node nd = null;
			int len = Integer.parseInt(in.readLine());
			for (int i = 0; i < len; i++) {
				nd = new SinglyLinkedList.Node(Integer.parseInt(in.readLine()));
				list2.add(nd);
			}
			list.merge(list.head, list2.head);
			list.print();
		}
	}
}
