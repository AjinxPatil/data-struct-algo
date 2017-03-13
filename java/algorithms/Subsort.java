package algorithms;

/**
 * Given an array of integers, write a method to find indices m and n such that if you sorted
 * elements m through n, the entire array would be sorted. Minimize n - m (that is, find the
 * smallest such sequence).
 */
public class Subsort {
  private static class Solution {
    int m;
    int n;

    private Solution() {
    }

    public Solution(int m, int n) {
      this.m = m;
      this.n = n;
    }
  }

  public static Solution sort(int[] a) {
    if (a.length < 2) {
      return new Solution(0, 0);
    }

    // finding the first element from left which is out of order
    int midLo = 0;
    while (midLo < a.length - 1 && a[midLo + 1] >= a[midLo]) {
      midLo++;
    }
    if (midLo == a.length - 1) {
      return new Solution(0, 0);
    }

    // finding the first element from right which is out of order
    int midHi = a.length - 1;
    while (midHi > 0 && a[midHi] > a[midHi - 1]) {
      midHi--;
    }

    int max = 0;
    for (int i = 1; i <= midHi; i++) {
      if (a[i] > a[max]) {
        max = i;
      }
    }

    int min = a.length - 1;
    for (int i = a.length - 2; i >= midLo; i--) {
      if (a[i] < a[min]) {
        min = i;
      }
    }

    int m = 0;
    int n = a.length - 1;
    while (a[m] <= a[min]) {
      m++;
    }
    while (a[n] >= a[max]) {
      n--;
    }
    return new Solution(m, n);
  }

  public static void main(String[] args) {
    Solution s = sort(new int[]{1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19});
    System.out.println("m = " + s.m + ", n = " + s.n);
    s = sort(new int[]{1, 2, 4, 7, 10, 11, 7, 8, 9});
    System.out.println("m = " + s.m + ", n = " + s.n);
    s = sort(new int[]{9, 8, 7, 6, 5, 2, 1});
    System.out.println("m = " + s.m + ", n = " + s.n);
    s = sort(new int[]{1, 2, 3, 4, 5});
    System.out.println("m = " + s.m + ", n = " + s.n);
  }
}
