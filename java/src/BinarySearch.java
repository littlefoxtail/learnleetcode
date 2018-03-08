import java.util.Scanner;

public class BinarySearch {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    Integer[] array = new Integer[10];

    int key = 5;
    for (int i = 0; i < 10; i++) {
      array[i] = i+1;
    }

    int index = BS(array, key, 0, 10);

    if (index != -1)
      System.out.println("Number " +  key + " found at index number : " + index);
    else
      System.out.println("Not found");


  }

  public static <T extends Comparable<T>> int BS(T array[], T key, int lb, int rb) {
    if (lb > rb) {
      return -1;
    }

    int mid = (lb + rb) >>>1;

    int comp = key.compareTo(array[mid]);

    if (comp < 0) {
      return BS(array, key, lb, mid -1);
    }

    if (comp > 0) {
      return BS(array, key, mid + 1, rb);
    }
    return mid;
  }
}
