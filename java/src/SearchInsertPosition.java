/**
 * Given a sorted array and a target value,
 * return the index if the target is found.
 * if not,return the index where it would be if it where inserted in order
 *
 * Input: [1, 3, 5, 6], 5
 * Output: 2
 *
 * Input: [1, 3, 5, 6], 2
 * Output: 1
 *
 * Input: [1, 3, 5, 6], 7
 * Output: 4
 *
 * Input: [1, 3, 5, 6], 0
 * Output: 0
 *
 * 题意让你从一个没有重复元素的已排序数组中找到插入位置的索引。因为数组已排序，所以使用二分查找法，因为查找到的条件是找到第一个
 * 等于或者大于target的元素的位置
 *
 *
 *
 */
public class SearchInsertPosition {


  public static void main(String[] args) {
    int nums[] = new int[] {1, 3, 5, 6};
    System.out.println(searchInsert(nums, 7));
  }

  public static int searchInsert(int[] nums, int target) {
    int left = 0, right = nums.length - 1, mid = (right + left) >> 1;

    while (left <= right) {
      if (target <= nums[mid]) right = mid - 1;
      else left = mid + 1;
      mid = (right + left) >> 1;
    }
    return left;
  }
}
