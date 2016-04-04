package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import datastructures.SinglyLinkedList;
import datastructures.SinglyLinkedList.Node;

/**
 * Cracking the Coding Interview - Data Structures 2 Linked Lists 2.2 Implement
 * an algorithm to find the kth to last element of a singly linked list.
 * 
 * @author Ajinkya Patil
 */
public class LlNodeFinder {
	public static int findNodeFromLast(int k, SinglyLinkedList list) {
		Node kNode = list.head;
		Node counter = list.head;
		int length = 0;
		while (counter != null) {
			length++;
			counter = counter.next;
			if (length - k > 0) {
				kNode = kNode.next;
			}
		}
		return kNode.data;
	}

	public static void main(String[] args) throws IOException {
		SinglyLinkedList list = new SinglyLinkedList();
		for (int i = 0; i < args.length; i++) {
			Node node = new Node(Integer.parseInt(args[i]));
			list.enlist(node);
		}

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter k: ");
		int k = Integer.parseInt(in.readLine());
		System.out.println(findNodeFromLast(k, list));
	}
}
