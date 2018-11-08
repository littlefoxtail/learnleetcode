# 已知两个单链表均已递增有序，试将它们合并成一个链表，保持其有序性
from common import ListNode

class Solution(object):
    def mergeTwoLists(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        curr = dummy = ListNode(0)
        while l1 and l2: # l1和l2都不为空
            if l1.val < l2.val:
                curr.next = l1
                l1 = l1.next
            else:
                curr.next = l2
                l2 = l2.next
            curr = curr.next
        curr.next = l1 or l2
        return dummy.next


if __name__ == "__main__":
    l1 = ListNode(0)
    l1.next = ListNode(1)
    l2 = ListNode (2)
    l2.next = ListNode(3)
    print(Solution().mergeTwoLists(l1, l2))
        