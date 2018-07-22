/**
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 *
 * Input:1->2->4, 1->3->4
 * Output:1->1->2->3->4->4
 *
 * Tags:Linked List
 *
 * 题意是用一个新链表来合并两个已排序的链表，只需要从头开始比较已排序的两个链表，新链表指针每次指向值小的节点，依次比较下去，
 * 最后，当其中一个链表到达了末尾，我们只需把新链表指针指向另一个没有到末尾的链表此时的指针即可。
 */
class MergeTwoSortedList {
  class ListNode internal constructor(internal var `val`: Int) {
    internal var next: ListNode? = null

    init {
      next = null
    }
  }


  fun mergeTT(l1: ListNode?, l2: ListNode?): ListNode? {
    var localL1 = l1
    var localL2 = l2
    val head = ListNode(0)
    var tmp: ListNode? = head
    while (localL1 != null && localL2 != null) {
      if (localL1.`val` < localL2.`val`) {
        tmp!!.next = localL1
        localL1 = localL1.next
      } else {
        tmp!!.next = localL2
        localL2 = localL2.next
      }
      tmp = tmp.next
    }
    tmp!!.next = if (localL1 == null) localL2 else localL1
    return head.next

  }

  fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
    if (l1 == null)
      return l2
    else if (l2 == null) return l1
    if (l1.`val` < l2.`val`) {
      l1.next = mergeTwoLists(l1.next, l2)
      return l1
    } else {
      l2.next = mergeTwoLists(l1, l2.next)
      return l2
    }

  }

  fun mergeTwoLists_1(l1: ListNode?, l2: ListNode?): ListNode? {
    if (l1 == null)
      return l2
    if (l2 == null)
      return l1
    val mergeHead: ListNode
    var temp1: ListNode? = null
    var temp2: ListNode? = null
    if (l1.`val` < l2.`val`) {
      mergeHead = l1
      temp1 = l1.next
      temp2 = l2
    } else {
      mergeHead = l2
      temp1 = l1
      temp2 = l2.next
    }
    var temp = mergeHead
    while (temp1 != null && temp2 != null) {
      if (temp1.`val` < temp2.`val`) {

        temp.next = temp1
        temp = temp1
        temp1 = temp1.next
      } else {
        temp.next = temp2
        temp = temp2
        temp2 = temp2.next
      }
    }
    temp.next = if (temp1 == null) temp2 else temp1
    return mergeHead
  }

  companion object {

    @JvmStatic
    fun main(args: Array<String>) {
      val head = ListNode(0)
      val head1 = ListNode(3)
      val head2 = ListNode(8)

      val head3 = ListNode(1)
      val head4 = ListNode(2)
      val head5 = ListNode(7)
      val head6 = ListNode(10)

      head.next = head1
      head1.next = head2

      head3.next = head4
      head4.next = head5
      head5.next = head6

      //0

      //ListNode newHead = new MergeTwoSortedList().mergeTwoLists_1(head, head3);
      var link = MergeTwoSortedList().mergeTT(head, head3)
      while (link != null) {
        println(link.`val`)
        link = link.next
      }
      tableSizeFor(2)

    }


    fun tableSizeFor(cap: Int): Int {
      var n = cap - 1
      n = n or n.ushr(1)
      n = n or n.ushr(2)
      n = n or n.ushr(4)
      n = n or n.ushr(8)
      n = n or n.ushr(16)
      return if (n < 0) 1 else if (n >= 100) 16 else n + 1
    }
  }


}