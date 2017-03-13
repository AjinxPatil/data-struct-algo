package algorithms;

/**
 * In an array of integers, a "peak" is an element which is greater than or equal to the adjacent
 * integers and a "valley" is an element which is less than or equal to the adjacent integers. For
 * example, in the array {5, 8, 6, 2, 3, 4, 6}, {8, 6} are peaks and {5, 2} are valleys. Given an
 * array of integers, sort the array into an alternating sequence of peaks and valleys.
 * <p>
 * EXAMPLE
 * Input: {5, 3, 1, 2, 3}
 * Output: {5, 1, 3, 2, 3}
 *
 * @author Ajinkya Patil
 */
public class SineArray {
  public static void convert(int[] a) {
    if (a.length < 3) {
      return;
    }
    for (int i = 1; i < a.length - 1; i += 2) {
      if (a[i] > a[i - 1] && a[i] > a[i + 1]) {
        continue;
      }
      if (a[i - 1] > a[i + 1]) {
        swap(a, i - 1, i);
      }
      swap(a, i + 1, i);
    }
  }

  private static void swap(int[] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }

  public static void main(String[] args) {
    int[] a = new int[]{1, 2, 2, 2, 2, 3};
    SineArray.convert(a);
    for (int i = 0; i < a.length; i++) {
      System.out.print(a[i] + " ");
    }
  }
}
