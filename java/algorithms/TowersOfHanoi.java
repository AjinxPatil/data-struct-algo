package algorithms;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Towers of Hanoi
 *
 * @author Ajinkya Patil
 */
public class TowersOfHanoi {
  private Deque<Integer> towerA;
  private Deque<Integer> towerB;
  private Deque<Integer> towerC;
  int numOfDisks;

  private TowersOfHanoi() {
  }

  public TowersOfHanoi(int numOfDisks) {
    this.numOfDisks = numOfDisks;
    towerA = new ArrayDeque<>();
    towerB = new ArrayDeque<>();
    towerC = new ArrayDeque<>();
    for (int i = numOfDisks; i > 0; i--) {
      towerA.offerFirst(i);
    }
  }

  public void play() {
    moveDisks(towerA, towerC, towerB, numOfDisks);
  }

  private static void moveDisks(Deque<Integer> startTower, Deque<Integer> endTower, Deque<Integer>
          auxTower, int numOfDisks) {
    if (numOfDisks < 1) {
      return;
    }
    if (numOfDisks == 1) {
      endTower.offerFirst(startTower.pollFirst());
      return;
    }
    moveDisks(startTower, auxTower, endTower, numOfDisks - 1);
    moveDisks(startTower, endTower, auxTower, 1);
    moveDisks(auxTower, endTower, startTower, numOfDisks - 1);
  }

  private void print() {
    List<Deque<Integer>> stacks = new ArrayList<>(3);
    stacks.add(towerA);
    stacks.add(towerB);
    stacks.add(towerC);
    System.out.println("*****");
    for (Deque<Integer> stack : stacks) {
      List<Integer> list = new ArrayList<>(stack);
      System.out.println("Tower");
      for (Integer i : list) {
        System.out.println(i);
      }
      System.out.println("-----");
    }
    System.out.println("*****");
  }

  public static void main(String[] args) {
    TowersOfHanoi game = new TowersOfHanoi(10);
    game.print();
    game.play();
    game.print();
  }
}
