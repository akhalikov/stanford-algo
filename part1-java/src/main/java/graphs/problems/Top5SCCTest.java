package graphs.problems;

import graphs.Graph;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author: Artur Khalikov
 */
public class Top5SCCTest {
  String baseDir = System.getProperty("basedir");
  String dataDir = baseDir + "/data/stanford/part1/";
  String[] TESTS = {"scc0", "scc1", "scc2", "scc3", "scc4"};

  int[][] EXPECTED = {
    {3, 3, 3, 0, 0},
    {3, 3, 2, 0, 0},
    {3, 3, 1, 1, 0},
    {7, 1, 0, 0, 0},
    {6, 3, 2, 1, 0}
  };

  @Test
  public void test() throws Exception {
    for (int i = 0; i < TESTS.length; i++) {
      String fileName = dataDir + "scc" + i + ".txt";
      System.out.print("Testing: " + fileName);
      Graph graph = Top5SCC.readGraph(fileName);
      assertNotNull("graph is null", graph);

      Top5SCC scc = new Top5SCC(graph);
      int[] actual = scc.getTop5SccSizes();
      assertArrayEquals(EXPECTED[i], actual);
      System.out.println("...OK");
    }
  }
}