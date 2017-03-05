package algorithms.sort;

/**
 * Mergesort
 *
 * @author Ajinkya Patil
 */
public class Mergesort {
  public static void sort(int[] input) {
    int[] aux = new int[input.length];
    sort(input, aux, 0, input.length - 1);
  }

  private static void sort(int[] a, int[] aux, int lo, int hi) {
    if (lo >= hi) {
      return;
    }
    int mid = (lo + hi) / 2;
    sort(a, aux, lo, mid);
    sort(a, aux, mid + 1, hi);
    merge(a, aux, lo, mid, hi);
  }

  private static void merge(int[] a, int[] aux, int lo, int mid, int hi) {
    for (int i = lo; i <= hi; i++) {
      aux[i] = a[i];
    }
    int left = lo;
    int right = mid + 1;
    while (left <= mid && right <= hi) {
      if (aux[left] < aux[right]) {
        a[lo] = aux[left];
        left++;
      } else {
        a[lo] = aux[right];
        right++;
      }
      lo++;
    }
    while (left <= mid) {
      a[lo] = aux[left];
      left++;
      lo++;
    }
  }
}
