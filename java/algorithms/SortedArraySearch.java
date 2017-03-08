package algorithms;

/**
 * Cracking the Coding Interview: Given an M x N matrix in which each row and each column is sorted
 * in ascending order, write a method to find an element.
 *
 * @author Ajinkya Patil
 */
public class SortedArraySearch {
  public static int[] find(int[][] data, int value) {
    // data[] is assumed to be sorted row-wise and column-wise
    int m = data.length;
    int n = data[0].length;
    return find(data, 0, 0, m - 1, n - 1, value);
  }

  private static int[] find(int[][] data, int tlr, int tlc, int brr, int brc, int value) {
    if (data[tlr][tlc] > value || data[brr][brc] < value) {
      return null;
    }
    int dr = tlr;
    int dc = tlc;
    while (dr <= brr && dc <= brc && data[dr][dc] <= value) {
      if (data[dr][dc] == value) {
        return new int[]{dr, dc};
      }
      dr++;
      dc++;
    }
    if (dr > brr) {
      return find(data, tlr, dc, brr, brc, value);
    }
    if (dc > brc) {
      return find(data, dr, tlc, brr, brc, value);
    }
    int[] result = find(data, tlr, dc - 1, dr - 1, brc, value);
    if (result == null) {
      result = find(data, dr - 1, tlc, brr, dc - 1, value);
    }
    return result;
  }

  public static void main(String[] args) {
    int[][] data = {{15, 20, 40, 85}, {20, 35, 80, 95}, {30, 55, 95, 105}};
    int[] result = find(data, 10);
    if (result == null) {
      System.out.println("Not found!");
      return;
    }
    System.out.print("Found at: ");
    for (int i = 0; i < 2; i++) {
      System.out.print(result[i] + " ");
    }
  }
}
