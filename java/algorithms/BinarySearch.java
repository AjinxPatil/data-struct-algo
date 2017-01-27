package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Binary Search
 * 
 * @author Ajinkya Patil
 */
public class BinarySearch {
	public static int search(int[] a, int start, int end, int x) {
		int mid = (start + end) / 2;
		int pos = -1;
		if (x == a[mid]) {
			return mid;
		}
		if (start == end) {
			return pos;
		}
		if (x < a[mid]) {
			pos = search(a, start, mid - 1, x);
		} else {
			pos = search(a, mid + 1, end, x);
		}
		return pos;
	}

	public static void main(String[] args) throws IOException {
		int[] a = new int[args.length];
		for (int i = 0; i < args.length; i++) {
			a[i] = Integer.parseInt(args[i]);
		}
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Search: ");
		int x = Integer.parseInt(in.readLine());
		Arrays.sort(a);
		int pos = search(a, 0, a.length - 1, x);
		if (pos < 0) {
			System.out.println(x + " not found!");
		} else {
			System.out.println(x + " found at " + pos);
		}
	}
}
