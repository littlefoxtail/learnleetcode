/**
 * 插入排序的基本思路(从小往大)
 *
 * 在原有序列的基础上，从头开始建立有序序列，每次取一个元素，从后面往前面比较(比较的排好序的队列)，如果比已经排好序的序列元素要小，则每次都移动一下排序的元素。
 * 直到判断条件不成立(到达头部 和 比排序队列要大)，最后还要将这个取出元素放到相应的位置(这个位置需要注意，别放错地了)
 */
public class InsertionSort {
  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    int[] arr1 = {4,23,6,78,1,54,231,9,12};
    int last = arr1.length;
    Integer[] array = new Integer[arr1.length];
    for (int i=0;i<arr1.length;i++) {
      array[i] = arr1[i];
    }
    IS(array, last);

    // Output => 1 4 6 9 12 23 54 78 231
    for (int i=0;i<array.length;i++) {
      System.out.print(array[i] + " ");
    }
    System.out.println();
  }

  public static <T extends Comparable<T>> void IS(T array[], int last) {
    T key;

    for (int j = 1; j < last; j++) {
      key = array[j];
      int i = j - 1;
      while (i>=0 && key.compareTo(array[i]) < 0) {
        array[i+1] = array[i];
        --i;
      }
      array[i+1] = key;
    }

  }
}
