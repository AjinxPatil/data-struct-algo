package problems;

import datastructures.AStack;

/**
 * Given an array, print the Next Greater Element (NGE) for every element. The
 * Next greater Element for an element x is the first greater element on the
 * right side of x in array. Elements for which no greater element exist,
 * consider next greater element as -1.
 * 
 * @author Ajinkya Patil
 */
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
		for (int i = stack.peek(); i >= 0; i--) {
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
