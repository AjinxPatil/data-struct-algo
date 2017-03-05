package algorithms;

/**
 * <code>LongestPalindromeSubStr</code> finds the longest palindrome 
 * in a string.
 *
 * @author Ajinkya Patil
 */
public class LongestPalindromeSubStr {

  private static int start = 0; // starting index of longest palindrome
  private static int len = 1;   // length of longest palindrome

  public static String find(String s) {
    int n = s.length();
    if (n < 2) {
      return s;
    }
    if (n == 2) {
      return s.charAt(0) == s.charAt(1) ? s : s.substring(0, 1);
    }
    for (int i = 0; i < n - 1; i++) {
      LongestPalindromeSubStr.extendCheck(s, i, i);
      LongestPalindromeSubStr.extendCheck(s, i, i + 1);
    }
    return s.substring(start, start + len);
  }

  /**
   * For given adjacent indexes (<code>m = n + 1</code>) or 
   * an index (<code>m = n</code>), <code>extendCheck()</code> method
   * checks how long a palindrome exists with <code>m</code> and
   * <code>n</code> as center(s). The method updates 
   * <code>LongestPalindromeSubStr.start</code> and <code>LongestPalindromeSubStr.len</code> members.
   *
   * @param s the string
   * @param m center index
   * @param n center index  
   */
  private static void extendCheck(String s, int m, int n) {
    int sublen = 1;
    int substart = m;
    if (s.charAt(m) != s.charAt(n)) {
      return;
    }
    if (m != n) {
      sublen = 2;
    }
    while (m > 0 && n < s.length() - 1) {
      if (s.charAt(--m) == s.charAt(++n)) {
        sublen += 2;
        substart = m;
      } else {
        break;
      }
    }
    if (len < sublen) {
      len = sublen;
      start = substart;
    }
  }

  public static void main(String[] args) {
    System.out.println(LongestPalindromeSubStr.find(args[0]));
  }
}
