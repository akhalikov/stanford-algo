package sort;

import com.ahalikov.toolkit.utils.ArrayUtils;
import com.ahalikov.toolkit.utils.InputFile;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Test for {@link sort.QuickSort2}
 *
 * @author: Artur Khalikov
 */
public class QuickSort2Test {
  String baseDir = System.getProperty("basedir");
  String dataDir = baseDir + "/data/stanford/part1/";

  @Test
  public void testSortOneElement() throws Exception {
    int[] actual = {1};
    int[] expected = {1};
    QuickSort2.sort(actual);
    assertArrayEquals(expected, actual);
  }

  @Test
  public void testSort() throws Exception {
    int[] actual = {5, 4, 1, 8, 7, 2, 6, 3};
    int[] expected = {1, 2, 3, 4, 5, 6, 7, 8};
    QuickSort2.sort(actual);
    assertArrayEquals(expected, actual);
  }

  @Test
  public void testSort2() throws Exception {
    int n = 10000 + 1;
    int[] expected = new int[n];
    ArrayUtils.fillFrom(expected, 0);

    int[] actual = Arrays.copyOf(expected, expected.length);
    ArrayUtils.shuffle(actual);
    QuickSort2.sort(actual);
    assertArrayEquals(expected, actual);
  }

  @Test
  public void testComparisons1() throws Exception {
    int[] a = {3, 9, 8, 4, 6, 10, 2, 5, 7, 1};
    int expected = 29;
    QuickSort2.sort(a);
    assertEquals(expected, QuickSort2.comparisons);
  }

  //@Test
  public void testComparisons2() throws Exception {
    String fileName = dataDir + "100.txt";
    int[] a = new InputFile(fileName).getIntegerArray();
    int expected = 587;
    QuickSort2.sort(a);
    assertEquals(expected, QuickSort2.comparisons);
  }

  //@Test
  public void testComparisons3() throws Exception {
    String fileName = dataDir + "1000.txt";
    int[] a = new InputFile(fileName).getIntegerArray();
    int expected = 10184;
    QuickSort2.sort(a);
    assertEquals(expected, QuickSort2.comparisons);
  }
}
