package problems;

/**
 * Cracking the Coding Interview - Data Structures 1 Arrays and Strings 1.4
 * Write a method to replace all spaces in a string with '%20'. You may assume
 * that the string has sufficient space at the end of the string to hold the
 * additional characters, and that you are given the "true" length of the
 * string. (Note: if implementing in Java, please use a character array so that
 * you can perform this operation in place.)
 * 
 * @author Ajinkya Patil
 */
public class WhitespaceFiller {
	public static char[] fillWhitespace(char[] str, int true_len) {
		int length = str.length;
		for (int i = true_len - 1; i > -1; i--) {
			if (str[i] != '_') {
				str[--length] = str[i];
			} else {
				str[--length] = '0';
				str[--length] = '2';
				str[--length] = '%';
			}
		}
		return str;
	}

	public static void main(String[] args) {
		char[] str = fillWhitespace(args[0].toCharArray(),
				Integer.parseInt(args[1]));
		System.out.println(new String(str));
	}
}
