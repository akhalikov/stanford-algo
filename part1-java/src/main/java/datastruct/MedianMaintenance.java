package datastruct;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

import static junit.framework.Assert.assertEquals;

/**
 * A Median maintenance problem
 * Assignment 6, question 2
 *
 * TODO: This is naive implementation. Try to figure out more clever solutions.
 * TODO: what is running time?
 *
 * @author Artur Khalikov
 */
public class MedianMaintenance {

    private static final int MOD_FACTOR = 10 * 1000;
    private int sum = 0;

    public MedianMaintenance(String fileName) {
        scan(fileName);
    }

    private void scan(String fileName) {
        try {
            BufferedReader reader = null;
            List<Integer> numbers = new ArrayList();
            try {
                reader = new BufferedReader(new FileReader(fileName));
                String line;
                int i = 0;
                while ((line = reader.readLine()) != null) {
                    numbers.add(Integer.parseInt(line));
                    Collections.sort(numbers);
                    sum += numbers.get(i / 2);
                    i++;
                }
                sum = sum % MOD_FACTOR;
            } finally {
                if (reader != null)
                    reader.close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        if (args.length == 0)
            throw new IllegalArgumentException("Path to input file expected");

        MedianMaintenance mm = new MedianMaintenance(args[0]);
        System.out.println(mm.sum);
    }

    public int getSum() {
        return sum;
    }

    /**** TEST ****/

    private static final String DATA_DIR = "./data/";
    private static final String[] TESTS = {"Median1", "Median2"};
    private static final long[] EXPECTED = {23, 54};

    @Test
    public void test() throws Exception {
        for (int i = 0; i < TESTS.length; i++) {
            String fileName = DATA_DIR + TESTS[i] + ".txt";
            long actual = new MedianMaintenance(fileName).getSum();
            assertEquals(EXPECTED[i], actual);
        }
    }
}

/**
 * The goal of this problem is to implement the "Median Maintenance" algorithm (covered in the Week 5 lecture
 * on heap applications).
 *
 * The text file contains a list of the integers from 1 to 10000 in unsorted order; you should treat this as a
 * stream of heap, arriving one by one. Letting xi denote the ith number of the file, the kth median mk
 * is defined as the median of the heap x1,…,xk.
 * (So, if k is odd, then mk is ((k+1)/2)th smallest number among x1,…,xk; if k is even,
 * then mk is the (k/2)th smallest number among x1,…,xk.)
 *
 * In the box below you should type the sum of these 10000 medians, modulo 10000 (i.e., only the last 4 digits).
 * That is, you should compute (m1+m2+m3+⋯+m10000)mod10000.
 *
 * OPTIONAL EXERCISE: Compare the performance achieved by heap-based and search-tree-based implementations of the algorithm.
 */