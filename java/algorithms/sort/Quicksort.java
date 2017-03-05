package algorithms.sort;

/**
 * Quicksort
 *
 * @author Ajinkya Patil
 */
public class Quicksort {
  public static void sort(int[] a) {
    sort(a, 0, a.length - 1);
  }

  private static void sort(int[] a, int lo, int hi) {
    if (lo >= hi) {
      return;
    }
    if (lo == hi - 1 && a[lo] > a[hi]) {
      swap(a, lo, hi);
      return;
    }
    int pvi = hi;
    int i = lo;
    int j = hi - 1;
    while (i <= j) {
      while (i <= j && a[i] <= a[pvi]) {
        i++;
      }
      while (i <= j && a[j] > a[pvi]) {
        j--;
      }
      if (i < j) {
        swap(a, i, j);
      }
    }
    swap(a, i, pvi);
    sort(a, lo, i - 1);
    sort(a, i + 1, hi);
  }

  private static void swap(int[] a, int x, int y) {
    int temp = a[x];
    a[x] = a[y];
    a[y] = temp;
  }
}
