"""
给定一个字符串s，找到s中最长的回文字串，你可以假设s的最大长度为1000
示例 1：
输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。

示例 2：
输入: "cbbd"
输出: "bb"
"""

class Solution:
    """
    时间复杂度：
    空间复杂度：
    """
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        n = len(s)
        if n < 2:
            return s
        # 目标字串的左index
        l = 0
        # 目标字串的右index
        r = 0
        # 当前最长的回文长度
        m = 0
        # 字串的长度
        c = 0
        b = True
        for i in range(n):
            for j in range(min(n-1,i+1)):
                if s[i-j] != s[i+j]:
                    b = False
                    break
                else:
                    c = 2 * j + 1
