package problems;

/**
 * Cracking the Coding Interview - Data Structures - 1 Arrays and Strings - 1.3
 * Given two strings, write a method to decide if one is a permutation of the
 * other.
 * 
 * @author Ajinkya Patil
 */
public class StringPermutation {
	public static boolean isStrPermut(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}
		int[] chars = new int[256];
		for (int i = 0; i < s1.length(); i++) {
			++chars[(int) s1.charAt(i)];
		}
		for (int i = 0; i < s2.length(); i++) {
			int count = --chars[(int) s2.charAt(i)];
			if (count < 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		boolean ans = isStrPermut(args[0], args[1]);
		if (ans) {
			System.out.println("String 2 is permutation of string 1!");
		} else {
			System.out.println("String 2 is NOT permutation of string 1!");
		}
	}
}
