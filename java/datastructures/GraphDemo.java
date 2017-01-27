package datastructures;

import java.util.List;

import datastructures.Graph.Node;

public class GraphDemo {
  public static void main(String[] args) {
    Graph g = new Graph();
    g.addVertex(1);
    g.addVertex(2);
    g.addVertex(3);
    g.addVertex(4);
    g.addVertex(5);
    g.addVertex(6);
    g.addVertex(7);
    g.addVertex(8);
    g.addVertex(9);
    g.addBiEdge(1, 2);
    g.addBiEdge(1, 3);
    g.addBiEdge(2, 3);
    g.addBiEdge(2, 4);
    g.addBiEdge(2, 5);
    g.addBiEdge(3, 6);
    g.addBiEdge(4, 5);
    g.addBiEdge(5, 7);
    g.addBiEdge(6, 7);
    g.addBiEdge(8, 9);
    System.out.println("Graph G (V, E)");
    List<Node> vertices = g.getVertices();
    System.out.print("V:");
    for (Node v : vertices) {
      System.out.print(" " + v.id);
    }
    System.out.println();
    int source = 1;
    int destination = 6;
    System.out.println("Path from " + source + " to " + destination + ": " + g.hasPathDfs(source, destination));
    System.out.println("Path from " + source + " to " + destination + ": " + g.hasPathBfs(source, destination));
  }
}
