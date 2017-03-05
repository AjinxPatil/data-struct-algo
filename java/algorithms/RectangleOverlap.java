package algorithms;

public class RectangleOverlap {
  public static boolean check(int blx1, int bly1, int trx1, int try1, int blx2, int bly2, int trx2, int try2) {
    return !(blx2 >= trx1 || trx2 <= blx1 || bly2 >= try1 || try2 <= bly1);
  }

  public static void main(String[] args) {
    int blx1 = Integer.valueOf(args[0]);
    int bly1 = Integer.valueOf(args[1]);
    int trx1 = Integer.valueOf(args[2]);
    int try1 = Integer.valueOf(args[3]);
    int blx2 = Integer.valueOf(args[4]);
    int bly2 = Integer.valueOf(args[5]);
    int trx2 = Integer.valueOf(args[6]);
    int try2 = Integer.valueOf(args[7]);
    System.out.println(RectangleOverlap.check(blx1, bly1, trx1, try1, blx2, bly2, trx2, try2));
  }
}
