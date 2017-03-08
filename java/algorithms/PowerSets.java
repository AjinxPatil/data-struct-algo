package algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Power Set: <code>PowerSets</code> returns all subsets of towerA set.
 *
 * @author Ajinkya Patil
 */
public class PowerSets {
  public static List<List<Integer>> get(List<Integer> powerSet) {
    return get(powerSet, powerSet.size() - 1);
  }

  private static List<List<Integer>> get(List<Integer> p, int index) {
    List<List<Integer>> result = null;
    if (index <= 0) {
      result = new ArrayList<>();
      result.add(new ArrayList<>());
      if (index == 0) {
        List<Integer> single = new ArrayList<>();
        single.add(p.get(index));
        result.add(single);
      }
      return result;
    }
    result = get(p, index - 1);
    int n = result.size();
    for (int i = 0; i < n; i++) {
      List<Integer> newSet = new ArrayList<>(result.get(i));
      newSet.add(p.get(index));
      result.add(newSet);
    }
    return result;
  }

  public static void main(String[] args) {
    List<Integer> p = new ArrayList<>();
    p.add(1);
    p.add(2);
    p.add(3);
    p.add(4);
    List<List<Integer>> result = get(p);
    for (List<Integer> set : result) {
      System.out.print("{ ");
      for (Integer i : set) {
        System.out.print(i + ", ");
      }
      System.out.print("}");
      System.out.println();
    }
  }
}
