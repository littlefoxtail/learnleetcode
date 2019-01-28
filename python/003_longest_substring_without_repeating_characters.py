
"""
给定一个字符串，请找出其中不含有重复字符的最长字串的长度
示例 1:
    输入: "abcabcbb"
    输出: 3 
    解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:
    输入: "bbbbb"
    输出: 1
    解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:
    输入: "pwwkew"
    输出: 3
    解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
        请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。

"""
import json
class Solution:
    # 时间复杂度：O(N)
    # 空间复杂度：O(N)
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        先从一个字符开始，只要碰到已经出现过的字符就必须从之前出现该字符的index开始重新往后看
        怎么判断字符以及出现过了呢，使用一个hashmap，将每一个已经阅读过的字符作为键，而它的值就是它在源字符串中的
        index
        """
        l, start, n = 0, 0, len(s)
        maps = {}
        for i in range(n):
            # maps 放置每一个字符的index，如果maps.get(s[i], -1)大于等于start的话，就说明字符重复了，此时就要重置 l(字母L) 和start的值了，
            # l代表目前最大字串的长度
            # start 是这一轮未重复字串首字母的index
            # maps 放置一个每一个字符的index，如果map.get(s[i], -1)大于等于start的话，就说明字符重复了
            # 此时就要重置l和start的值了
            print('before start: %s' % {start})
            print('map get: %s' % {maps.get(s[i], -1)+1})
            start = max(start, maps.get(s[i], -1)+1)
            print('after start: %s' % start)
            print('i: %s' % i)
            print('i- start+1: %s' % {i-start+1})
            l = max(l, i - start+1)
            print('l: %s' % {l})
            maps[s[i]] = i
            print("map: " + json.dumps(maps))
            print('-----------------')
        return l

if __name__ == "__main__":
    Solution().lengthOfLongestSubstring("abcdefcdefghijklmn")
