/**
 * 删除链表中倒数第n个元素，利用双指针，已知n，可以确定一个指针是n，另一个指针是head
 * 两个指针同时循环平移到倒数第二，然后就可以进行删除元素，如果出现不合理的输入，就删除head
 *
 *
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {val = x;}
 * }
 *
 *
 */
object RemoveNthFromEnd {
  @JvmStatic
  fun main(args: Array<String>) {
    val listNode1 = ListNode(1)
    val listNode2 = ListNode(2)
    val listNode3 = ListNode(3)
    val listNode4 = ListNode(4)
    val listNode5 = ListNode(5)
    val listNode6 = ListNode(6)

    listNode1.next = listNode2
    listNode2.next = listNode3
    listNode3.next = listNode4
    listNode4.next = listNode5
    listNode5.next = listNode6

    println(removeNthFromEnd(listNode1, 2))
  }

  private fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
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