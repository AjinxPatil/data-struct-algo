package problems;

/**
 * Cracking the Coding Interview - Data Structures 1 Arrays and Strings 1.5
 * Implement a method to perform basic string compression using the counts of
 * repeated characters. For example, the string aabcccccaaa would become
 * a2blc5a3. If the "compressed" string would not become smaller than the
 * original string, your method should return the original string.
 * 
 * @author Ajinkya Patil
 */
public class RunLengthEncoding {
	public static String compress(String original) {
		StringBuffer encoded = new StringBuffer();
		char ch = original.charAt(0);
		int count = 1;
		for (int i = 1; i < original.length(); i++) {
			if (ch == original.charAt(i)) {
				count++;
			} else {
				encoded.append(ch);
				encoded.append(count);
				count = 1;
				ch = original.charAt(i);
			}
		}
		encoded.append(ch);
		encoded.append(count);

		if (encoded.length() > original.length()) {
			return original;
		}
		return encoded.toString();
	}

	public static void main(String[] args) {
		String out = RunLengthEncoding.compress(args[0]);
		System.out.println(out);
	}
}
