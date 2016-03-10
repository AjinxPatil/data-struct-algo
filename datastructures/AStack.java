public class AStack {
  Integer top;
  Integer capacity;
  Integer[] contents;

  AStack(int capacity) {
    top = -1;
    this.capacity = capacity;
    contents = new Integer[capacity];
  }

  public boolean isFull() {
    if (top == capacity - 1) {
      return true;
    }
    return false;
  }

  public boolean isEmpty() {
    if (top == -1) {
      return true;
    }
    return false;
  }

  public boolean push(int value) {
    if (isFull()) {
      return false;
    }
    contents[++top] = value;
    return true;
  }

  public Integer pop() {
    if (isEmpty()) {
      return null;
    }
    return contents[top--];
  }

  public Integer peek() {
    if (isEmpty()) {
      return null;
    }
    return contents[top];
  }

  public void print() {
    System.out.println("STACK\n-----");
    for (int i = top; i >= 0; i--) {
      System.out.println(contents[i]);
    }
    System.out.println("-----");
  }
}
