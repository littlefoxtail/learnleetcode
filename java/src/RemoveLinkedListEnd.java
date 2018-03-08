/**
 *  删除链表中倒数第n个元素，利用双指针，已知n，可以确定一个指针是n，另一个指针是head
 * 两个指针同时循环平移到倒数第二，然后就可以进行删除元素，如果出现不合理的输入，就删除head
 * 
 * 
 * public class ListNode {
 *  int val;
 *  ListNode next;
 *  ListNode(int x) {val = x;}
 * }
 * 
 * 
 */
public class RemoveLinkedListEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = head;
        ListNode afterPreN = head;

        while(n-- !=0) {
            afterPreN = afterPreN.next;
        }
        if (afterPreN != null) {
            while(afterPreN.next != null) {
                pre = pre.next;
                afterPreN = afterPreN.next;
            }
            pre.next = pre.next.next;
        } else {
            head = head.next;
        }
        return head;
    }
}