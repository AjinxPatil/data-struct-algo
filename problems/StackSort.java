package problems;
public class StackSort {
  public static void sort(AStack stack) {
    if (stack.isEmpty()) {
      return;
    }
    int sliced = stack.pop();
    sort(stack);
    compare(stack, sliced);
  }

  public static void compare(AStack stack, int sliced) {
    if (stack.isEmpty()) {
      stack.push(sliced);
      return;
    }
    if (sliced > stack.peek()) {
      int smaller = stack.pop();
      compare(stack, sliced);
      stack.push(smaller);
    } else {
      stack.push(sliced);
    }
  }

  public static void main(String[] args) {
    AStack stack = new AStack(args.length);
    for (int i = 0; i < args.length; i++) {
      stack.push(Integer.parseInt(args[i]));
    }
    System.out.println("Initial stack: ");
    stack.print();
    StackSort.sort(stack);
    System.out.println("Sorted stack: ");
    stack.print();
  }
}
