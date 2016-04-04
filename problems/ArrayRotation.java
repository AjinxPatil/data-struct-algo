package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Rotate the array by a number k. For example, if array a[] = {1, 2, 3, 4, 5},
 * rotate(a, k) = {3, 4, 5, 1, 2} for k = 2.
 * 
 * @author Ajinkya Patil
 */
public class ArrayRotation {
	/**
	 * Shifts elements from index 0 to k - 1 to the right by swapping with other
	 * elements. Time complexity is O(n^2).
	 * 
	 * @param a
	 *          the array
	 * @param k
	 *          the number of elements to push back
	 */
	public static void rotate(int[] a, int k) {
		for (int i = k; i < a.length; i++) {
			for (int j = i; j > i - k; j--) {
				swap(a, j, j - 1);
			}
		}
	}

	private static void reverse(int[] a, int start, int end) {
		for (int i = start; i <= (start + end) / 2; i++) {
			swap(a, i, end - i + start);
		}
	}

	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	/**
	 * Reversal algorithm for array rotation. Time complexity is O(n).
	 * 
	 * @param a
	 *          the array
	 * @param k
	 *          the number of elements to push back
	 */
	public static void rotateFaster(int[] a, int k) {
		reverse(a, 0, k - 1);
		reverse(a, k, a.length - 1);
		reverse(a, 0, a.length - 1);
	}

	public static void main(String[] args) throws IOException {
		int[] a = new int[args.length];
		for (int i = 0; i < a.length; i++) {
			a[i] = Integer.parseInt(args[i]);
		}
		System.out.print("How many elements to push back? ");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(in.readLine());
		if (x > a.length) {
			System.out.println("ERROR: Out of bounds!");
			return;
		}
		rotateFaster(a, x);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
}
