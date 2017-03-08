package algorithms;

/**
 * Triple Step: A child is running up towerA staircase with n steps and can hop either 1 step, 2 steps,
 * or 3 steps at towerA time. <code>TripleStep</code> counts how many possible ways the child can run up
 * the stairs.
 *
 * @author Ajinkya Patil
 */
public class TripleStep {
  public static int findNumberOfWays(int n) {
    if (n == 0 || n == 1) {
      return 1;
    }
    if (n == 2) {
      return 2;
    }
    if (n == 3) {
      return 4;
    }
    int[] ways = new int[n + 1];
    ways[1] = 1;
    ways[2] = 2;
    ways[3] = 4;
    for (int i = 4; i <= n; i++) {
      ways[i] = ways[i - 1] + ways[i - 2] + ways[i - 3];
    }
    return ways[n];
  }

  public static void main(String[] args) {
    System.out.println(findNumberOfWays(0));
    System.out.println(findNumberOfWays(3));
    System.out.println(findNumberOfWays(10));
    System.out.println(findNumberOfWays(7));
  }
}
