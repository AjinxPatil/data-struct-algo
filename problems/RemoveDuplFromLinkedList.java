package problems;

import java.util.HashSet;
import java.util.Set;

import datastructures.SinglyLinkedList;
import datastructures.SinglyLinkedList.Node;

/**
 * Cracking the Coding Interview - Data Structures 2 Linked Lists 2.1 Write code
 * to remove duplicates from an unsorted linked list.
 * 
 * @author Ajinkya Patil
 */
public class RemoveDuplFromLinkedList {
	public static void removeDuplicates(SinglyLinkedList list) {
		Node current = list.head;
		Node prev = list.head;
		Set<Integer> box = new HashSet<Integer>();
		while (current != null) {
			if (box.contains(current.data)) {
				prev.next = current.next;
				current = current.next;
			} else {
				box.add(current.data);
				prev = current;
				current = current.next;
			}
		}
	}

	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		Node prev = null;
		for (int i = 0; i < args.length; i++) {
			Node node = new Node(Integer.parseInt(args[i]));
			if (i == 0) {
				list.head = node;
				prev = list.head;
				continue;
			}
			prev.next = node;
			prev = node;
		}
		removeDuplicates(list);
		Node current = list.head;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
	}
}
