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

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;

        ListNode listNode = removeNthFromEnd(listNode1, 2);

        System.out.println(listNode);
    }

    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        @Override public String toString() {
            return "ListNode{" + "val=" + val + ", next=" + next + '}';
        }
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
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