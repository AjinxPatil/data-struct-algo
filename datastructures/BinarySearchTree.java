package datastructures;
public class BinarySearchTree {
  public static class Node {
    int data;
    Node left;
    Node right;
    Node(int value) {
      this.data = value;
    }
  }

  public Node root;

  public void insert(Node node) {
    insertBelowRoot(node, root);
  }

  private static Node insertInSubTree(Node node, Node root) {
    if (node == null) {
      return null;
    }
    if (root == null) {
      return node;
    }
    if (node.data <= root.data) {
      root.left = insertInSubTree(node, root.left);
    } else {
      root.right = insertInSubTree(node, root.right);
    }
    return root;
  }

  public boolean isEmpty() {
    if (root == null) {
      return true;
    }
    return false;
  }

  public Node search(Node node) {
    return searchSubTree(node, root);
  }

  private Node searchSubTree(Node node, Node root) {
    if (node == null || root == null) {
      return null;
    }
    if (node.data == root.data) {
      return root;
    }
    if (node.data < root.data) {
      return searchSubTree(node, root.left);
    }
      return searchSubTree(node, root.right);
  }

  public void delete(Node node) {
    if (isEmpty()) {
      return;
    }
    deleteFromSubTree(node, root);
  }

  private void deleteFromSubTree(Node node, Node root) {
    if (node == null) {
      return;
    }
    if (node.data < root.data) {
      root.left = deleteFromSubTree(node, root.left);
    } else if (node.data > root.data) {
      root.right = deleteFromSubTree(node, root.right);
    } else {
      if (node.left == null) {
        return root.right;
      }
      if (node.right == null) {
        return root.left;
      }
      Node successor = findRootSuccessor(root.right);
    }

    private Node findRootSuccessor(Node node) {
      if (node == null) {
        return null;
      }
      if (node.left != null) {
        node = findRootSuccessor(node.left);
      }
      return node;
    }
  }
}
