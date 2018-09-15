/**
 * /**
 * 报数序列是指一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 被读作  "one 1"  ("一个一") , 即 11。
11 被读作 "two 1s" ("两个一"）, 即 21。
21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。

给定一个正整数 n ，输出报数序列的第 n 项。

注意：整数顺序将表示为一个字符串。

示例 1:

输入: 1
输出: "1"
示例 2:

输入: 4
输出: "1211"
*/
 */
fun main(args: Array<String>) {
  println(countAndSay(5))
  println(countAndSay(4))
}

/**
 * 这道题基本上就是一个模拟的题目,不断遍历字符串，每一次遍历一个新的字符的时候看后面有多少字符是跟前面的一样的。
 * 这样相当于按照相同的字符一层一层的遍历而不是一个字符一个字符的遍历。
 */
fun countAndSay(n: Int): String {
  var localN = n
  var oldString = "1"
  while (--localN > 0) {
    val sb = StringBuilder()
    val oldChars = oldString.toCharArray()
//    for(i in 0 until oldChars.size) {
    var i = 0
    while (i < oldChars.size) {
      var count = 1
      while ((i + 1) < oldChars.size && oldChars[i] == oldChars[i + 1]) {
        count++
        i++
      }
      sb.append(count.toString() + oldChars[i].toString())
      i++
    }
    oldString = sb.toString()
//    }

  }
  return oldString
}