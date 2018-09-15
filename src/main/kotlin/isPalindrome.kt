fun main(args: Array<String>) {
  isPalindrome(123321)
  println("字符串回文")
  println(isPalindrome2("A man, a plan, a canal: Panama"))
  println(isPalindrome2("race a car"))
  println(isPalindrome2("........."))

  println("回文链表")


  val listNode1 = ListNode(1)
  val listNode2 = ListNode(2)
  val listNode3 = ListNode(3)
  val listNode4 = ListNode(4)
  val listNode5 = ListNode(2)
  val listNode6 = ListNode(1)

  listNode1.next = listNode2
  listNode2.next = listNode3
  listNode3.next = listNode4
  listNode4.next = listNode5
  listNode5.next = listNode6
  isPalindrome3(listNode1)
}

/**
 * 判断一个整数是否是回文，不要使用额外的空间
 *
 * 1. 负数都不是回文数
 * 2. 不能通过将数字转为字符串来判断回文，因为使用了额外的空间
 * 3. 注意整数溢出的问题
 * 4. 这个问题有一个比较通用的解法
 *
 *
 * 形如：123456 获取回文数 654321
 *
 * 12345 6
 * 1234  5
 * 123   4
 * 12    3
 * 1     2
 * 1     1
 *
 * 可以先获取到余数  获取到一个新的值为 余数 + 余数*10
 * 每次商代表一次余数*10
 */
fun isPalindrome(s: Int): Boolean {
  if (s < 0) return false
  var copyX = s
  var reverse = 0
  while (copyX > 0) {
    reverse = reverse * 10 + copyX % 10
    copyX /= 10
  }
  return s == reverse

}

/**
 * 验证回文字符串是比较常见的问题，所谓回文，就是一个正读和反读都一样的字符串，
 * 比如“level”或者“noon”等等就是回文串。
 * 但是这里，加入了空格和非字母数字的字符，增加了些难度，
 * 但其实原理还是很简单：只需要建立两个指针，left和right,
 * 分别从字符的开头和结尾处开始遍历整个字符串，如果遇到非字母数字的字符就跳过，
 * 继续往下找，直到找到下一个字母数字或者结束遍历，如果遇到大写字母，就将其转为小写。
 * 等左右指针都找到字母数字时，比较这两个字符，若相等，则继续比较下面两个分别找到的字母数字，若不相等，直接返回false.
 */
fun isPalindrome2(s: String): Boolean {

  var left = 0
  var right = s.length -1

  while (left < right) {
    while (left < s.length && !isvalid(s[left])) {
      left++
    }
    if (left == s.length) {
      return true
    }
    while (!isvalid(s[right]) && right >= 0) {
      right--
    }

    if (s[left].toLowerCase() != s[right].toLowerCase()) {
      break
    } else{
      left++
      right--
    }
  }
  return right <= left
}

private fun isvalid(c: Char): Boolean {
  return Character.isLetter(c) || Character.isDigit(c)
}

fun isPalindrome3(head: ListNode?): Boolean {

  if((head == null) or (head?.next == null)) {
    return true
  }

  val middle = findMiddle(head)
  middle?.next = reverseList(middle?.next)

  var p = head
  var q = middle?.next
  while (p != null && q != null && p.`val` == q.`val`) {
    p = p.next
    q = q.next
  }
  return q == null
}

///**
// * 原地反转链表
// */
//fun reverseList(head: ListNode?): ListNode? {
//  var localHead = head
//  var prev: ListNode? = null
//  while (localHead != null) {
//    var temp = localHead.next
//    localHead.next = prev
//    prev = localHead
//    localHead = temp
//  }
//
//  return prev
//}
fun isPalindrome4(head: ListNode?): Boolean {
  var head = head
  if (head?.next == null)
    return true
  var fast = head
  var slow = head
  while (fast!!.next != null && fast.next!!.next != null) {
    slow = slow!!.next
    fast = fast.next!!.next
  }
  var reverseHead = reverseList(slow!!.next)

  while (head != null && reverseHead != null) {
    if (head.`val` != reverseHead.`val`)
      return false
    head = head.next
    reverseHead = reverseHead.next
  }
  return true
}

fun reverseList(head: ListNode?): ListNode? {
  var head = head
  if (head?.next == null)
    return head
  var p: ListNode? = null
  var q: ListNode?
  while (head != null) {
    q = head.next
    head.next = p

    p = head
    head = q
  }
  return p
}

fun findMiddle(head: ListNode?): ListNode? {

  if ((head == null) or  ((head?.next) == null)) {
    return head
  }

  var slow = head
  var fast = head

  while(fast?.next != null && fast.next?.next != null){
    slow = slow?.next
    fast = fast.next?.next
  }

  return slow

}
