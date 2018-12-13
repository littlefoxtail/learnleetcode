class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

    def __str__(self):
        return "ListNode(value=%(val)s, next=%(next)s)" % {'val': self.val, 'next': self.next}