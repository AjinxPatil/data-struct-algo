package problems;

import datastructures.AStack;

/**
 * The Stock pan problem is a financial problem where we have a series of n
 * daily price quotes for a stock and we need to calculate span of stock’s price
 * for all n days. The span Si of the stock’s price on a given day i is defined
 * as the maximum number of consecutive days just before the given day, for
 * which the price of the stock on the current day is less than or equal to its
 * price on the given day. For example, if an array of 7 days prices is given as
 * {100, 80, 60, 70, 60, 75, 85}, then the span values for corresponding 7 days
 * are {1, 1, 1, 2, 1, 4, 6}
 * 
 * @author Ajinkya Patil
 */
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
		int[] spans = getSpans(prices);
		for (int i = 0; i < prices.length; i++) {
			System.out.println(prices[i] + " -> " + spans[i]);
		}
	}
}
