package sort;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author ahalikov
 */
public class QuickSort4Test {

  @Test(expected = IllegalArgumentException.class)
  public void testSortNullArray() throws Exception {
    QuickSort4.sort(null);
  }

  @Test
  public void testSortEmptyArray() throws Exception {
    int[] expected = {};
    int[] actual = QuickSort4.sort(new int[]{});
    assertArrayEquals(expected, actual);
  }

  @Test
  public void testSort1() throws Exception {
    int[] expected = {-2, 0, 1, 2, 3, 4};
    int[] actual = QuickSort4.sort(new int[]{4, 3, 2, 1, 0, -2});
    assertArrayEquals(expected, actual);
  }

  @Test
  public void testSort2() throws Exception {
    int[] actual = {5, 4, 1, 8, 7, 2, 6, 3};
    int[] expected = {1, 2, 3, 4, 5, 6, 7, 8};
    int[] result = QuickSort4.sort(actual);
    assertArrayEquals(expected, result);
  }
}