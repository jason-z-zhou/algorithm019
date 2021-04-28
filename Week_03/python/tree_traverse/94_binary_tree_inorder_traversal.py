# Definition for a binary tree node.
from collections import deque
from typing import List


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        return self.inorder(root)

    def inorder(self, root: TreeNode):
        if not root:
            return []

        return self.inorder(root.left) + [root.val] + self.inorder(root.right)


class Solution2:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        stack = deque()
        ans = []

        node = root

        while len(stack) > 0 or node:
            while node:
                stack.append(node)
                node = node.left

            node = stack.pop()
            ans.append(node.val)
            node = node.right

        return ans
