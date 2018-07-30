object ReverseList {
  @JvmStatic
  fun main(args: Array<String>) {
    val listNode1 = ListNode(1)
    val listNode2 = ListNode(2)
    val listNode3 = ListNode(3)
//    val listNode4 = ListNode(4)
//    val listNode5 = ListNode(5)
//    val listNode6 = ListNode(6)

    listNode1.next = listNode2
    listNode2.next = listNode3
//    listNode3.next = listNode4
//    listNode4.next = listNode5
//    listNode5.next = listNode6

//    println(reverseList1(listNode1))
    println(reverseList2(listNode1))
  }

  private fun reverseList1(head: ListNode?): ListNode? {
    val localHead: ListNode?
    var curr: ListNode? = head
    var prev: ListNode? =  null

    while (curr != null) {
      val temp = curr.next

      curr.next = prev

      prev = curr
      curr = temp
    }
    localHead = prev
    return localHead
  }

  private fun reverseList2(head: ListNode?): ListNode? {
    if (head == null) return head
    if (head.next == null) return head

    val newHead: ListNode? = reverseList2(head.next)

    head.next?.next = head


    head.next = null

    return newHead

  }
}