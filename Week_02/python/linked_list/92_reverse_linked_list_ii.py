# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def reverseBetween(self, head: ListNode, left: int, right: int) -> ListNode:
        if left == 1:
            return self.reverseN(head, right)

        head.next = self.reverseBetween(head.next, left - 1, right - 1)

        return head

    n_plus_1 = None

    def reverseN(self, head: ListNode, n: int):
        if n == 1:
            self.n_plus_1 = head.next
            return head

        last = self.reverseN(head.next, n - 1)
        head.next.next = head

        head.next = self.n_plus_1

        return last
