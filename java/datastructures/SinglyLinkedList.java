package datastructures;

/**
 * <code>SinglyLinkedList</code> is a linear data structure of data elements
 * called <code>Node</code> objects that point to next node by means of a
 * pointer.
 * 
 * @author Ajinkya Patil
 * @see java.util.LinkedList
 */
public class SinglyLinkedList {
	public static class Node {
		public int data;
		public Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public Node head;

	public void add(Node x) {
		Node newNode = new Node(x.data);
		if (head == null) {
			head = newNode;
			return;
		}
		Node pass = head;
		while (pass.next != null) {
			pass = pass.next;
		}
		pass.next = newNode;
	}

	public void remove(Node x) {
		if (head.data == x.data) {
			head = head.next;
			return;
		}
		Node prev = head;
		Node pass = head.next;
		while (pass != null && pass.data != x.data) {
			prev = pass;
			pass = pass.next;
		}
		if (pass != null) {
			prev.next = pass.next;
			pass = null;
		}
	}

	public void removeAll(Node x) {
		while (head != null && head.data == x.data) {
			head = head.next;
		}
		if (head == null) {
			return;
		}
		Node prev = head;
		Node pass = head.next;
		while (pass != null) {
			if (pass.data == x.data) {
				prev.next = pass.next;
				pass = pass.next;
			} else {
				prev = pass;
				pass = pass.next;
			}
		}
	}

	public void print() {
		if (head == null) {
			System.out.print("EMPTY");
			return;
		}
		Node pass = head;
		while (pass != null) {
			System.out.print(pass.data + " ");
			pass = pass.next;
		}
	}

	public void reverse() {
		Node prev = null;
		Node ahead = null;
		while (head != null) {
			ahead = head.next;
			head.next = prev;
			prev = head;
			head = ahead;
		}
		head = prev;
	}

	public void reverseByRecursion(Node pass) {
		if (pass == null) {
			return;
		}
		reverseByRecursion(pass.next);
		if (pass.next != null) {
			pass.next.next = pass;
			pass.next = null;
		} else {
			head = pass;
		}
	}

  public void reverseBetween(int m, int n) {
    if (n == m || head == null || head.next == null) {
      return;
    }
    Node pre = null;
    Node mNode = null;
    if (m == 1) {
      mNode = head;
    } else {
      pre = head;
      for (int i = 1; i < m - 1; i++) {
        pre = pre.next;
      }
      mNode = pre.next;
    }
    Node nNode = mNode;
    for (int i = m; i < n; i++) {
      nNode = nNode.next;
    }
    Node post = nNode.next;
    Node curr = mNode.next;
    Node prev = mNode;
    for (int i = m + 1; i <= n; i++) {
      Node temp = curr.next;
      curr.next = prev;
      prev = curr;
      curr = temp;
    }
    if (pre == null) {
      head = nNode;
    } else {
      pre.next = nNode;
    }
    mNode.next = post;
  }

	public int length() {
		int length = 0;
		Node pass = head;
		while (pass != null) {
			pass = pass.next;
			length++;
		}
		return length;
	}

	public int lengthByRecursion(Node head) {
		if (head == null) {
			return 0;
		}
		int count = lengthByRecursion(head.next);
		return ++count;
	}

	public void swap(Node x, Node y) {
		Node pass1 = head;
		Node pass2 = head;
		Node prev1 = null;
		Node prev2 = null;
		while (pass1 != null && pass1.data != x.data) {
			prev1 = pass1;
			pass1 = pass1.next;
		}
		while (pass2 != null && pass2.data != y.data) {
			prev2 = pass2;
			pass2 = pass2.next;
		}
		if (pass1 == null || pass2 == null) {
			System.out.println("Node(s) not found!");
		}
		if (prev1 != null) {
			prev1.next = pass2;
			head = pass2;
		} else {
		}
		if (prev2 != null) {
			prev2.next = pass1;
		} else {
			head = pass1;
		}
		Node temp = pass1.next;
		pass1.next = pass2.next;
		pass2.next = temp;
		temp = null;
	}

	public Node merge(Node node1, Node node2) {
		Node node = null;
		if (node1 == null) {
			return node2;
		}
		if (node2 == null) {
			return node1;
		}
		if (node1.data > node2.data) {
			node = merge(node1, node2.next);
			node2.next = node;
			head = node2;
			return node2;
		}
		node = merge(node1.next, node2);
		node1.next = node;
		head = node1;
		return node1;
	}

	public void enlist(Node x) {
		if (x == null) {
			return;
		}
		if (head == null) {
			head = x;
			return;
		}
		Node pass = head;
		while (pass.next != null) {
			pass = pass.next;
		}
		pass.next = x;
	}
}
