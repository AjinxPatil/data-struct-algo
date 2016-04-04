package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import datastructures.SinglyLinkedList;
import datastructures.SinglyLinkedList.Node;

/**
 * Cracking the Coding Interview - Data Structures 2 Linked Lists 2.4 Write code
 * to partition a linked list around a value x, such that all nodes less than x
 * come before all nodes greater than or equal to x. NOTE: Different solution
 * from the book!
 * 
 * @author Ajinkya Patil
 */
public class LlPartitioning {
	public static void partitionOnValue(int x, SinglyLinkedList list) {
		if (list == null) {
			return;
		}
		Node picker = list.head.next;
		Node prev = list.head;
		while (picker != null) {
			if (picker.data < x) {
				prev.next = picker.next;
				picker.next = list.head;
				list.head = picker;
				picker = prev.next;
				continue;
			}
			prev = picker;
			picker = picker.next;
		}
	}

	public static void main(String[] args) throws IOException {
		SinglyLinkedList list = new SinglyLinkedList();
		for (int i = 0; i < args.length; i++) {
			Node node = new Node(Integer.parseInt(args[i]));
			list.enlist(node);
		}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter x: ");
		int x = Integer.parseInt(in.readLine());
		partitionOnValue(x, list);
		list.print();
	}
}
