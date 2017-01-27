package datastructures;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Iterator;

/**
 * <code>Graph</code> data structure consists of nodes (vertices) interconnected by edges.
 *
 * @author Ajinkya Patil
 */
public class Graph {
  private Map<Integer, Node> vertices;

  public Graph() {
    this.vertices = new HashMap<>();
  }

  private Node getNode(int id) {
    return this.vertices.get(id);
  }

  public List<Node> getVertices() {
    Collection<Node> nodes = this.vertices.values();
    if (nodes.size() == 0) {
      return null;
    }
    return new ArrayList<Node>(nodes);
  }

  public void addVertex(int id) {
    Node newNode = new Node(id);
    Node result = this.vertices.putIfAbsent(id, newNode);
    if (result != null) {
      throw new IllegalStateException("ERROR addVertex: Adding an existing vertex in graph!");
    }
  }

  public void addVertex(int id, Set<Integer> adjacents) {
    for (Integer nodeId : adjacents) {
      if (!this.vertices.containsKey(nodeId)) {
        throw new IllegalStateException("ERROR addVertex: Adjacent of the vertex is missing!");
      }
    }
    List<Integer> adjacentsList = new LinkedList<>();
    adjacentsList.addAll(adjacents);
    Node newNode = new Node(id, adjacentsList);
    Node result = this.vertices.putIfAbsent(id, newNode);
    if (result != null) {
      throw new IllegalStateException("ERROR addVertex: Adding an existing vertex in graph!");
    }
  }

  public void addEdge(int source, int destination) {
    Node srcNode = this.getNode(source);
    Node destNode = this.getNode(destination);
    if (srcNode == null || destNode == null) {
      throw new IllegalStateException("ERROR addEdge: Vertex missing while adding edge!");
    }
    srcNode.adjacents.add(destination);
  }

  public void addBiEdge(int vertex1, int vertex2) {
    Node node1 = this.getNode(vertex1);
    Node node2 = this.getNode(vertex2);
    if (node1 == null || node2 == null) {
      throw new IllegalStateException("ERROR addBiEdge: Vertex missing while adding edge!");
    }
    node1.adjacents.add(vertex2);
    node2.adjacents.add(vertex1);
  }

  public boolean hasPathDfs(int source, int destination) {
    if (source == destination) {
      return true;
    }
    Node src = this.getNode(source);
    Node dest = this.getNode(destination);
    if (src == null || dest == null) {
      throw new IllegalStateException("ERROR: hasPathDfs: source or destination missing!");
    }
    if (src.adjacents.size() == 0) {
      return false;
    }
    Set<Integer> visited = new HashSet<>();
    return this.hasPathDfs(src, dest, visited);
  }

  private boolean hasPathDfs(Node src, Node dest, Set<Integer> visited) {
    Iterator<Integer> adjs = src.adjacents.listIterator(0);
    while(adjs.hasNext()) {
      int id = adjs.next();
      if (dest.id == id) {
        return true;
      }
      if (visited.contains(id)) {
        continue;
      }
      visited.add(id);
      return hasPathDfs(this.getNode(id), dest, visited);
    }
    return false;
  }

  public boolean hasPathBfs(int source, int destination) {
    if (source == destination) {
      return true;
    }
    Node src = this.getNode(source);
    Node dest = this.getNode(destination);
    if (src == null || dest == null) {
      throw new IllegalStateException("ERROR: hasPathBfs: source or destination missing!");
    }
    if (src.adjacents.size() == 0) {
      return false;
    }
    Queue<Integer> q = new LinkedList<>();
    Set<Integer> visited = new HashSet<>();
    q.offer(source);
    while (q.size() > 0) {
      int currentId = q.poll();
      visited.add(currentId);
      Node current = this.getNode(currentId);
      Iterator<Integer> adjs = current.adjacents.listIterator(0);
      while (adjs.hasNext()) {
        int nextNodeId = adjs.next();
        if (nextNodeId == destination) {
          return true;
        }
        if (visited.contains(nextNodeId)) {
          continue;
        }
        q.offer(nextNodeId);
      }
    }
    return false;
  }

  public static class Node {
    public int id;
    public List<Integer> adjacents;
    private Node() {}
    public Node(int id) {
      this.id = id;
      this.adjacents = new LinkedList<Integer>();
    }
    public Node(int id, List<Integer> nodes) {
      this.adjacents = new LinkedList<Integer>(nodes);
    }
  }
}
