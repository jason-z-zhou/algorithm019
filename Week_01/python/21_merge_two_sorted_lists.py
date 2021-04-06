from sys import maxsize


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        if not l1: return l2
        if not l2: return l1

        current = ListNode(-maxsize)
        dummy = current

        while l1 or l2:
            if not l1:
                current.next = l2
                break
            if not l2:
                current.next = l1
                break

            if l1.val > l2.val:
                current.next = l2
                l2 = l2.next
                current = current.next
            else:
                current.next = l1
                l1 = l1.next
                current = current.next

        return dummy.next
