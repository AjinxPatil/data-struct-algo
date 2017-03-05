package algorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses {
  public static boolean check(String s) {
    if (s == null || s.length() == 0) {
      return true;
    }
    Deque<Character> stack = new ArrayDeque<>();
    for (char c : s.toCharArray()) {
      if (c == '(' || c == '{' || c == '[') {
        stack.offerFirst(c);
      } else {
        Character last = stack.pollFirst();
        if (last == null) {
          return false;
        }
        if (c == ')' && last == '(' || c == '}' && last == '{' || c == ']' && last == '[') {
          continue;
        } else {
          return false;
        }
      }
    }
    if (stack.size() > 0) {
      return false;
    }
    return true;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    System.out.print("Parentheses string: ");
    System.out.println(ValidParentheses.check(in.readLine()));
  }
}
