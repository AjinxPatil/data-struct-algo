package problems;
import sort.BubbleSort;

public class MaxOccurrenceInArray {
  // O(nlogn)
  public static int findMaxOccurring1(int[] arr) {
    BubbleSort.sort(arr);
    int count = 0;
    int countCurrent = 1;
    int value = arr[0];
    int valueCurrent = arr[0];
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] == valueCurrent) {
        ++countCurrent;
      } else {
        if (count < countCurrent) {
          count = countCurrent;
          value = arr[i - 1];
        }
        countCurrent = 1;
        valueCurrent = arr[i];
      }
    }
    if (countCurrent > count) {
      value = arr[arr.length - 1];
    }
    return value;
  }

  // O(n) time and O(1) space
  // arr.length = n and contains elements from range [0...k-1] where k <= n
  public static int findMaxOccurring2(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n; i++) {
      arr[arr[i] % n] += n;
    }
    int maxIndex = 0;
    for (int i = 1; i < n; i++) {
      if (arr[i] > arr[maxIndex]) {
        maxIndex = i;
      }
    }
    for (int i = 0; i < n; i++) {
      arr[i] = arr[i] % n;
    }
    return arr[maxIndex];
  }

  public static void main(String[] args) {
    int[] arr = new int[args.length];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = Integer.parseInt(args[i])  ;
    }
    int value = MaxOccurrenceInArray.findMaxOccurring2(arr);
    System.out.println(value);
  }
}
