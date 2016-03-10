package problems;
public class StackReversal {
  public static void reverse(AStack stack) {
    if (stack.isEmpty()) {
      return;
    }
    int sliced = stack.pop();
    reverse(stack);
    insert(stack, sliced);
  }

  public static void insert(AStack stack, int value) {
    if (stack.isEmpty()) {
      stack.push(value);
      return;
    }
    int other = stack.pop();
    insert(stack, value);
    stack.push(other);
  }

  public static void main(String[] args) {
    AStack stack = new AStack(args.length);
    for (int i = 0; i < args.length; i++) {
      stack.push(Integer.parseInt(args[i]));
    }
    System.out.println("Before Reversal: ");
    stack.print();
    System.out.println("On Reversal: ");
    StackReversal.reverse(stack);
    stack.print();
  }
}
