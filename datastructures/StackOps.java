package datastructures;
import java.io.*;

public class StackOps {
  public static void main(String[] args) throws IOException {
    KStacks stack =
      new KStacks(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    while (true) {
      System.out.println("\nStack Operations");
      System.out.println("(1) Push  (2) Pop  (3) Print  (4) Exit");
      int option = Integer.parseInt(in.readLine());
      int stk;
      switch (option) {
        case 1 : System.out.print("Push? ");
                 int value = Integer.parseInt(in.readLine());
                 System.out.print("In stack ");
                 stk = Integer.parseInt(in.readLine());
                 stack.push(value, stk);
                 break;
        case 2 : System.out.print("Pop from stack ");
                 stk = Integer.parseInt(in.readLine());
                 System.out.println("Popped: " + stack.pop(stk));
                 break;
        case 3 : System.out.print("Stack? ");
                 stk = Integer.parseInt(in.readLine());
                 stack.print(stk);
                 break;
        case 4 : return;
        default: System.out.println("Invalid option. Try again!");
      }
    }
  }

  public static void main_OTHER(String[] args) throws IOException {
    AStack stack = new AStack(Integer.parseInt(args[0]));
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    while (true) {
      System.out.println("\nStack Operations");
      System.out.println("(1) Peek  (2) Push  (3) Pop  (4) Print  (5) Exit");
      int option = Integer.parseInt(in.readLine());
      switch (option) {
        case 1 : System.out.println("Found: " + stack.peek());
                 break;
        case 2 : System.out.print("Push? ");
                 int value = Integer.parseInt(in.readLine());
                 stack.push(value);
                 break;
        case 3 : System.out.println("Popped: " + stack.pop());
                 break;
        case 4 : stack.print();
                 break;
        case 5 : return;
        default: System.out.println("Invalid option. Try again!");
      }
    }
  }
}
