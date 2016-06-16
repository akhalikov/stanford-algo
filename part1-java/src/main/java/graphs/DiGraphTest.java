package graphs;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 * @author: Artur Khalikov
 */
public class DiGraphTest {
  private DiGraph testGraph;

  @Before
  public void setUp() throws Exception {
    testGraph = new DiGraph(4);
    testGraph.addEdge(1, 2);
    testGraph.addEdge(2, 3);
    testGraph.addEdge(2, 4);
    testGraph.addEdge(3, 1);
    testGraph.addEdge(3, 4);
  }

  @Test
  public void testSize() throws Exception {
    assertEquals("Invalid size", 4, testGraph.size());
  }

  @Test
  public void testArcs() throws Exception {
    List<Integer> arcs1 = testGraph.adj(1);
    assertEquals(1, arcs1.size());
    assertEquals(2, arcs1.get(0).intValue());

    List<Integer> arcs2 = testGraph.adj(2);
    assertEquals(2, arcs2.size());
    assertEquals(3, arcs2.get(0).intValue());
    assertEquals(4, arcs2.get(1).intValue());

    List<Integer> arcs3 = testGraph.adj(3);
    assertEquals(2, arcs3.size());
    assertEquals(1, arcs3.get(0).intValue());
    assertEquals(4, arcs3.get(1).intValue());

    List<Integer> arcs4 = testGraph.adj(4);
    assertEquals(0, arcs4.size());
  }

  @Test
  public void testReverse() throws Exception {
    DiGraph reverse = testGraph.reverse();
    System.out.println("------ Reversed graph ------");
    reverse.print();
  }
}
