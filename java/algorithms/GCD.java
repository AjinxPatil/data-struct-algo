package algorithms;

/**
 * Euclidean algorithm
 */
public class GCD {
  public static int calculate(int a, int b) {
    if (a == 0) {
      return b;
    }
    if (b == 0) {
      return a;
    }
    int min = a;
    int max = b;
    if (a > b) {
      min = b;
      max = a;
    }
    return calculate(min, max % min);
  }

  public static void main(String[] args) {
    System.out.println(calculate(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
  }
}
