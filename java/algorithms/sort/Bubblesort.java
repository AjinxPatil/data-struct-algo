package algorithms.sort;

public class Bubblesort {
  private int length;
  private int[] theArray;

  Bubblesort(int length) {
    this.length = length;
    theArray = new int[length];
  }

  public int[] fill(String[] values) {
    for (int i = 0; i < values.length; i++) {
      theArray[i] = Integer.parseInt(values[i]);
    }
    return theArray;
  }

  public static void sort(int[] arr) {
    boolean swapped = true;
    if (arr.length > 1) {
      while (swapped) {
        swapped = false;
        for (int i = 0; i < arr.length - 1; i++) {
          if (arr[i] > arr[i + 1]) {
            int temp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = temp;
            swapped = true;
          }
        }
      }
    }
  }

  public void print() {
    if (theArray.length > 0) {
      System.out.print("Sorted Array: ");
      for (int i = 0; i < length; i++) {
        System.out.print(theArray[i] + " ");
      }
      System.out.println("\nInput size: " + length);
    } else {
      System.out.println("Array is empty!");
    }
  }

  public static void main(String[] args) {
    Bubblesort sort = new Bubblesort(args.length);
    int[] arr = sort.fill(args);
    Bubblesort.sort(arr);
    sort.print();
  }
}
