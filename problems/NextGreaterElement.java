package problems;
public class NextGreaterElement {
  public static void nge(int[] arr) {
    AStack stack = new AStack(arr.length);
    stack.push(arr[0]);
    for (int i = 1; i < arr.length; i++) {
      while (stack.peek() != null && arr[i] > stack.peek()) {
        System.out.println(stack.pop() + " -> " + arr[i]);
      }
      stack.push(arr[i]);
    }
    for (int i = stack.top; i >= 0; i--) {
      System.out.println(stack.pop() + " -> -1");
    }
  }

  public static void main(String[] args) {
    int[] elems = new int[args.length];
    for (int i = 0; i < args.length; i++) {
      elems[i] = Integer.parseInt(args[i]);
    }
    NextGreaterElement.nge(elems);
  }
}
