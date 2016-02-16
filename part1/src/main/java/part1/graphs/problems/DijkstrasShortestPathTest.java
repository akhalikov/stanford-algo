package part1.graphs.problems;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Test {@link DijkstrasShortestPath}
 *
 * @author Artur Khalikov
 */
public class DijkstrasShortestPathTest {
  String baseDir = System.getProperty("basedir");
  String dataDir = baseDir + "/data/stanford/part1/";
  String[] TESTS = {"dijkstra0.txt", "dijkstra1.txt"};
  int[][] EXPECTED = {
    {0, 3, 3, 5},
    {0, 3, 4, 5}
  };

  @Test
  public void testInput() throws Exception {
    String line = "1	80,982	163,8164	170,2620	145,648	200,8021	173,2069	" +
      "92,647	26,4122	140,546	11,1913	160,6461	27,7905	40,9047	150,2183	61,9146	159,7420	198,1724	" +
      "114,508	104,6647	30,4612	99,2367	138,7896	169,8700	49,2437	125,2909	117,2597	55,6399";
    String[] split = line.split("\\t");
    for (String s : split)
      System.out.println(s + " ");
  }

  //@Test
  public void test() throws Exception {
    for (int i = 0; i < TESTS.length; i++) {
      String fileName = dataDir + TESTS[i];
      System.out.println("Testing: " + fileName);
      DijkstrasShortestPath sp = new DijkstrasShortestPath(fileName, 1);
      for (int j = 0; j < EXPECTED[i].length; j++) {
        assertEquals(EXPECTED[i][j], sp.getDist(j + 1));
      }
    }
  }
}
