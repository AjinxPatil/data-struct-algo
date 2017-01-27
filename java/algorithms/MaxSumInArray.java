package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Given an array A[] and a number x, check for pair in A[] with sum as x
 * 
 * @author Ajinkya Patil
 */
public class MaxSumInArray {
	public static boolean sumExists(int[] data, int value) {
		int n = data.length;
		Arrays.sort(data);
		int i = 0;
		int j = n - 1;
		while (i != j) {
			int sum = data[i] + data[j];
			if (sum == value) {
				return true;
			}
			if (sum > value) {
				--j;
			} else {
				++i;
			}
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		int[] data = new int[args.length];
		for (int i = 0; i < data.length; i++) {
			data[i] = Integer.parseInt(args[i]);
		}
		System.out.print("Find sum ");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int sum = Integer.parseInt(in.readLine());
		if (sumExists(data, sum)) {
			System.out.println("TRUE");
		} else {
			System.out.println("FALSE");
		}
	}
}
