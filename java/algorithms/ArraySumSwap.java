package algorithms;

import java.util.HashSet;
import java.util.Set;

/**
 * Given two arrays of integers, <code>ArraySumSwap</code> finds a pair of values (one value from
 * each array) that you can swap to give the two arrays the same sum.
 *
 * @author Ajinkya Patil
 */
public class ArraySumSwap {
  public static int[] getValues(int[] a, int[] b) {
    int sumA = getArraySum(a);
    int sumB = getArraySum(b);
    if (sumA == sumB) {
      return new int[]{0, 0};
    }
    if (sumA > sumB) {
      return _getValues(b, a, sumB, sumA);
    }
    return _getValues(a, b, sumA, sumB);
  }

  private static int[] _getValues(int[] a, int[] b, int sumA, int sumB) {
    Set<Integer> bSet = createSet(b);
    for (int i = 0; i < a.length; i++) {
      int diff = sumB - sumA + 2 * a[i];
      if (diff % 2 == 0 && bSet.contains(diff / 2)) {
        return new int[]{diff / 2, a[i]};
      }
    }
    return new int[]{0, 0};
  }

  private static int getArraySum(int[] a) {
    int sum = 0;
    for (int i = 0; i < a.length; i++) {
      sum += a[i];
    }
    return sum;
  }

  private static Set<Integer> createSet(int[] a) {
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < a.length; i++) {
      set.add(a[i]);
    }
    return set;
  }

  public static void main(String[] args) {
    int[] solution = getValues(new int[]{2, 1, 2, 1, 1, 4}, new int[]{3, 6, 3, 3});
    for (int i = 0; i < 2; i++) {
      System.out.print(solution[i] + " ");
    }
  }
}
