public class BinaryTree {
  public static class Node {
    int data;
    Node left;
    Node right;
    public Node(int value) {
      this.data = value;
    }
  }
  Node root;

  public boolean bfSearch(Node root, int data, int level) {
    if (root == null) {
      return false;
    }
    if (level == 1) {
      if (root.data == data) {
        return true;
      }
    } else if (level > 1) {
      System.out.println(level);
      return bfSearch(root.left, data, level - 1);
      return bfSearch(root.right, data, level - 1);
    }
    return false;
  }

  public int maxDepth(Node root) {
    if (root == null) {
      return 0;
    }
    int left = maxDepth(root.left);
    int right = maxDepth(root.right);
    if (left < right) {
      return right + 1;
    }
    return left + 1;
  }

  public static void main(String[] args) {
       BinaryTree tree = new BinaryTree();
       tree.root= new Node(1);
       tree.root.left= new Node(2);
       tree.root.right= new Node(3);
       tree.root.left.left= new Node(4);
       tree.root.left.right= new Node(5);

       System.out.println((tree.root, 6, 3));
    }
}
