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
public class MergeTwoSortedList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    public ListNode mergeTT(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode tmp = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tmp.next = l1;
                l1 = l1.next;
            } else {
                tmp.next = l2;
                l2 = l2.next;
            }
            tmp = tmp.next;
        }
        tmp.next = l1 == null ? l2 : l1;
        return head.next;

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        else if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }

    public ListNode mergeTwoLists_1(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null) 
            return l1;
        ListNode mergeHead;
        ListNode temp1 = null;
        ListNode temp2 = null;
        if (l1.val < l2.val) {
            mergeHead = l1;
            temp1 = l1.next;
            temp2 = l2;
        } else {
            mergeHead = l2;
            temp1 = l1;
            temp2 = l2.next;
        }
        ListNode temp = mergeHead;
        while(temp1 != null && temp2 != null) {
            if (temp1.val < temp2.val) {
                                                                                                                                    
                temp.next = temp1;
                temp = temp1;
                temp1 = temp1.next;
            } else{
                temp.next = temp2;
                temp = temp2;
                temp2 = temp2.next;
            }
        }
        temp.next = temp1 == null ? temp2 : temp1;
        return mergeHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode head1 = new ListNode(3);
        ListNode head2 = new ListNode(8);
 
        ListNode head3 = new ListNode(1);
        ListNode head4 = new ListNode(2);
        ListNode head5 = new ListNode(7);
        ListNode head6 = new ListNode(10);
 
        head.next = head1;
        head1.next = head2;
 
        head3.next = head4;
        head4.next = head5;
        head5.next = head6;

        //0

        //ListNode newHead = new MergeTwoSortedList().mergeTwoLists_1(head, head3);
        ListNode link = new MergeTwoSortedList().mergeTT(head, head3);
        while (link != null) {
            System.out.println(link.val);
            link = link.next;
        }
    } 
}