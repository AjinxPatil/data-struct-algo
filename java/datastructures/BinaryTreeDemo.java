package datastructures;

import datastructures.BinaryTree;

/**
 * @author Ajinkya Patil
 */
public class BinaryTreeDemo {
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.right = new Node(6);

		int data = 6;
		int levels = 1;
		System.out
				.println("Finding node " + data + " on top " + levels + " levels...");
		System.out.println("Found: " + tree.breadthFirstSearch(data, levels));
		System.out.println("Height: " + tree.height());
	}
}
