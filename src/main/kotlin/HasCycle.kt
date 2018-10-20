/**
 * 给定一个链表，判断链表中是否有环
 * 进阶：能否不使用额外空间解决此题
 *
 */
fun hasCycle(head: ListNode) : Boolean {
  var slow: ListNode? = head
  var fast = head.next
  while (fast?.next != null) {
    fast = fast.next?.next
    slow = slow?.next
    if (fast == slow) {
      return true
    }
  }
  return false

}