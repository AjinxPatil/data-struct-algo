package datastructures;

import datastructures.BinaryTree.Node;

/**
 * <code>BinarySearchTree</code> is a binary tree data structure where all the
 * nodes in the left subtree of a node are smaller and all the nodes in the
 * right subtree are larger than the parent node.
 * 
 * @author Ajinkya Patil
 */
public class BinarySearchTree {
	public Node root;

	public void add(Node node) {
		if (node == null) {
			return;
		}
		add(node, root);
	}

	private static Node add(Node node, Node root) {
		if (root == null || root.data == node.data) {
			return node;
		}
		if (node.data < root.data) {
			root.left = add(node, root.left);
		} else {
			root.right = add(node, root.right);
		}
		return root;
	}

	public boolean isEmpty() {
		if (root == null) {
			return true;
		}
		return false;
	}

	public boolean search(Node node) {
		if (node == null) {
			return false;
		}
		return search(node, root);
	}

	private static boolean search(Node node, Node root) {
		if (root == null) {
			return false;
		}
		if (node.data == root.data) {
			return true;
		}
		if (node.data < root.data) {
			return search(node, root.left);
		}
		return search(node, root.right);
	}

	/**
	 * There are three possibilities for node deletion.
	 * <ol>
	 * <li>Node to be deleted is leaf</li>
	 * <li>Node to be deleted has one child</li>
	 * <li>Node to be deleted has two childs</li>
	 * </ol>
	 * 
	 * @param data
	 */
	public void remove(int data) {
		if (root == null) {
			return;
		}
		remove(data, root);
	}

	private static Node remove(int data, Node root) {
		if (data < root.data) {
			root.left = remove(data, root.left);
		} else if (data > root.data) {
			root.right = remove(data, root.right);
		} else {
			if (root.left == null && root.right == null) {
				return null;
			}
			if (root.left == null) {
				return root.right;
			}
			if (root.right == null) {
				return root.left;
			}
			root.data = findSuccessor(root.right);
			root.right = remove(root.data, root.right);
		}
		return root;
	}

	private static int findSuccessor(Node root) {
		int value = root.data;
		while (root.left != null) {
			value = root.left.data;
			root = root.left;
		}
		return value;

	}
}
