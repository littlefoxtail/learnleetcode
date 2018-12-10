
"""
给定一个整数数组nums和一个目标值target，请你在该数组中找出和未目标值的那两个整数，
并返回它们的数组下标。

"""
class Solution(object):
    def twoSum(self, nums, target):
        """
        暴力解法，两轮遍历
        时间复杂度：O(n^2)，对于每个元素，试图通过遍历数组的其余部分来寻找它所对应的目标元素，
        这将耗费O(n)的时间。因此时间复杂度为O(n^2)
        空间复杂度：O(1)
        """
        for i in range(len(nums)):
            for j in range(len(nums)):
                if nums[i] + nums[j] == target:
                    return [i, j]

    def twoSum2(self, nums, target):
        lookup = {}
        for i, num in enumerate(nums):
            lookup[num] = i

        for i, num in enumerate(nums):
            complement = target - nums[i]
            if (complement in lookup) and lookup[complement] != i:
                return [complement, i]
                

    def twoSum3(self, nums, target):
        """
        在迭代并将元素插入到表中的同时，，还是会回过头来检查表中
        是否已经存在存在当前元素所对应的目标元素。如果它存在，就立即返回
        """
        lookup = {}
        for i, num in enumerate(nums):
            if target - num in lookup:
                return [lookup[target - num], i]
            else:
                lookup[num] = i

if __name__ == "__main__":
    nums = [2, 7, 11, 15]
    target = 9
    print(Solution().twoSum2(nums, target))