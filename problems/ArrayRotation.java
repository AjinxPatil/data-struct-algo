package problems;
import java.io.*;

public class ArrayRotation {
  public static void rotateArray(int[] arr, int k) {
    for (int i = k; i < arr.length; i++) {
      for (int j = i; j > i - k; j--) {
        int temp = arr[j];
        arr[j] = arr[j - 1];
        arr[j - 1] = temp;
      }
    }
  }

  public static void main(String[] args) throws IOException {
    int[] arr = new int[args.length];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = Integer.parseInt(args[i]);
    }
    System.out.print("How many elements to push back? ");
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    int x = Integer.parseInt(in.readLine());
    ArrayRotation.rotateArray(arr, x);
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
  }
}
