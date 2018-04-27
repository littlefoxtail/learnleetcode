# 数组

## 只出现一次的数字
给定一个整数数组，除了某个元素外其余元素均出现两次。请找出这个只出现一次的元素

答题思路：一个数组中除了一个元素，其他元素都出现两次，所以可以使用位运算异或来实现，因为相同的元素进行异或其结果为0

```java
class Solution {
    public int singleNumber(int[] nums) {
        int num = 0;
        for(int i = 0; i < nums.length; i++) {
            num ^= nums[i];
        }
        return num;
    }
}
```

## 从排序数组中删除重复项
给定一个有序数组，需要原地删除其中重复内容，使每个元素只出现一次，并返回新的长度
不要另外定义一个数组，必须通过O(1)额外内存原地修改输入的数组来做到这一点

```java
class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len <= 1) return len;
        int tail = 1;
        for (int i = 1; i <len; i++) {
            if(nums[i-1] != nums[i]) {
                nums[tail++] = nums[i];
            }
        }
        return tail;
    }
}
```

## 两数之和
给定一个整数数列，找出其中和为特定值的那两个数
- 示例：
```
给定nums = [2, 7, 11, 15], target = 9
因为nums[0] + nums[1] = 2 + 7 = 9
所以返回[0, 1]
```

答题思路：
1. 第一次遍历数组先将所有元素和它的下标作为key-value对存入HashMap中，第二次遍历数组根据目标和与当前元素只差，在HashMap中找相应的差值
2. 如果存在该差值，说明存在两个数之和是目标和。

```java
class Solution {
   public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i = 0; i < nums.length; i++) {
            int com = target - nums[i];
            if (map.containsKey(com)) {
                return new int[] {map.get(com), i};
            }
            map.put(nums[i], i);
            
        }
        return new int[2];
    }
}
```
## 两个数组的交集
给定两个数组，写一个方法来计算它们的交集
例如：
给定nums1 = [1, 2, 2, 1], nums2 = [2, 2]，返回[2, 2]
注意：
- 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致
- 可以不考虑输出结果的顺序
```java
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
       HashMap<Integer, Integer> hash = new HashMap<>();

       for(int i = 0; i < nums1.lenght; i++) {
           hash.put(nums1[i], hash.getOrDefault(num, 0) + 1);
       }

       ArrayList<Integer> array = new ArrayList<>();
       for(int num: nums2) {
           if (hash.containKey(num) && hash.get(num) != 0) {
               array.add(num);
               hash.put(num, hash.get(num) - 1);
           }
       }
       int [] resultArray = new int[result.size()];
       int index = 0;
       for (int item : result) {
           resultArray[index++] = item;
       }
       return resultArray;
    }
}
```

## 加一
给定一个非负整数组成的非空数组，给整数加1
可以假设整数不包含任何前导零，除了数字0本身
最高位数字存放在列表的首位

```java
class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return digits;
        }
        int carry = 1;
        for (int i = digits.length -1; i >= 0; i--) {
            int digit = (digits[i] + carry) % 10;
            carry = (digits[i] + carry) / 10;
            digits[i] = digit;
            if (carry == 0) {
                return digits;
            }
            
        }
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }
}
```

## 存在重复
给定一个整数数组，判断是否存在重复元素
如果任何值在数组中出现至少两次，函数应该返回true。如果每个元素都不相同，则返回false
```java
class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : nums) {
            if (map.containsKey(n)) {
                return true;
            }
            map.put(n, 0);
        }
        return false;
    }
}
```

# 字符串
## 反转字符串
编写一个函数，其功能是将输入的字符串反转过来
```kotlin
class Solution {
    fun reverseString(s: String): String {
        val byteArray = s.toCharArray()
        var result = ""
        for (i in byteArray.size-1 downTo 0) {
        result += byteArray[i]

        }
        return result
    }
}
```

## 颠倒整数
给定一个32位有符号整数，将整数中的数字进行反转
示例 1:

输入: 123
输出: 321
 示例 2:

输入: -123
输出: -321
示例 3:

输入: 120
输出: 21
注意:

假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31,  2^31 − 1]。根据这个假设，如果反转后的整数溢出，则返回 0。
```kotlin
class Solution {
    fun reverse(x: Int): Int {
        var x1: Long = x.toLong()
        var res = 0L

        while (x1 != 0L) {
        res = res * 10L + x1 % 10L
        x1 /= 10
        }

        return if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) 0 else res.toInt()
    }
}
```

## 字符串中的第一个唯一字符
给定一个字符串，找到它的第一个不重复字符，并返回它的索引。如果不存在则返回-1
案例：
```
s = "leetcode"
返回 0.

s = "loveleetcode",
返回 2.
```
注意事项：您可以假定该字符串只包含小写字母。

```kotlin
class Solution {
    fun firstUniqChar(s: String): Int {
        val map = HashMap<Char, Int>()
        val list = ArrayList<Int>()

        for (i in 0 until s.length) {
        if (map.containsKey(s[i]))
            map[s[i]] = Int.MAX_VALUE
        else
            map[s[i]] = i
            list.add(i)

        }

        for (i in 0 until list.size) {
            if (map[s[list[i]]] != Int.MAX_VALUE) {
                return list[i]
            }
        }
        return -1
    }
}
```
## 最长公共前缀
编写一个函数来查找字符串数组中的最长公共前缀
如果不存在最长公共前缀，返回空字符串""

```koltin
class Solution {
    fun longestCommonPrefix(strs: Array<String>) {
        val len = strs.size
        if (len == 0) {
            return ""
        }
        val minLen = 0x7fffffff
        for (str in strs) {
            minLen = Math.min(minLen, str.length)
        }

        for(j in 0 until minLen) {
            for(i in 0 until minlen) {
               if (strs[0][j] != strs[i][j]) {
                   return strs[0].subString(0, j)
               }
            }
        }
        return strs[0].subString(0, minLen)
    }
}
```

## 有效的字母异味词
给定两个字符串s和t，编写一个函数来判断t是否是s的一个字母异位词
s = "anagram"，t = "nagaram"，返回 true
s = "rat"，t = "car"，返回 false

注意:
假定字符串只包含小写字母。

提升难度:
输入的字符串包含 unicode 字符怎么办？你能能否调整你的解法来适应这种情况？
```kotlin
class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) {
            return false
        }
        val t1 = StringBuilder(t)
        for (i in 0 until s.length) {
        var found = false
        for (j in 0 until t1.length) {
            if (s[i] == t1[j]) {
                t1[j] = '0'
                found = true
                break
            } else {
                found = false
            }
        }

        if (!found) {
            return false
        }


        }
        return true

    }
}
```

## 链表
### 删除链表的倒数第N个节点
给定一个链表，删除链表的倒数第n个节点，并且返回链表的头结点
示例：
```
给定一个链表： 1->2->3->4->5，和n = 2
当删除了倒数第二个节点后，链表变为1->2->3->5
```
说明：
给定的n保证是有效的
进阶：
你能尝试使用一趟扫描实现吗？
```kotlin
/**
 *Definition for singly-linked list.
 * class ListNode(var `val`: Int = 0) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var localN = n
        var pre = head
        var afterPreN: ListNode? = head

        while (localN-- != 0) {
        afterPreN = afterPreN!!.next
        }
        if (afterPreN != null) {
        while (afterPreN!!.next != null) {
            pre = pre?.next
            afterPreN = afterPreN.next
        }
        pre?.next = pre?.next?.next
        } else {
        return head?.next
        }
        return head
    }
}
```

### 反转链表
反转一个单链表
进阶：
链表可以迭代或递归地反转。你能够两个都实现一遍
```kotlin
class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        if (head == null) return head
        if (head.next == null) return head

        val newHead: ListNode? = reverseList2(head.next)

        head.next?.next = head


        head.next = null

        return newHead
    }
}
```

