/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

        Deque<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> result = new ArrayList<>();

        TreeNode node = root;

        if(node != null) {
            queue.add(node);
        }

        while(!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> levelResult = new ArrayList<>();
            for(int i=0; i<len; i++) {
                node = queue.poll();
                levelResult.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }

            result.add(levelResult);
        }

        return result;

    }
}
