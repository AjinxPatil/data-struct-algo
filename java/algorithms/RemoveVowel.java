package algorithms;

public class RemoveVowel {

  public static String execute(String s) {
    String v = "aeiouAEIOU";
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      if (v.indexOf(s.charAt(i)) > -1) {
        continue;
      }
      sb.append(s.charAt(i));
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    System.out.println(RemoveVowel.execute(args[0]));
  }
}
