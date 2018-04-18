/**
 * 写一个函数来寻找一个字符串数组中最长公共前缀。
 * "abcdefg"
 * "abcdefghijk"
 * "abcdfghijk"
 * "abcef"
 *
 * 上面字符串数组的最长公共前缀就是"abc"
 *
 * 找出最短的那个字符串
 * 然后从index=0开始查找，如果找到有相同位的字符不相等的，就截取0~当前位置(因为取头部取尾)
 *
 * 如果循环完成都没有找到，这说明最短那个字符串就是最长前缀
 */
object LongestCommonPrefix {
  @JvmStatic
  fun main(args: Array<String>) {
    val common = longestCommonPrefix(arrayOf("abcdefg", "abcdefghijk", "abcdfghijk", "abcef"))

    println(common)
  }

  private fun longestCommonPrefix(strs: Array<String>): String {
    val len = strs.size
    if (len == 0) {
      return ""
    }
    var minLen = 0x7fffffff
    for (str in strs) {
      minLen = Math.min(minLen, str.length)
    }
    for (j in 0 until minLen) {
      for (i in 0 until len) {
        if (strs[0][j] != strs[i][j]) {
          return strs[0].substring(0, j)
        }
      }
    }
    return strs[0].substring(0, minLen)
  }
}

