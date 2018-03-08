import java.util.HashMap;
import java.util.Map;

/**
 * Question
 *
 * Given an array of integers, return indices of the numbers such that
 * they add up to a specific target
 *
 * 给定一个整数数组，返回两个数字的索引，使它们加起来称为一个特定目标
 *
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Bacause nums[0] + nums[1] = 2 + 7 = 9
 * return [0, 1]
 *
 * 思路0
 * 题意让你从给定的数组中找到两个元素的和为指定的值得两个索引，最容易的当然是循环两次，复杂度为O(n^2)
 *
 * 思路1
 * 利用HashMap作为存储，键为数组的值，值为索引
 *
 */
public class TwoSum {
    public static void main(String[] args) {
        int [] nums = new int[]{2, 7, 11, 15};
        int target = 9;

        int[] ideas0 = ideas0(nums, target);
        //printArray(ideas0);
        int[] ints = onePassHashTable(nums, target);

        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    public static void printArray(int[] array) {
        for (int anArray : array) {
            System.out.println(anArray);
        }
    }

    /**
     * 思路0
     * 时间复杂度 O(n^2)
     * @param nums
     * @param target
     * @return
     */
    public static int[] ideas0(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }


    /**
     * Complexity Analysis
     * Time complexity O(n^2)
     * Space complexity O(1)
     * @param nums
     * @param target
     * @return
     */
    private static int[] bruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == target - nums[j]) {
                    return new int[] {i, j};
                }
            }
        }
        throw new IllegalArgumentException("super boy ba");
    }

    /**
     * 通过hashmap进行运算
     *
     * Time complexity: O(n)
     * Space complexity:O(n)
     *
     *
     * @param nums
     * @param target
     * @return
     */
    private static int[] passHashTable(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int another = target - nums[i];
            if (map.containsKey(another) && map.get(another) != i) {
                return new int[] {i, map.get(another)};
            }
        }
        throw new IllegalArgumentException("super boy ba");
    }

    /**
     * Time complexity : O(n)
     * Space complexity: O(n)
     * @param nums
     * @param target
     * @return
     */
    private static int[] onePassHashTable(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }




}
