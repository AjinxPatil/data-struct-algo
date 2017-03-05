package datastructures;

import java.util.*;

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
      throw new IllegalStateException("ERROR @ addVertex(int): Adding an existing vertex in graph!");
    }
  }

  public void addVertex(int id, Set<Integer> adjacents) {
    for (Integer nodeId : adjacents) {
      if (!this.vertices.containsKey(nodeId)) {
        throw new IllegalStateException("ERROR @ addVertex(int, Set): Adjacent of the vertex is missing!");
      }
    }
    List<Integer> adjacentsList = new LinkedList<>();
    adjacentsList.addAll(adjacents);
    Node newNode = new Node(id, adjacentsList);
    Node result = this.vertices.putIfAbsent(id, newNode);
    if (result != null) {
      throw new IllegalStateException("ERROR @ addVertex(int, Set): Adding an existing vertex in graph!");
    }
  }

  public void addEdge(int source, int destination) {
    Node srcNode = this.getNode(source);
    Node destNode = this.getNode(destination);
    if (srcNode == null || destNode == null) {
      throw new IllegalStateException("ERROR @ addEdge(int, int): Vertex missing while adding edge!");
    }
    srcNode.adjacents.add(destination);
  }

  public void addBiEdge(int vertex1, int vertex2) {
    Node node1 = this.getNode(vertex1);
    Node node2 = this.getNode(vertex2);
    if (node1 == null || node2 == null) {
      throw new IllegalStateException("ERROR @ addBiEdge(int, int): Vertex missing while adding edge!");
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
      throw new IllegalStateException("ERROR @ hasPathDfs(int, int): source or destination missing!");
    }
    if (src.adjacents.size() == 0) {
      return false;
    }
    Set<Integer> visited = new HashSet<>();
    return this.hasPathDfs(src, dest, visited);
  }

  private boolean hasPathDfs(Node src, Node dest, Set<Integer> visited) {
    Iterator<Integer> adjs = src.adjacents.listIterator(0);
    while (adjs.hasNext()) {
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
      throw new IllegalStateException("ERROR @ hasPathBfs(int, int): source or destination missing!");
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
        int adjacent = adjs.next();
        if (adjacent == destination) {
          return true;
        }
        if (visited.contains(adjacent)) {
          continue;
        }
        q.offer(adjacent);
      }
    }
    return false;
  }

  public boolean hasPathBds(int source, int destination) {
    if (source == destination) {
      return true;
    }
    Node src = this.getNode(source);
    Node dest = this.getNode(destination);
    if (src == null || dest == null) {
      throw new IllegalStateException("ERROR @ hasPathBds(int, int): source or destination missing!");
    }
    Queue<Integer> blueQ = new LinkedList<>();
    Queue<Integer> redQ = new LinkedList<>();
    Set<Integer> blues = new HashSet<>();
    Set<Integer> reds = new HashSet<>();
    blueQ.offer(source);
    redQ.offer(destination);
    boolean isRed = false;
    Queue<Integer> q = blueQ;
    while (!q.isEmpty()) {
      int curr = q.poll();
      if (isRed) {
        reds.add(curr);
      } else {
        blues.add(curr);
      }
      Node current = vertices.get(curr);
      Iterator<Integer> adjs = current.adjacents.listIterator();
      while (adjs.hasNext()) {
        int adjacent = adjs.next();
        if (isRed && blues.contains(adjacent) || !isRed && reds.contains(adjacent)) {
          return true;
        }
        if (isRed && !reds.contains(adjacent) || !isRed && !blues.contains(adjacent)) {
          if (isRed) {
            redQ.offer(adjacent);
            q = blueQ;
          } else {
            blueQ.offer(adjacent);
            q = redQ;
          }
        }
      }
      isRed = !isRed;
    }
    return false;
  }

  public static class Node {
    public int id;
    public List<Integer> adjacents;

    private Node() {
    }

    public Node(int id) {
      this.id = id;
      this.adjacents = new LinkedList<>();
    }

    public Node(int id, List<Integer> nodes) {
      this.adjacents = new LinkedList<>(nodes);
    }
  }
}
