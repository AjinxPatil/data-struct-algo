package algorithms.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Heapsort {

  private static int lft(int i) {
    return 2 * i + 1;
  }

  private static int rgt(int i) {
    return 2 * i + 2;
  }

  // creates a max heap  
  private static void heapify(List<Integer> list) {
    int len = list.size();
    for (int i = len / 2 - 1; i >= 0; i--) {
      maxHeap(list, i, len - 1);
    }
  }

  /* creates a maxheap for a subtree at index ti with the assumption that the child subtrees 
   * are already heapified
   */
  private static void maxHeap(List<Integer> list, int ti, int last) {
    int max = ti;
    int left = lft(ti);
    int right = rgt(ti);
    // left <= last condition is to handle one-node tree (root only)
    if (left <= last && list.get(ti) < list.get(left)) {
      max = left;
    }
    // right <= last checks whether right child exists
    if (right <= last && list.get(max) < list.get(right)) {
      max = right;
    }
    // swap only when needed
    if (max != ti) {
      swap(list, max, ti);
      // recurse only for internal nodes
      if (lft(max) <= last) {
        maxHeap(list, max, last);
      }
    }
  }

  public static void sort(List<Integer> list) {
    heapify(list);
    int hi = list.size() - 1;
    while (hi > 0) {
      swap(list, 0, hi);
      hi--;
      maxHeap(list, 0, hi);
    }
  }

  private static void swap(List<Integer> list, int x, int y) {
    int temp = list.get(x);
    list.set(x, list.get(y));
    list.set(y, temp);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String input = in.readLine();
    Scanner sc = new Scanner(input);
    List<Integer> list = new ArrayList<Integer>();
    while (sc.hasNext()) {
      list.add(sc.nextInt());
    }
    sort(list);
    System.out.print("OUTPUT: ");
    for (Integer i : list) {
      System.out.print(i + " ");
    }
    System.out.println();
  }
}
