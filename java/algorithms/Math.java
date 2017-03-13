package algorithms;

/**
 * <code>max</code> finds max of two numbers without using comparison operators or if-else
 * constructs.
 *
 * @author Ajinkya Patil
 */
public class Math {
  public static int max(int a, int b) {
    // MSBs of a and b
    int a1 = a >>> 31;
    int b1 = b >>> 31;

    // c is 1 if a and b have opposite signs otherwise 0
    int c = a1 ^ b1;
    c = flipBit(c);
    return Math._max(Math._max(a, c * b), Math._max(a * c, b));
  }

  private static int _max(int a, int b) {
    int p = (a - b) >>> 31;
    int q = flipBit(p);
    return a * q + b * p;
  }

  private static int flipBit(int x) {
    return x ^ 1;
  }

  public static void main(String[] args) {
    System.out.println(Math.max(4, 9));
    System.out.println(Math.max(-4, 9));
    System.out.println(Math.max(4, -9));
    System.out.println(Math.max(0, 0));
    System.out.println(Math.max(2147483647, -9));
    System.out.println(Math.max(-2147483648, 9));
  }
}
