"""
给定两个大小为m和n的有序数组 nums1和nums2
请你找出这两个有序数组的中位数，并且要求算法的时间复杂度O(log(m+n))
可以假设nums1和nums2不能同时为空
示例 1:

nums1 = [1, 3]
nums2 = [2]

则中位数是 2.0
示例 2:

nums1 = [1, 2]
nums2 = [3, 4]

则中位数是 (2 + 3)/2 = 2.5

"""
class Solution:
    # 将一个集合划分为两个长度相等的子集，其中一个子集中的元素总是大于另一个子集中的元素
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """


