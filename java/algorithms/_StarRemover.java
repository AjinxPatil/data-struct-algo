import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class _StarRemover {
  public static void main(String[] args) throws IOException {
    System.out.print("Enter string: ");
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String s = in.readLine();
    char[] chars = s.toCharArray();
    int l = chars.length;
    for (int i = 1; i < l - 1; i++) {
      if (chars[i] == '*') {
        chars[i - 1] = '*';
        chars[i + 1] = '*';
        i++;
      }
    }
    if (chars[0] == '*' && chars[1] != '*') {
      chars[1] = '*';
    }
    if (chars[l - 1] == '*' && chars[l - 2] != '*') {
      chars[l - 2] = '*';
    }
    StringBuffer sb = new StringBuffer();
    for (char c : chars) {
      if (c != '*') {
        sb.append(c);
      }
    }
    System.out.println(sb.toString());
  }
}
