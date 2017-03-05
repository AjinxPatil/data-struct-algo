package algorithms;

import datastructures.BinaryTree.Node;

public class SubtreeChecker {
  public static boolean isSubtree(Node tree1, Node tree2) {
    if (tree1 == null) {
      return false;
    }
    if (tree2 == null) {
      return true;
    }
    return isSameTree(tree1, tree2) || isSubtree(tree1.left, tree2) || isSubtree(tree1.right, tree2);
  }

  private static boolean isSameTree(Node tree1, Node tree2) {
    if (tree1 == null && tree2 == null) {
      return true;
    }
    if (tree1 == null || tree2 == null) {
      return false;
    }
    if (tree1.data != tree2.data) {
      return false;
    }
    return isSameTree(tree1.left, tree2.left) && isSameTree(tree1.right, tree2.right);
  }
}
