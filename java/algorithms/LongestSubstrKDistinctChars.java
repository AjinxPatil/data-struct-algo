package algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ajinkya Patil
 */
public class LongestSubstrKDistinctChars {
  public static int find(String s, int k) {
    if (s == null || s.length() < 2) {
      return 0;
    }
    Map<Character, Integer> map = new HashMap<>();
    int max = 1;
    int start = 0;
    char[] chars = s.toCharArray();
    map.put(chars[0], 0);
    for (int i = 1; i < chars.length; i++) {
      if (map.containsKey(chars[i]) && chars[i] != chars[i - 1]) {
        map.put(chars[i], i);
      } else if (!map.containsKey(chars[i])) {
        if (map.size() == k) {
          Character minKey = null;
          int min = Integer.MAX_VALUE;
          for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (min > entry.getValue()) {
              min = entry.getValue();
              minKey = entry.getKey();
            }
          }
          map.remove(minKey);
          max = Math.max(max, i - start);
          start = min + 1;
        }
        map.put(chars[i], i);
      }
    }
    return Math.max(max, chars.length - start - 1);
  }

  public static void main(String[] args) {
    System.out.println(find("abaacacbbacc", 2));
    System.out.println(find("abaacacbdacc", 3));
  }
}
