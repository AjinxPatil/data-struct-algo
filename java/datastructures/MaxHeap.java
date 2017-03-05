package datastructures;

/**
 * MaxHeap
 *
 * @author Ajinkya Patil
 */
public interface MaxHeap {
  boolean add(int value);

  int removeMax();

  int peek();
}
