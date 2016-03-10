public class SortedMatrixSearch {
  public static String exists(int[][] a, int x) {
      int r = a.length;
      int c = a[0].length;
      int  i = 0;
      int j = c - 1;
      while (i < r && j >= 0) {
        if (a[i][j] == x) {
          return i + " " + j;
        }
        if (a[i][j] < x) {
          i++;
        } else {
          j--;
        }
      }
      return "null";
  }

  public static void main(String[] args) {
    int[][] a = {
      {1, 4, 5},
      {2, 4, 9},
      {10, 18, 21},
    };
    System.out.print(exists(a, 10));
  }
}
