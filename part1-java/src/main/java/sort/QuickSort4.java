package sort;

/**
 * Quick sort implementation with pivot in last element
 * @author ahalikov
 */
class QuickSort4 {

    public static int[] sort(int[] a) {
        if (a == null)
            throw new IllegalArgumentException("a is null");
        if (a.length > 0) {
            sort(a, 0, a.length);
        }
        return a;
    }

    private static void sort(int[] a, int lo, int hi) {
        if (lo < hi) {
            int pIndex = partition(a, lo, hi);
            sort(a, lo, pIndex);
            sort(a, pIndex + 1, hi);
        }
    }

    /**
     * Array partitioning
     * @param a input array
     * @param lo index from
     * @param hi index to
     * @return pivot after partitioning
     */
    private static int partition(int[] a, int lo, int hi) {
        int pIndex = lo, pivot = a[hi-1];
        for (int i = lo; i < hi-1; i++) {
            if (a[i] <= pivot) {
                swap(a, i, pIndex);
                pIndex++;
            }
        }
        swap(a, pIndex, hi-1);
        return pIndex;
    }

    private static void swap(int[] a, int i, int j) {
        int buffer = a[i];
        a[i] = a[j];
        a[j] = buffer;
    }
}
