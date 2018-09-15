/**
 * 是从主串中找到子串的索引，如果找不到则返回-1，当字符串长度大于主串，直接返回-1
 */
fun main(args: Array<String>) {
  val haystack = "hello"
  val needle = "lo"
  println(strStr(haystack, needle))
}

/**
 * 实现 strStr() 函数。

给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。

示例 1:

输入: haystack = "hello", needle = "ll"
输出: 2
示例 2:

输入: haystack = "aaaaa", needle = "bba"
输出: -1
说明:

当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。

对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 */
fun strStr(haystack: String, needle: String): Int {
//  暴力的算法，haystack长度为n needle为m 总共有n-m + 1字串，
  if (needle.length > haystack.length) {
    return -1
  }

  for (i in 0..haystack.length - needle.length) {
    var successFlag = true
    for (j in 0 until needle.length) {
      if (haystack[i+j] != needle[j]) {
        successFlag = false
        break
      }
    }
    if (successFlag)
      return i
  }
  return -1
}

fun strStr2(haystack: String, needle: String): Int {
  val l1 = haystack.length
  val l2 = needle.length
  if (l1 < l2) return -1
  var i = 0
  while (true) {
    var j = 0
    while (true) {
      if (j == l2) return i
      if (i + j == l1) return -1
      if (haystack[i + j] != needle[j]) {
        break

      }
      j++

    }
    i++

  }
}