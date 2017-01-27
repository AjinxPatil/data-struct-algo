package problems;

import datastructures.SinglyLinkedList;
import datastructures.SinglyLinkedList.Node;

/**
 * Cracking the Coding Interview - Data Structures 2 Linked Lists 2.7 Implement
 * a function to check if a linked list is a palindrome.
 * 
 * @author Ajinkya Patil
 */
public class LlPalindrome {
	public static class PalindromeResult {
		Node tail;
		boolean isPalindrome;

		PalindromeResult(Node node, boolean status) {
			tail = node;
			isPalindrome = status;
		}
	}

	public static PalindromeResult isPalindrome(Node head, int length) {
		if (length == 2) {
			if (head.data == head.next.data) {
				return new PalindromeResult(head.next.next, true);
			} else {
				return new PalindromeResult(head, false);
			}
		} else if (length == 1) {
			return new PalindromeResult(head.next, true);
		}

		PalindromeResult result = isPalindrome(head.next, length - 2);

		Node node = null;
		node = result != null ? result.tail : null;
		if (!result.isPalindrome) {
			return new PalindromeResult(head, false);
		}
		if (head.data == node.data) {
			if (node.next != null) {
				return new PalindromeResult(node.next, true);
			}
		} else {
			return new PalindromeResult(head, false);
		}
		return new PalindromeResult(head, true);
	}

	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		for (int i = 0; i < args.length; i++) {
			Node node = new Node(Integer.parseInt(args[i]));
			list.enlist(node);
		}
		PalindromeResult result = isPalindrome(list.head, args.length);
		if (result.isPalindrome) {
			System.out.println("Palindrome");
		} else {
			System.out.println("Not a Palindrome");
		}
	}
}
