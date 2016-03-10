public class APriorityQueue {
  public static class Item {
    int data;
    int priority;
    Item next;
    Item(int d, int p) {
      data = d;
      priority = p;
    }
  }
  Item front;
  Item rear;

  public void isEmpty() {
    return rear == null ? true : false;
  }

  public void insert(int data, int priority) {
    Item item = new Item(data, priority);
    if (isEmpty()) {
      rear = item;
      front = rear;
    }
    rear.next = item;
    rear = rear.next;
  }

  public int getHigh() {
    Item pass = front;
    Item mark = pass;
    while (pass != null) {
      if (pass.data > mark.data) {
        mark = pass;
      }
      pass = pass.next;
    }
    return mark.data;
  }

  public int removeHigh() {
    Item pass = front;
    Item passprev = null;
    Item markprev = null;
    Item mark = pass;
    while (pass != null) {
      if (pass.priority > mark.priority) {
        mark = pass;
        markprev = passprev;
      }
      passprev = pass;
      pass = pass.next;
    }
    if (markprev == null) {
      if (rear == front) {
        front = null;
        rear = null;
      } else {
        front = front.next;
      }
      return mark.data;
    }
    markprev.next = mark.next;
    return mark.data;
  }

  public void print() {
    if (isEmpty()) {
      System.out.println("Empty!");
      return;
    }
    Item pass = front;
    while (pass != null) {
      System.out.print(pass.data + " [" + pass.priority + "] | ");
    }
  }
}
