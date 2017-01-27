package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import datastructures.SinglyLinkedList;
import datastructures.SinglyLinkedList.Node;

/**
 * Cracking the Coding Interview - Data Structures 2 Linked Lists 2.6 Given a
 * circular linked list, implement an algorithm which returns the node at the
 * beginning of the loop.
 * 
 * @author Ajinkya Patil
 */
public class LlLoopFinder {
	public static Node findLoopHead(SinglyLinkedList list) {
		Node tort = list.head.next;
		Node hare = list.head.next.next;
		while (tort.data != hare.data) {
			tort = tort.next;
			hare = hare.next.next;
		}
		hare = list.head;
		while (hare.data != tort.data) {
			hare = hare.next;
			tort = tort.next;
		}
		return tort;
	}

	public static void main(String[] args) throws IOException {
		SinglyLinkedList list = new SinglyLinkedList();
		for (int i = 0; i < args.length; i++) {
			Node node = new Node(Integer.parseInt(args[i]));
			list.enlist(node);
		}

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Insert loop at position: ");
		int loopHead = Integer.parseInt(in.readLine());
		int count = 0;
		Node marked = null;
		Node pass = list.head;
		while (pass.next != null) {
			count++;
			if (loopHead == count) {
				marked = pass;
			}
			pass = pass.next;
		}
		pass.next = marked;

		marked = findLoopHead(list);
		System.out.print("Loop head: " + marked.data);
	}
}
