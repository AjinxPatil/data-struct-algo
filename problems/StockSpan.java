package problems;
public class StockSpan {
  public static int[] getSpans(int[] prices) {
    AStack stack = new AStack(prices.length);
    int[] spans = new int[prices.length];
    for (int i = 0; i < prices.length; i++) {
      spans[i] = 1;
      if (stack.isEmpty()) {
        stack.push(i);
        continue;
      }
      while (stack.isEmpty() == false && prices[i] > prices[stack.peek()]) {
        int index = stack.pop();
        spans[i] += spans[index];
      }
      stack.push(i);
    }
    return spans;
  }

  public static void main(String[] args) {
    int[] prices = new int[args.length];
    for (int i = 0; i < args.length; i++) {
      prices[i] = Integer.parseInt(args[i]);
    }
    int[] spans = StockSpan.getSpans(prices);
    for (int i = 0; i < prices.length; i++) {
      System.out.println(prices[i] + " -> " + spans[i]);
    }
  }
}
