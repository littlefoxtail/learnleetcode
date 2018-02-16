/**
 * 选择排序,基本想法就是分为已排好序和未排好序列，每次从未排好序列中取出最小的值，放入已排好序序列的末尾
 */
public class SelectionSort {
  public static void main(String[] args) {
    // Integer Input
    int[] arr1 = {4,23,6,78,1,54,231,9,12};
    int n = arr1.length;

    Integer[] array = new Integer[n];
    for (int i=0;i<n;i++) {
      array[i] = arr1[i];
    }

  }

  public static <T extends Comparable<T>> void SS(T[] arr, int n) {
    for (int i = 0; i < n - 1; i++) {
      int min = i;

      for (int j = i+1; j < n; j++) {
        if (arr[j].compareTo(arr[min]) < 0) {
          min = j;
        }
      }

      if (min != i) {
        T temp = arr[i];
        arr[i] = arr[min];
        arr[min] = temp;
      }
    }
  }
}
