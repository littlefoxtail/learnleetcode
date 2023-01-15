package base

class ListNode(var `val`: Int = 0) {
    var next: ListNode? = null

    override fun toString(): String {
        return "ListNode(value=$`val`', next=$next)"
    }

    companion object {

        @JvmStatic
        fun testListNode(): ListNode {

            val head = ListNode(0)
            val head1 = ListNode(3)
            val head2 = ListNode(8)
            val head3 = ListNode(1)
            val head4 = ListNode(2)
            val head5 = ListNode(7)
            val head6 = ListNode(10)

            head.next = head1
            head1.next = head2
            head2.next = head3
            head3.next = head4
            head4.next = head5
            head5.next = head6

            return head

        }

        @JvmStatic
        fun print(link: ListNode?) {
            var curr: ListNode? = link
            while (curr != null) {
                println(curr.`val`)
                curr = curr.next
            }
        }
    }
}