package problems;

/**
 * Cracking the Coding Interview - Data Structures - 1 Arrays and Strings - 1.8
 * Assume you have a method isSubstring which checks if one word is a substring
 * of another. Given two strings, s1 and s2, write code to check if s2 is a
 * rotation of s1 using only one call to isSubstring (e.g., "waterbottLe" is a
 * rotation of "erbottLewat").
 * 
 * @author Ajinkya Patil
 *
 */
public class StringRotation {
	public static boolean isStrRotated(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}
		StringBuffer s = new StringBuffer(s1);
		s.append(s1);
		return isSubstring(s.toString(), s2);

	}

	public static boolean isSubstring(String s1, String s2) {
		return s1.contains(s2);
	}

	public static void main(String[] args) {
		if (isStrRotated(args[0], args[1])) {
			System.out.println("String is rotated!");
		} else {
			System.out.println("String is different!");
		}
	}
}
