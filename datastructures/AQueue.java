public class AQueue {
  Integer[] contents;
  int front;
  int rear;
  int capacity;
  AQueue(int c) {
    capacity = c;
    contents = new Integer[capacity];
    rear = -1;
    front = -1;
  }

  public void enqueue(int data) {
    if (isFull()) {
      return;
    }
    if (isEmpty()) {
      ++front;
    }
    rear = rear == capacity - 1 ? 0 : rear + 1;
    contents[rear] = data;
  }

  public Integer dequeue() {
    if (isEmpty()) {
      return null;
    }
    int data = contents[front];
    if (front == rear) {
      front = -1;
      rear = -1;
      return data;
    }
    front = front == capacity - 1 ? 0 : front + 1;
    return data;
  }

  public boolean isEmpty() {
    return rear == -1 ? true : false;
  }

  public boolean isFull() {
    return rear == capacity - 1 ? (front == 0 ? true : false) :
      (rear + 1 == front ? true : false);
  }

  public Integer getFront() {
    if (isEmpty()) {
      return null;
    }
    return contents[front];
  }

  public Integer getRear() {
    if (isEmpty()) {
      return null;
    }
    return contents[rear];
  }

  public void print() {
    if (isEmpty()) {
      System.out.println("Empty!");
      return;
    }
    int i = front;
    System.out.print("F (");
    while (i != rear) {
      System.out.print(contents[i] + " ");
      i = i == capacity - 1 ? 0 : i + 1;
    }
    System.out.print(contents[i] + ") R");
  }
}
