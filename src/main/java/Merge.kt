/**
 * 合并两个有序数组
给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。

说明:

初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
示例:

输入:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

输出: [1,2,2,3,5,6]
 */
object Merge {
  @JvmStatic
  fun main(args: Array<String>) {
    val num1 = intArrayOf(1, 2, 3, 4, 5, 100, 0, 0, 0)
    val num2 = intArrayOf(2, 5, 6)

    merge(num1, 6, num2, 3)

    show(num1)


  }

  private fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
    val array = Array(m + n) {0}
    var i = m - 1
    var j = n - 1
    while (i >= 0 && j >= 0) {
      if (nums1[i] > nums2[j]) {
        nums1[i + j + 1] = nums1[i--]

      } else{
        nums1[i + j + 1] = nums2[j--]
      }
    }

    while (i >= 0) {
      array[i + j + 1] = nums1[i--]
    }

    while (i >= 0) {
      array[i + j + 1] = nums2[j--]
    }
  }

  private fun show(a: IntArray) {
    for (i: Int in a.indices) {
      println(a[i])
    }
  }
}