/**
 * Given a sorted array, removed the duplicates in-place such that each  element appear
 * only once and return the new length.
 * Do not allocate extra space for another array, you must do the by modifying the input
 * array in-place with O(1) extra memory
 *
 * in-place 原地算法，基本上一种不需要附件数据结构，附件变量允许有小的额外空间来转换数据的算法。
 *  Give nums = [1, 1, 2]
 *
 *  思路
 *  题意是从有序的数组中移除重复的元素，并返回之后数组的长度。判断长度小于等于1就返回原长度
 *  否则遍历一遍数组，用一个tail变量指向尾部，如果后面的元素和前面的不同，就让tail变量加1
 */
public class RemoveDuplicatesFromSortedArray {

  public static void main(String[] args) {
    int nums[] = new int[] {1, 2, 3, 3, 4, 5 };

    int length = removeDuplicates(nums);

    //System.out.println("length=>" + length);
    //printArray(nums);

  }

  //public static void printArray(int[] array) {
  //  for (int anArray : array) {
  //    System.out.println(anArray);
  //  }
  //}

  public static int removeDuplicates(int[] nums) {
    int len = nums.length;
    if (len <= 1) return len;
    int tail = 1;

    for (int i = 1; i < len; i++) {
      if (nums[i -1] != nums[i]) {
        nums[tail++] = nums[i];
      }
      Utils.printArray(nums);
    }

    return tail;

  }

}
