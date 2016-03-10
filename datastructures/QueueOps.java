import java.io.*;

public class QueueOps {
  public static void main(String[] args) throws IOException {
    APriorityQueue queue = new APriorityQueue(Integer.parseInt(args[0]));
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    while (true) {
      System.out.println("\nQueue Operations");
      System.out.println("(1) Insert  (2) Find high (3) Remove High" +
          " (4) Print  (5) Exit");
      int option = Integer.parseInt(in.readLine());
      switch (option) {
        case 1 : System.out.print("Insert? ");
                 int value = Integer.parseInt(in.readLine());
                 System.out.print("Priority? ");
                 int priority = Integer.parseInt(in.readLine());
                 queue.insert(value, priority);
                 break;
        case 2 : System.out.println("Found: " + queue.getHigh());
                 break;
        case 3 : System.out.println("Removed: " + queue.removeHigh());
                 break;
        case 4 : queue.print();
                 break;
        case 5 : return;
        default: System.out.println("Invalid option. Try again!");
      }
    }
  }

  public static void main_OTHER(String[] args) throws IOException {
    AQueue queue = new AQueue(Integer.parseInt(args[0]));
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    while (true) {
      System.out.println("\nQueue Operations");
      System.out.println("(1) Front (2) Rear (3) Enqueue  (4) Dequeue" +
          " (5) Print  (6) Exit");
      int option = Integer.parseInt(in.readLine());
      switch (option) {
        case 1 : System.out.println("Front: " + queue.getFront());
                 break;
        case 2 : System.out.println("Rear: " + queue.getRear());
                 break;
        case 3 : System.out.print("Enqueue? ");
                 int value = Integer.parseInt(in.readLine());
                 queue.enqueue(value);
                 break;
        case 4 : System.out.println("Dequeued: " + queue.dequeue());
                 break;
        case 5 : queue.print();
                 break;
        case 6 : return;
        default: System.out.println("Invalid option. Try again!");
      }
    }
  }
}
