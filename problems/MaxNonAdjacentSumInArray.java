package problems;
public class MaxNonAdjacentSumInArray {
  public static int maxByRec(int[] arr, int start) {
    int end = arr.length - 1;
    if (start > end) {
      return 0;
    }
    if (start == end) {
      return arr[start];
    }
    if (start + 1 == end) {
      return arr[start] > arr[end] ? arr[start] : arr[end];
    }
    int sub1 = arr[start] + maxByRec(arr, start + 2);
    int sub2 = arr[start + 1] + maxByRec(arr, start + 3);
    return sub1 > sub2 ? sub1 : sub2;
  }

  public static int max(int[] arr) {
    int sum = arr[0];
    int sumPrev = 0;
    for (int i = 1; i < arr.length; i++) {
      int temp = sum;
      sum = arr[i] + sumPrev;
      sumPrev = temp > sumPrev ? temp : sumPrev;
    }
    return sum > sumPrev ? sum : sumPrev;
  }

  public static void main(String[] args) {
    int[] arr = new int[args.length];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = Integer.parseInt(args[i]);
    }
    int result1 = MaxNonAdjacentSumInArray.maxByRec(arr, 0);
    int result2 = MaxNonAdjacentSumInArray.max(arr);
    System.out.println("Recursive: "  + result1 + "  Best O(n): " + result2);
  }
}
