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

