# Definition for a binary tree node.
from collections import deque
from typing import List


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        return self.preorder(root)

    def preorder(self, root: TreeNode):
        if not root: return []
        return [root.val] + self.preorder(root.left) + self.preorder(root.right)


class Solution0:
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        stack = deque()
        res = []

        node = root

        while len(stack) > 0 or node:
            while node:
                res.append(node.val)
                stack.append(node)
                node = node.left

            node = stack.pop()
            node = node.right

        return res
