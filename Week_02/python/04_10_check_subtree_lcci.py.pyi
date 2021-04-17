# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def checkSubTree(self, t1: TreeNode, t2: TreeNode) -> bool:
        t1_has_t2 = self.has_node(t1, t2)
        t2_has_t1 = self.has_node(t2, t1)

        if not t1_has_t2 and not t2_has_t1:
            return False

        if t1_has_t2:
            return self.compare(t1_has_t2, t2)
        else:
            return self.compare(t2_has_t1, t1)



    def has_node(self, t1: TreeNode, t2: TreeNode) -> TreeNode:
        if not t1 or not t2:
            return None

        if t1.val == t2.val:
            return t1

        left_found, right_found = None, None

        if t1.left:
            left_found = self.has_node(t1.left, t2)

        if t1.right:
            right_found = self.has_node(t1.right, t2)

        return left_found if left_found else right_found

    def compare(self, t1: TreeNode, t2: TreeNode) -> bool:
        if not t1 and t2 or t1 and not t2:
            return False

        if not t1 and not t2:
            return True

        if t1.val == t2.val:
            return self.compare(t1.left, t2.left) and self.compare(t1.right, t2.right)

