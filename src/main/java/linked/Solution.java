package linked;

import base.ListNode;
import lombok.val;

import java.util.List;

class Solution {
    public static ListNode reverseList_0206(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;


        while (curr != null) {
            ListNode next = curr.getNext();
            curr.setNext(pre);
            pre = curr;
            curr = next;
        }

        return pre;
    }

    public static ListNode reverseList_0206_2(ListNode head) {

        val listNode = reverseList_0206(head.getNext());
        val cur = head.getNext();

        head.setNext(null);
        cur.setNext(head);


        return listNode;
    }


    public static ListNode mergeTwoList(ListNode headA, ListNode headB) {
        ListNode preHead = new ListNode(-1);
        ListNode pre = preHead;

        while (headA != null && headB != null) {
            if (headA.getVal() < headB.getVal()) {
                pre.setNext(headA);
                headA = headA.getNext();
            } else {
                pre.setNext(headB);
                headB = headB.getNext();
            }
            pre = pre.getNext();
        }
        pre.setNext(headA.getNext() == null ? headB : headA);
        return preHead.getNext();


    }
    public static void main(String[] args) {


//       ListNode.print(reverseList_0206_2(ListNode.testListNode()));

//       ListNode.print(reverseList_0206_2(ListNode.testListNode()));


    }
}