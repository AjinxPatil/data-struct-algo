package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import datastructures.SinglyLinkedList;
import datastructures.SinglyLinkedList.Node;

/**
 * Cracking the Coding Interview - Data Structures 2 Linked Lists 2.5 You have
 * two numbers represented by a linked list, where each node contains a single
 * digit. The digits are stored in forward order, such that the Ts digit is at
 * the head of the list. Write a function that adds the two numbers and returns
 * the sum as a linked list. EXAMPLE Input: (6 -> 1 -> 7) + (2 -> 9 -> 5).That
 * is, 617 + 295. Output: 9 -> 1 -> 2.That is, 912. NOTE: Different solution
 * from the book!
 * 
 * @author Ajinkya Patil
 */
public class LlNumAddition2 {
	public static class LlNumAddWrapper {
		Node node;
		int carry;

		public LlNumAddWrapper(Node n, int c) {
			node = n;
			carry = c;
		}
	}

	public static LlNumAddWrapper add(Node node1, Node node2) {
		if (node1 == null && node2 == null) {
			return null;
		}
		LlNumAddWrapper next = add(node1 != null ? node1.next : null,
				node2 != null ? node2.next : null);
		int sum = next != null ? next.carry : 0;
		sum += node1 != null ? node1.data : 0;
		sum += node2 != null ? node2.data : 0;
		Node result = new Node(sum % 10);
		result.next = next != null ? next.node : null;
		return new LlNumAddWrapper(result, sum >= 10 ? 1 : 0);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		SinglyLinkedList num1 = new SinglyLinkedList();
		System.out.print("Num 1: ");
		String num1str = in.readLine();
		String[] num1nodes = num1str.split(" ");
		for (int i = 0; i < num1nodes.length; i++) {
			Node node = new Node(Integer.parseInt(num1nodes[i]));
			num1.enlist(node);
		}
		SinglyLinkedList num2 = new SinglyLinkedList();
		System.out.print("Num 2: ");
		String num2str = in.readLine();
		String[] num2nodes = num2str.split(" ");
		for (int i = 0; i < num2nodes.length; i++) {
			Node node = new Node(Integer.parseInt(num2nodes[i]));
			num2.enlist(node);
		}
		SinglyLinkedList result = new SinglyLinkedList();
		LlNumAddWrapper wrapper = add(num1.head, num2.head);
		if (wrapper.carry == 1) {
			Node start = new Node(1);
			start.next = wrapper.node;
			wrapper.node = start;
		}
		result.head = wrapper.node;
		System.out.print("Result: ");
		result.print();
	}
}
