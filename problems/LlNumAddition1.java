package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import datastructures.SinglyLinkedList;
import datastructures.SinglyLinkedList.Node;

/**
 * Cracking the Coding Interview - Data Structures 2 Linked Lists 2.5 You have
 * two numbers represented by a linked list, where each node contains a single
 * digit. The digits are stored in reverse order, such that the unit digit is at
 * the head of the list. Write a function that adds the two numbers and returns
 * the sum as a linked list. EXAMPLE Input: (7 -> 1 -> 6) + (5 -> 9 -> 2).That
 * is, 617 + 295. Output: 2 -> 1 -> 9.That is, 912.
 * 
 * @author Ajinkya Patil
 *
 */
public class LlNumAddition1 {
	public static Node add(Node node1, Node node2, int carry) {
		// Reached end of both the lists with carry 0
		if (node1 == null && node2 == null && carry == 0) {
			return null;
		}

		int sum = carry;
		if (node1 != null) {
			sum += node1.data;
		}
		if (node2 != null) {
			sum += node2.data;
		}

		Node result = new Node(sum % 10);
		Node next = add(node1 != null ? node1.next : null,
				node2 != null ? node2.next : null, sum >= 10 ? 1 : 0);
		result.next = next;
		return result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		SinglyLinkedList num1 = new SinglyLinkedList();
		System.out.print("Number 1: ");
		String num1str = in.readLine();
		String[] num1nodes = num1str.split(" ");
		for (int i = 0; i < num1nodes.length; i++) {
			Node node = new Node(Integer.parseInt(num1nodes[i]));
			num1.enlist(node);
		}

		SinglyLinkedList num2 = new SinglyLinkedList();
		System.out.print("List 2: ");
		String num2s = in.readLine();
		String[] num2snods = num2s.split(" ");
		for (int i = 0; i < num2snods.length; i++) {
			Node node = new Node(Integer.parseInt(num2snods[i]));
			num2.enlist(node);
		}

		SinglyLinkedList result = new SinglyLinkedList();
		result.head = add(num1.head, num2.head, 0);
		System.out.print("Result: ");
		result.print();
	}
}
