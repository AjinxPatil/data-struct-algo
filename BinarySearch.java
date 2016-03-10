import java.io.*;

public class BinarySearch {
  public static int search(int[] arr, int start, int end, int x) {
      int mid = (start + end) / 2;
      int pos = -1;
      if (x == arr[mid]) {
        return mid;
      }
      if (start == end) {
        return pos;
      }
      if (x < arr[mid]) {
        pos = search(arr, start, mid - 1, x);
      } else {
        pos = search(arr, mid + 1, end, x);
      }
      return pos;
  }

  public static void main(String[] args) throws IOException {
    int[] arr = new int[args.length];
    for (int i = 0; i < args.length; i++) {
      arr[i] = Integer.parseInt(args[i]);
    }
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    System.out.print("Search: ");
    int x = Integer.parseInt(in.readLine());
    int pos = BinarySearch.search(arr, 0, arr.length - 1, x);
    if (pos < 0) {
      System.out.println(x + " not found!");
    } else {
      System.out.println(x + " found at " + pos);
    }
  }
}
