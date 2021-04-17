# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def rob(self, root: TreeNode) -> int:
        rob, not_rob = self.dp(root)

        return max(rob, not_rob)

    def dp(self, root: TreeNode) -> [int, int]:
        if not root: return 0, 0

        left = self.dp(root.left)
        right = self.dp(root.right)

        rob = root.val + left[1] + right[1]
        not_rob = max(left[0], left[1]) + max(right[0], right[1])

        return rob, not_rob
