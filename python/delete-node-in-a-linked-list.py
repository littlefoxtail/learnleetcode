
from list_node import ListNode
class Solution:
    def deleteNode(self, node):
        if node and node.next:
            node_to_delete = node.next
            node.val = node_to_delete.val
            node.next = node_to_delete.next
            del node_to_delete

if __name__ == "__main__":
    l1 = ListNode(0)
    de = l1.next = ListNode(1)
    de2 = l1.next.next = ListNode (2)
    l1.next.next.next = ListNode(3)
    print(Solution().deleteNode(de2))
    print(l1)