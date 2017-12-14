/**
 * Given an array and a value, remove all instances of that value in-place and return the new length
 *
 * Do not allocate extra space for another array
 * you must do this by modifying the input array in-place with O(1) extra
 * memory
 *
 * the order of elements can be changed. it doesn't matter what you leave beyond the length.
 *
 * Given nums = [3, 2, 2, 3], val = 3
 * 题意
 * 移除数组中值等于val的值，并返回之后数组的长度，并且题目中指定空间复杂度O(1),
 * 是用 tail 标记尾部，遍历该数组时当索引元素不等于 val 时，tail 加一，尾部指向当前元素，最后返回 tail 即可
 */
public class RemoveElement {

  public static void main(String[] args) {
    int nums[] = new int[] {2, 2, 3, 2, 4 };

    int length = removeElement(nums, 2);

    //System.out.println("length:" + length);
    //printArray(nums);

  }

  public static void printArray(int[] array) {
    for (int anArray : array) {
      System.out.print(anArray + " ");
    }
    System.out.println();
  }

  public static int removeElement(int[] nums, int val) {
    int tail = 0;
    for (int i = 0, len = nums.length; i < len;  i++) {
      if (nums[i] != val) {
        nums[tail++] = nums[i];
      }
      printArray(nums);
    }
    return tail;
  }
}
