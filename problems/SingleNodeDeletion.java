package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import datastructures.SinglyLinkedList;
import datastructures.SinglyLinkedList.Node;

/**
 * Cracking the Coding Interview - Data Structures 2 Linked Lists 2.3 Implement
 * an algorithm to delete a node in the middle of a singly linked list, given
 * only access to that node. EXAMPLE Input: the node c from the linked list
 * a->b->c->d->e Result: nothing is returned, but the new linked list looks like
 * a->b->d->e
 * 
 * @author Ajinkya Patil
 */
public class SingleNodeDeletion {
	public static void deleteSpecNode(Node node) {
		if (node == null) {
			return;
		}
		if (node.next == null) {
			node = null;
			return;
		}
		node.data = node.next.data;
		node.next = node.next.next;
	}

	public static void main(String[] args) throws IOException {
		SinglyLinkedList list = new SinglyLinkedList();
		for (int i = 0; i < args.length; i++) {
			Node node = new Node(Integer.parseInt(args[i]));
			list.enlist(node);
		}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Which node? ");
		int x = Integer.parseInt(in.readLine());
		Node rem = list.head;
		while (rem != null) {
			if (rem.data == x) {
				break;
			}
			rem = rem.next;
		}
		deleteSpecNode(rem);
		list.print();
	}
}
