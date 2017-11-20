
public class MergeTwoSortedList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
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

    public static void main(String[] args) throws Exception {
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
 
        ListNode newHead = new MergeTwoSortedList().mergeTwoLists_1(head, head3);
        ListNode link = newHead;
        while (link != null) {
            System.out.println(link.val);
            link = link.next;
        } 
    } 
}