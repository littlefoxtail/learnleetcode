
/**
 * 快速排序
 *
 * 核心是分治法，含义就是取一个基准值（可以是start或者end）,左边的序列都是比它小的，右边的序列都是比它大的(都是无序)。
 * 这里用一个PIndex来记录比它小的序列的最后的Index+1，遍历过程中如果发现有比基准小的值，都会swap PIndex这样，每执行一次循环
 * 0~PIndex都是比基准值小的。循环结束后PIndex还应该与基准值的swap，这样做后左边序列都是比它小，右边都是比它大的。
 * 递归几次就可以得到一个排序结果
 */
public class QuickSort {

  public static <T extends Comparable<T>> void swap(T[] array, int initial, int fin) {
    T temp = array[initial];
    array[initial] = array[fin];
    array[fin] = temp;
  }

  public static void main(String[] args) {
    // For integer input
    int[] arr = {3,4,1,32,20,2,44,111,5};
    Integer[] array = new Integer[arr.length];
    for (int i=0;i<arr.length;i++) {
      array[i] = arr[i];
    }

    QS(array, 0, array.length-1);

    for (int i=0;i<array.length;i++) {
      System.out.print(array[i] + " ");
    }
  }

  public static <T extends Comparable<T>> void QS(T array[], int start, int end) {
    if (start < end) {
      int PIndex = partition(array, start, end);
      QS(array, start, PIndex -1);
      QS(array, PIndex+1, end);
    }
  }

  private static  <T extends Comparable<T>> int partition(T array[], int start,  int end) {
    T pivot = array[end];
    int PIndex = start;

    for(int i = start;i<end;i++) {
      if (array[i].compareTo(pivot) <=0) {
        swap(array, i, PIndex);
        PIndex++;
      }
    }
    swap(array, PIndex, end);

    return PIndex;
  }

}
