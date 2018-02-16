import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 线性搜索或顺序搜索是一种寻找某一特定值的搜索算法，指按一定的顺序检查数组每一个元素，直到
 * 找到所要寻找的特定值为止。是最简单的一种搜索算法。
 */
public class LinearSearch {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    Integer[] myArray;
    int size = 0;

    System.out.println("Enter the array size:");
    size = Integer.parseInt(br.readLine());
    myArray = new Integer[size];

    for (int i = 0; i < size; i++) {

      System.out.print("For index " + i + ", enter an integer: ");
      myArray[i] = Integer.parseInt(br.readLine());
    }

    //Prompt user to search for particular element
    System.out.print("Enter integer to search for: ");
    Integer key = Integer.parseInt(br.readLine());

    //Output array and index of target element, if found
    System.out.printf("The integer %d is found in index %d\n", key, linearSearch(myArray, key));

    // Test for String inputs
    String[] myArray1;
    int size1 = 0;

    //Prompt user to create array and its elements
    System.out.print("Enter the array size: ");
    size1 = Integer.parseInt(br.readLine());
    myArray1 = new String[size1];
    for (int i = 0; i < size1; i++){
      System.out.print("For index " + i + ", enter a String: ");
      myArray1[i] = br.readLine();
    }

    //Prompt user to search for particular element
    System.out.print("Enter String to search for: ");
    String key1 = br.readLine();

    //Output array and index of target element, if found
    System.out.printf("The string %s is found in index %d\n", key1, linearSearch(myArray1, key1));
  }

  public static <T extends Comparable<T>> int linearSearch(T[] array, T value) {
    int lo = 0;
    int hi = array.length - 1;
    for (int i = lo; i <= hi ; i++) {
      if (array[i].compareTo(value) == 0) {
        return i;
      }
    }
    return -1;
  }
}
