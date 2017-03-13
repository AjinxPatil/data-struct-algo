package algorithms;

/**
 * Rank from Stream: Imagine you are reading in a stream of integers. Periodically, you wish
 * to be able to look up the rank of a number x (the number of values less than or equal to x).
 * Implement the data structures and algorithms to support these operations. That is, implement
 * the method track(int x), which is called when each number is generated, and the method
 * getRankOfNumber(int x), which returns the number of values less than or equal to x (not
 * including x itself).
 * EXAMPLE
 * Stream(in order of appearance):5, 1, 4, 4, 5, 9, 7, 13, 3
 * getRankOfNumber(l) 0
 * getRankOfNumber(3) 1
 * getRankOfNumber(4) 3
 *
 * @author Ajinkya Patil
 */
public class StreamRanker {
  public static class RankedNode {
    public int data;
    public int rankAsRoot;
    public RankedNode left;
    public RankedNode right;

    private RankedNode() {
    }

    public RankedNode(int value) {
      data = value;
      rankAsRoot = 0;
    }
  }

  private RankedNode root;

  public void track(int x) {
    if (root == null) {
      root = new RankedNode(x);
      return;
    }
    track(root, x);
  }

  private static void track(RankedNode root, int x) {
    if (root.data >= x) {
      root.rankAsRoot++;
      if (root.left == null) {
        root.left = new RankedNode(x);
      } else {
        track(root.left, x);
      }
    } else {
      if (root.right == null) {
        root.right = new RankedNode(x);
      } else {
        track(root.right, x);
      }
    }
  }

  public int getRankOfNumber(int x) {
    return getRankOfNumber(root, x, 0);
  }

  private static int getRankOfNumber(RankedNode root, int num, int rank) {
    if (root == null) {
      return 0;
    }
    if (root.data == num) {
      return rank + root.rankAsRoot;
    }
    if (root.data < num) {
      rank += root.rankAsRoot + 1;
      return getRankOfNumber(root.right, num, rank);
    }
    return getRankOfNumber(root.left, num, rank);
  }

  public static void main(String[] args) {
    StreamRanker sr = new StreamRanker();
    sr.track(5);
    System.out.println(5 + " " + sr.getRankOfNumber(5));
    sr.track(1);
    sr.track(4);
    System.out.println(4 + " " + sr.getRankOfNumber(4));
    sr.track(4);
    System.out.println(4 + " " + sr.getRankOfNumber(4));
    sr.track(5);
    sr.track(9);
    sr.track(7);
    System.out.println(5 + " " + sr.getRankOfNumber(5));
    sr.track(13);
    System.out.println(13 + " " + sr.getRankOfNumber(13));
    sr.track(3);
    System.out.println(3 + " " + sr.getRankOfNumber(3));
  }
}
