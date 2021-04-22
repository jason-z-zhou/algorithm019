class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int result = 0;
        while(!queue.isEmpty()){
            Queue<TreeNode> levelQueue = new LinkedList<>();
            while(queue.peek()!=null) {
                TreeNode node = queue.poll();
                if(node.left!=null) levelQueue.add(node.left);
                if(node.right!=null) levelQueue.add(node.right);
            }

            queue = levelQueue;
            result ++ ;
        }

        return result;
    }

}
