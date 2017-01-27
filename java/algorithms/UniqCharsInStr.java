package problems;

/**
 * Cracking the Coding Interview - Data Structures 1 Arrays and Strings 1.1
 * Implement an algorithm to determine if a string has all unique characters.
 * What if you cannot use additional data structures?
 * 
 * @author Ajinkya Patil
 */
public class UniqCharsInStr {
	public static boolean isUniqCharStr(String s) {
		boolean[] charSet = new boolean[256];
		if (s.length() > 256) {
			return false;
		}

		for (int i = 0; i < s.length(); i++) {
			if (charSet[s.charAt(i)] == true) {
				return false;
			}
			charSet[s.charAt(i)] = true;
		}
		return true;
	}

	public static void main(String[] args) {
		boolean containsUnique = isUniqCharStr(args[0]);
		if (containsUnique) {
			System.out.println("The string contains all unique characters!");
		} else {
			System.out.println("The string does NOT contain all unique characters");
		}
	}
}
