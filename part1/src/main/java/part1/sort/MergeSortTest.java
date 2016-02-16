package part1.sort;

import com.ahalikov.toolkit.utils.ArrayUtils;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author: Artur Khalikov
 */
public class MergeSortTest {

    @Test
    public void testSort() throws Exception {
        int[] actual = {5, 4, 1, 8, 7, 2, 6, 3};
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8};
        MergeSort.sort(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testSort2() throws Exception {
        int[] actual = {5, 4, 1, 8, 0, 7, 2, 6, 0};
        int[] expected = {0, 0, 1, 2, 4, 5, 6, 7, 8};
        MergeSort.sort(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortEmpty() throws Exception {
        int[] actual = {};
        int[] expected = {};
        MergeSort.sort(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortOneElement() throws Exception {
        int[] actual = {1};
        int[] expected = {1};
        MergeSort.sort(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testSort3() throws Exception {
        int n = 1000 + 1;
        int[] expected = new int[n];
        ArrayUtils.fillFrom(expected, 0);

        int[] actual = Arrays.copyOf(expected, expected.length);
        ArrayUtils.shuffle(actual);
        MergeSort.sort(actual);

        assertArrayEquals(expected, actual);
    }
}
