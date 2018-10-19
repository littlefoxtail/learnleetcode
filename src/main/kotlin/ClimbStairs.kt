/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

注意：给定 n 是一个正整数。

示例 1：

输入： 2
输出： 2
解释： 有两种方法可以爬到楼顶。
1.  1 阶 + 1 阶
2.  2 阶
示例 2：

输入： 3
输出： 3
解释： 有三种方法可以爬到楼顶。
1.  1 阶 + 1 阶 + 1 阶
2.  1 阶 + 2 阶
3.  2 阶 + 1 阶
 */
fun climbStairs(n: Int): Int {
  var re = 0
  if (n == 0 || n == 1) {
    return 1
  } else{
    re = climbStairs(n-1) + climbStairs(n-1)
  }
  return re

}

fun climbStairs2(n: Int): Int {
  var localN = n
  var a = 1
  var b = 1
  var re = 0
  if (localN == 1 || localN == 0) {
    return 1
  }
  while (localN > 0) {
    re = a + b
    b = a
    a = re
    localN = localN.dec()
  }
  return re
}

fun main(args: Array<String>) {
  climbStairs2(4)


}