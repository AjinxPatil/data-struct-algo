package algorithms;

/**
 * Kadane's algorithm
 */
public class MaxSubArray {
  public static int find(int[] array) {
    int sum = array[0];
    int max = sum;
    for (int i = 1; i < array.length; i++) {
      if (sum < 0) {
        sum = array[i];
      } else {
        sum += array[i];
      }
      if (max < sum) {
        max = sum;
      }
    }
    return max;
  }

  public static void main(String[] args) {
    int[] array = new int[args.length];
    for (int i = 0; i < args.length; i++) {
      array[i] = Integer.parseInt(args[i]);
    }
    System.out.println(find(array));
  }
}
