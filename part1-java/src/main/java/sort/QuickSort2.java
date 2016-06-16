package sort;

import toolkit.utils.InputFile;

/**
 * Quick sort algorithm implementation
 * Pivot - last element of input array
 *
 * @author: Artur Khalikov
 */
class QuickSort2 {
  public static int comparisons;

  public static void sort(int[] a) {
    if (a == null)
      throw new IllegalArgumentException("Input array is null");
    if (a.length > 1) {
      comparisons = 0;
      sort(a, 0, a.length);
    }
  }

  private static void sort(int[] a, int lo, int hi) {
    if (hi - lo > 1) {
      comparisons += hi - lo - 1;
      swap(a, hi - 1, lo);
      int j = partition(a, lo, hi);
      sort(a, lo, j - 1);
      sort(a, j, hi);
    }
  }

  private static int partition(int[] a, int lo, int hi) {
    int pivot = a[lo];
    int i = lo + 1, j;
    for (j = lo + 1; j < hi; j++) {
      if (a[j] < pivot) {
        swap(a, j, i);
        i++;
      }
    }
    swap(a, lo, i - 1);
    return i;
  }

  private static void swap(int[] a, int i, int j) {
    int save = a[i];
    a[i] = a[j];
    a[j] = save;
  }

  public static void main(String[] args) {
    if (args.length == 0)
      throw new IllegalArgumentException("Input file name expected");
    int[] a = new InputFile(args[0]).getIntegerArray();
    assert a.length != 0 : "array is empty";
    sort(a);
    System.out.println("Input array length=" + a.length);
    System.out.println("Comparisons: " + comparisons);
  }
}
