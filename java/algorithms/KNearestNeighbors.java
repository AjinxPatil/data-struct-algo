package algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * <code>KNearestNeighbors</code> finds the closest k <code>Point</code> points from a given point.
 *
 * @author Ajinkya Patil
 */
public class KNearestNeighbors {
  
  public static class Point {
    int x;
    int y;
    private Point() {}
    Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public static class PointComparator implements Comparator<Point> {
    Point ref;
    PointComparator() {
      this.ref = new Point(0, 0);
    }
    PointComparator(Point ref) {
      this.ref = ref;
    }
    
    public int compare(Point p1, Point p2) {
      return (int) (KNearestNeighbors.calcDist(ref, p1) - KNearestNeighbors.calcDist(ref, p2));
    }
  }

  public static List<Point> find(Point p, List<Point> points, int k) {
    if (k >= points.size()) {
      return points;
    }
    Collections.sort(points, new PointComparator()); 
    return points.subList(0, k);
  }

  public static List<Point> quickFind(Point p, List<Point> points, int k) {
    if (k >= points.size()) {
      return points;
    }
    KNearestNeighbors.quickSelect(points, 0, points.size() - 1, p, k);
    return points.subList(0, k);
  }

  private static void quickSelect(List<Point> points, int start, int end, Point ref, int k) {
    Point pivot = points.get(end);
    int lo = start;
    int hi = end;
    PointComparator comp = new PointComparator(ref);
    while (lo < hi) {
      Point plo = points.get(lo);
      Point phi = points.get(hi);
      while (comp.compare(plo, pivot) <= 0 && lo < hi) {
        plo = points.get(++lo);
      }
      while (comp.compare(phi, pivot) > 0 && hi < lo) {
        phi = points.get(--hi);
      }
      if (lo < hi) {
        KNearestNeighbors.swap(points, lo, hi);
      }
    }
    if (lo < end - 1) {
      KNearestNeighbors.swap(points, lo, end);
    }
    if (lo < k - 1) {
      quickSelect(points, lo + 1, end, ref, k);
    } else if (lo > k - 1) {
      quickSelect(points, start, lo - 1, ref, k);
    }
  }

  private static double calcDist(Point p1, Point p2) {
    return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
  }

  private static void swap(List<Point> points, int i, int j) {
    Point p1 = points.get(i);
    Point temp = new Point(p1.x, p1.y);
    Point p2 = points.get(j);
    p1.x = p2.x;
    p1.y = p2.y;
    p2.x = temp.x;
    p2.y = temp.y;
    temp = null;
  }

  public static void main(String[] args) {
    List<Point> points = new ArrayList<>();
    points.add(new Point(1, 15));
    points.add(new Point(0, 15));
    points.add(new Point(1, 15));
    points.add(new Point(1, 15));
    points.add(new Point(2, 0));
    points.add(new Point(6, 0));
    points.add(new Point(7, 0));
    points = quickFind(new Point(0, 0), points, 4);
    System.out.println("Neighbors:");
    for (Point p : points) {
      System.out.println(p.x + " " + p.y);
    }
  }
}
