public class DeleteNode {

  public static void main(String[] args) {
    ListNode listNode1 = new ListNode(1);
    ListNode listNode2 = new ListNode(2);
    ListNode listNode3 = new ListNode(3);
    ListNode listNode4 = new ListNode(4);

    listNode1.setNext(listNode2);
    listNode2.setNext(listNode3);
    listNode3.setNext(listNode4);
    System.out.println(listNode1);
    deleteNode(listNode3);
    System.out.println(listNode1);
  }

  public static void deleteNode(ListNode node) {
    node.setValue(node.getNext().getValue());
    node.setNext(node.getNext().getNext());
  }

}
