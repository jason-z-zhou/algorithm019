/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// Recursion
class Solution0 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();

        helper(root, res);

        return res;
    }

    private void helper(TreeNode root, List<Integer> result){
        if(root == null) return;
        result.add(root.val);
        if(root.left != null) helper(root.left, result);
        if(root.right != null) helper(root.right, result);
    }
}


// Stack
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if(root == null) return res;

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;

        while(!stack.isEmpty() || node != null) {
            while(node != null) {
                res.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }

        return res;
    }
}
