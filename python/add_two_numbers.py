"""
给出两个非空的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式存储
并且它们的每个节点只能存储一位数字。

如果，将这两个数相加起来，则会返回一个新的链表来表示它们的和
可以假设除数字0之外，这两个数都不会以0开头

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
"""

from ListNode import ListNode 
class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """
        使用遍历跟踪进位，并从包含最低有效位的表头开始模拟逐位相加的过程

        伪代码如下：

        * 将当前结点初始化为返回列表的哑结点。
        * 将进位 carrycarry 初始化为 00。
        * 将 pp 和 qq 分别初始化为列表 l1l1 和 l2l2 的头部。
        * 遍历列表 l1l1 和 l2l2 直至到达它们的尾端。
            * 将 xx 设为结点 pp 的值。如果 pp 已经到达 l1l1 的末尾，则将其值设置为 00。
            * 将 yy 设为结点 qq 的值。如果 qq 已经到达 l2l2 的末尾，则将其值设置为 00。
            * 设定 sum = x + y + carrysum=x+y+carry。
            * 更新进位的值，carry = sum / 10carry=sum/10。
            * 创建一个数值为 (sum \bmod 10)(summod10) 的新结点，并将其设置为当前结点的下一个结点，然后将当前结点前进到下一个结点。
            * 同时，将 pp 和 qq 前进到下一个结点。
        * 检查 carry=1 是否成立，如果成立，则向返回列表追加一个含有数字 11 的新结点。
        * 返回哑结点的下一个结点。
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """

    def addTwoNumbers2(self, l1, l2):
        """
        使用递归，每次算一位的相加
        """
        if not l1:
            return l2
        if not l2:
            return l1
        
        if l1.val + l2.val < 10:
            l3 = ListNode(l1.val + l2.val)
            l3.next = self.addTwoNumbers2(l1.next, l2.next)
        else:
            l3 = ListNode(l1.val + l2.val - 10)
            tmp = ListNode(1)
            tmp.next = None
            l3.next = self.addTwoNumbers2(l1.next, self.addTwoNumbers2(l2.next, tmp))
        return l3
if __name__ == "__main__":
    l1 = ListNode(2)
    l1.next = ListNode(4)
    l1.next.next = ListNode(3)

    l2 = ListNode(5)
    l2.next = ListNode(6)
    l2.next.next = ListNode(4)

    print(l1)
    print(l2)
    print(Solution().addTwoNumbers2(l1, l2))