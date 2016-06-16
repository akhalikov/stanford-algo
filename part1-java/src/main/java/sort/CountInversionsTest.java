package sort;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author: Artur Khalikov
 */
public class CountInversionsTest {
    @Test
    public void testCountBoundaryCases() throws Exception {
        int[] a = {};
        int expected = 0;
        assertEquals(expected, CountInversions.count(a));

        a = new int[]{1};
        expected = 0;
        assertEquals(expected, CountInversions.count(a));

        a = new int[]{2, 1};
        expected = 1;
        assertEquals(expected, CountInversions.count(a));

        a = new int[]{2, 1};
        expected = 1;
        assertEquals(expected, CountInversions.count(a));

        a = new int[]{1, 2, 3, 4, 5, 6};
        expected = 0;
        assertEquals(expected, CountInversions.count(a));

        a = new int[]{6, 5, 4, 3, 2, 1};
        expected = 15;
        assertEquals(expected, CountInversions.count(a));
    }

    @Test
    public void testCount() throws Exception {
        int[] a = {1, 3, 5, 2, 4, 6};
        int expected = 3;
        assertEquals(expected, CountInversions.count(a));

        a = new int[]{1, 5, 3, 2, 4};
        expected = 4;
        assertEquals(expected, CountInversions.count(a));

        a = new int[]{5, 4, 3, 2, 1};
        expected = 10;
        assertEquals(expected, CountInversions.count(a));

        a = new int[]{1, 6, 3, 2, 4, 5};
        expected = 5;
        assertEquals(expected, CountInversions.count(a));

        a = new int[]{1, 6, 3, 2, 4, 5};
        expected = 5;
        assertEquals(expected, CountInversions.count(a));

        a = new int[]{9, 12, 3, 1, 6, 8, 2, 5, 14, 13, 11, 7, 10, 4, 0};
        expected = 56;
        assertEquals(expected, CountInversions.count(a));

        a = new int[]{37, 7, 2, 14, 35, 47, 10, 24, 44, 17, 34, 11, 16, 48, 1, 39, 6, 33, 43, 26, 40, 4, 28, 5, 38, 41,
                42, 12, 13, 21, 29, 18, 3, 19, 0, 32, 46, 27, 31, 25, 15, 36, 20, 8, 9, 49, 22, 23, 30, 45};
        expected = 590;
        assertEquals(expected, CountInversions.count(a));

        a = new int[]{4, 80, 70, 23, 9, 60, 68, 27, 66, 78, 12, 40, 52, 53, 44, 8, 49, 28, 18, 46, 21, 39, 51, 7, 87,
                99, 69, 62, 84, 6, 79, 67, 14, 98, 83, 0, 96, 5, 82, 10, 26, 48, 3, 2, 15, 92, 11, 55, 63, 97, 43, 45,
                81, 42, 95, 20, 25, 74, 24, 72, 91, 35, 86, 19, 75, 58, 71, 47, 76, 59, 64, 93, 17, 50, 56, 94, 90, 89,
                32, 37, 34, 65, 1, 73, 41, 36, 57, 77, 30, 22, 13, 29, 38, 16, 88, 61, 31, 85, 33, 54};
        expected = 2372;
        assertEquals(expected, CountInversions.count(a));
    }
}
