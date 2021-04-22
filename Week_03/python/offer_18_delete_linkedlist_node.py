# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def deleteNode(self, head: ListNode, val: int) -> ListNode:
        if head.val == val:
            head = head.next
            return head

        node = head
        while node.next:
            if node.next.val == val:
                node.next = node.next.next
                break
            node = node.next

        return head

