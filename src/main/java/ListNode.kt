class ListNode(var `val`: Int = 0 ) {
  var next: ListNode? = null

  override fun toString(): String {
    return "ListNode(value=$`val`', next=$next)"
  }
}