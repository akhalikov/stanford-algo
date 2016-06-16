package graphs;

import toolkit.utils.ArrayUtils;

import java.util.List;

/**
 * A representation of an undirected graph
 *
 * @author: Artur Khalikov
 */
public class UGraph implements Graph {
  private int[][] array;

  public UGraph(int[][] array) {
    this.array = array;
  }

  /**
   * Return underlying array
   *
   * @return
   */
  public int[][] getArray() {
    return array;
  }

  /**
   * Return copy of underlying array
   *
   * @return array
   */
  public int[][] copyToArray() {
    return ArrayUtils.copyOf(array);
  }

  /**
   * Return number of vertices of the graph
   *
   * @return array
   */
  @Override
  public int size() {
    return array.length;
  }

  @Override
  public UGraph reverse() {
    // not yet implemented
    throw new UnsupportedOperationException();
  }

  @Override
  public List<Integer> adj(int v) {
    // not yet implemented
    throw new UnsupportedOperationException();
  }

  @Override
  public void addEdge(int u, int v) {
    // not yet implemented
    throw new UnsupportedOperationException();
  }

  @Override
  public boolean hasVertex(int v) {
    // not yet implemented
    throw new UnsupportedOperationException();
  }

  @Override
  public String toString() {
    String s = "";
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array[i].length; j++) {
        s += array[i][j] + ((j == array[i].length - 1) ? "\n" : " ");
      }
    }
    return s;
  }

  public void print() {
    System.out.println(this.toString());
  }
}
