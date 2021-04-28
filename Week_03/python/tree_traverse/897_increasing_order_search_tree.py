# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:

    def increasingBST(self, root: TreeNode) -> TreeNode:
        elements = self.inorder(root)

        root = TreeNode()
        head = root

        for ele in elements:
            root.right = TreeNode(ele)
            root = root.right

        return head.right


    def inorder(self, root: TreeNode):
        if not root:
            return []
        return self.inorder(root.left) + [root.val] + self.inorder(root.right)

