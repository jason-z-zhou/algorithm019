# Definition for a binary tree node.
from collections import deque


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def findTarget(self, root: TreeNode, k: int) -> bool:
        stack = deque()
        nums = set()

        stack.append(root)

        while stack:
            for i in range(len(stack)):
                elem = stack.pop()
                if k - elem.val in nums: return True
                if elem.left: stack.append(elem.left)
                if elem.right: stack.append(elem.right)
                nums.add(elem.val)

        return False
