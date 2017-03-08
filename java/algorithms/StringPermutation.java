package algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Cracking the Coding Interview - Data Structures - 1 Arrays and Strings - 1.3
 * Given two strings, write a method to decide if one is a permutation of the
 * other.
 * <code>StringPermutation</code> can also print out all permutations of a string.
 *
 * @author Ajinkya Patil
 */
public class StringPermutation {
  public static boolean checkPermutation(String s1, String s2) {
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

  public static void printPermutations(String s) {
    List<String> permutations = permute(s);
    for (String p : permutations) {
      System.out.println(p);
    }
  }

  private static List<String> permute(String s) {
    List<String> result = new ArrayList<>();
    if (s.length() == 1) {
      result.add(s);
      return result;
    }
    for (int i = 0; i < s.length(); i++) {
      StringBuilder sb = new StringBuilder(s);
      result.addAll(combine(sb.charAt(i), permute(sb.deleteCharAt(i).toString())));
    }
    return result;
  }

  private static List<String> combine(Character c, List<String> slist) {
    List<String> result = new ArrayList<>();
    for (String s : slist) {
      result.add(c + s);
    }
    return result;
  }
}
