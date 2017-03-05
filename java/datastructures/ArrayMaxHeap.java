package datastructures;

/**
 * ArrayMaxHeap
 *
 * @author Ajinkya Patil
 */
public class ArrayMaxHeap implements MaxHeap {
  private int[] heap;
  private int size;

  public ArrayMaxHeap() {
    heap = new int[10];
  }

  public ArrayMaxHeap(int value) {
    heap = new int[value];
  }

  private int left(int i) {
    return (2 * i + 1 < size) ? 2 * i + 1 : -1;
  }

  private int right(int i) {
    return (2 * i + 2 < size) ? 2 * i + 2 : -1;
  }

  private int parent(int i) {
    return ((i - 1) / 2 >= 0) ? (i - 1) / 2 : -1;
  }

  private void heapDown(int i) {
    if (i >= size) {
      return;
    }
    int imax = left(i);
    if (left(i) == -1) {
      imax = i;
    } else if (right(i) != -1 && heap[left(i)] < heap[right(i)]) {
      imax = right(i);
    }
    if (heap[i] < heap[imax]) {
      int temp = heap[i];
      heap[i] = heap[imax];
      heap[imax] = temp;
      heapDown(imax);
    }
  }

  private void heapUp(int i) {
    if (i == 0) {
      return;
    }
    int p = parent(i);
    if (heap[i] > heap[p]) {
      int temp = heap[i];
      heap[i] = heap[p];
      heap[p] = temp;
      heapUp(p);
    }
  }

  @Override
  public boolean add(int value) {
    if (size == heap.length) {
      return false;
    }
    heap[size++] = value;
    heapUp(size - 1);
    return true;
  }

  @Override
  public int removeMax() {
    if (size == 0) {
      throw new IllegalStateException("ERROR @ ArrayMaxHeap.removeMax(): Heap is empty!");
    }
    int x = heap[0];
    heap[0] = heap[size - 1];
    size--;
    heapDown(0);
    return x;
  }

  @Override
  public int peek() {
    if (size == 0) {
      throw new IllegalStateException("ERROR @ ArrayMaxHeap.peek(): Heap is empty!");
    }
    return heap[0];
  }
}
